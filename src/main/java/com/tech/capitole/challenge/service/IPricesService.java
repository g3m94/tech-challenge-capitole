package com.tech.capitole.challenge.service;

import com.tech.capitole.challenge.model.RequestPrices;
import com.tech.capitole.challenge.dto.PricesDTO;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

public interface IPricesService {

    Mono<PricesDTO> find(@Valid RequestPrices requestPrices);
}
