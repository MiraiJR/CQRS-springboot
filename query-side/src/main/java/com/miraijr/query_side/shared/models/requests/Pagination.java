package com.miraijr.query_side.shared.models.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {
    private Integer page;
    private Integer size;

    public void setDefaultValuePagination() {
        if (this.page == null) {
            this.page = 1;
        }

        if (this.size == null) {
            this.size = 10;
        }
    }
}
