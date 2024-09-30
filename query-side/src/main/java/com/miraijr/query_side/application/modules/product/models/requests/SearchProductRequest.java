package com.miraijr.query_side.application.modules.product.models.requests;

import com.miraijr.query_side.shared.models.requests.Pagination;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchProductRequest extends Pagination {
    @NotNull
    @NotEmpty
    private String prompt;
    private Float minPrice;
    private Float maxPrice;

    public void setDefaultValue() {
        if (this.minPrice == null) {
            this.minPrice = 1F;
        }

        if (this.maxPrice == null) {
            this.maxPrice = Float.MAX_VALUE;
        }

        this.setDefaultValuePagination();
    }
}
