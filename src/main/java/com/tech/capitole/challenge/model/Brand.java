package com.tech.capitole.challenge.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("brand")
public class Brand {

    @Id
    private Long id;
    private String name;
}
