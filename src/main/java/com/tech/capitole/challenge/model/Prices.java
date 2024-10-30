package com.tech.capitole.challenge.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("prices")
public class Prices {

    @Id
    private Long id;
    @Column("brand_id")
    private Long brandId;
    private String startDate;
    private String endDate;
    private Long priceList;
    private Long productId;
    private int priority;
    private double price;
    private String currency;


}
