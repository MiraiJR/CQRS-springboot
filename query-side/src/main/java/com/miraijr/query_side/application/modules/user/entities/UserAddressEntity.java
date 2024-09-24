package com.miraijr.query_side.application.modules.user.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_addresses")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(nullable = false)
  private String province;
  @Column(nullable = false)
  private String district;
  @Column(nullable = false)
  private String ward;
  @Column(nullable = false, name = "home_address")
  private String homeAddress;
  @Column(nullable = false)
  private Integer type;
  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;
}
