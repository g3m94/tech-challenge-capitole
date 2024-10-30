package com.tech.capitole.challenge.dto;

import lombok.Data;

@Data
public class PricesDTO {

    private Long productId;
    private Long brandId;
    private Long priceList;
    private String startDate;
    private String endDate;
    private Double price;

}
