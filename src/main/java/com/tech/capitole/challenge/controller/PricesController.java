package com.tech.capitole.challenge.controller;

import com.tech.capitole.challenge.dto.PricesDTO;
import com.tech.capitole.challenge.model.RequestPrices;
import com.tech.capitole.challenge.model.SuccessResponse;
import com.tech.capitole.challenge.service.IPricesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/prices")
@RequiredArgsConstructor
public class PricesController {

    private final IPricesService pricesService;

    @PostMapping("/find")
    public Mono<ResponseEntity<SuccessResponse<PricesDTO>>> getPrices(@Validated @RequestBody RequestPrices requestPrices) {
        return pricesService.find(requestPrices)
                .map(response ->
                        ResponseEntity.ok()
                                .body(new SuccessResponse<>(response)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
