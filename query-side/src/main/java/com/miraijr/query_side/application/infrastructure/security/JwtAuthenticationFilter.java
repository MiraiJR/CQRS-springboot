package com.miraijr.query_side.application.infrastructure.security;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.miraijr.query_side.application.infrastructure.external_services.out.TokenHandlerPort;
import com.miraijr.query_side.application.infrastructure.security.exceptions.ExpiredTokenException;
import com.miraijr.query_side.application.infrastructure.security.exceptions.InvalidTokenException;
import com.miraijr.query_side.application.modules.account.entities.AccountTokenEntity;
import com.miraijr.query_side.application.modules.account.repositories.AccountTokenRepository;
import com.miraijr.query_side.shared.types.CustomAuthentication;
import com.miraijr.query_side.shared.types.enums.TokenType;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private static String BEARER = "Bearer ";
  private static String AUTHORIZATION_KEY = "Authorization";
  private final TokenHandlerPort tokenHandlerPort;
  private final AccountTokenRepository accountTokenRepository;
  private static final List<Pair<String, String>> BYPASS_TOKENS = Arrays.asList(
      Pair.of("/accounts/register", "POST"),
      Pair.of("/accounts/login", "POST"),
      Pair.of("/actuator/health", "GET"),
      Pair.of("/products/recommend", "GET"),
      Pair.of("/categories", "GET"));

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    if (isBypassToken(request)) {
      filterChain.doFilter(request, response);
      return;
    }

    String token = this.getToken(request);
    AccountTokenEntity accountToken = this.checkToken(token);
    CustomAuthentication customAuthentication = new CustomAuthentication(accountToken.getAccount().getId(),
        accountToken.getId());
    customAuthentication.setAuthenticated(true);
    SecurityContextHolder.getContext().setAuthentication(customAuthentication);
    filterChain.doFilter(request, response);
  }

  private boolean isBypassToken(HttpServletRequest request) {
    String requestPath = request.getServletPath();
    String requestMethod = request.getMethod();

    return BYPASS_TOKENS.contains(Pair.of(requestPath, requestMethod));
  }

  private String getToken(HttpServletRequest request) {
    String authHeader = request.getHeader(AUTHORIZATION_KEY);
    if (authHeader == null || !authHeader.startsWith(BEARER)) {
      throw new InvalidTokenException();
    }

    return authHeader.substring(BEARER.length());
  }

  private AccountTokenEntity checkToken(String token) {
    try {
      this.tokenHandlerPort.isTokenExpired(token, TokenType.ACCESS);
    } catch (Exception e) {
      throw new ExpiredTokenException();
    }

    Optional<AccountTokenEntity> matchedToken = this.accountTokenRepository.getByAccessToken(token);
    if (matchedToken.isEmpty()) {
      throw new InvalidTokenException();
    }

    return matchedToken.get();
  }
}
