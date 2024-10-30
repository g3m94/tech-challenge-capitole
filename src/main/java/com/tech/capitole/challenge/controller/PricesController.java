package com.tech.capitole.challenge.controller;

import com.tech.capitole.challenge.model.RequestPrices;
import com.tech.capitole.challenge.dto.PricesDTO;
import com.tech.capitole.challenge.service.IPricesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PricesController {

    private final IPricesService pricesService;

    @PostMapping("/find")
    public Mono<ResponseEntity<PricesDTO>> getPrices(@Valid @RequestBody RequestPrices requestPrices) {
        return pricesService.find(requestPrices)
                .map(response -> ResponseEntity.ok().body(response))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
