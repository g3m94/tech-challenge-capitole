package com.tech.capitole.challenge.controller;

import com.tech.capitole.challenge.service.PricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PricesController {

    private PricesService pricesService;

}
