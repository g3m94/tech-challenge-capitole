package com.tech.capitole.challenge.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestPrices {
    @NotNull
    private String dateApply;

    @NotNull
    private Long productId;

    @NotNull
    private Long brandId;
}
