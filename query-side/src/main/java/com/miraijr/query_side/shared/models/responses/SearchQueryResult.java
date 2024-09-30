package com.miraijr.query_side.shared.models.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchQueryResult<SearchQuery, Result> {
    private SearchQuery query;
    private Result result;
}
