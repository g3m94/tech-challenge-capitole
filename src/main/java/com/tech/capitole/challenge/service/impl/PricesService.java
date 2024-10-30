package com.tech.capitole.challenge.service.impl;

import com.tech.capitole.challenge.model.RequestPrices;
import com.tech.capitole.challenge.dto.PricesDTO;
import com.tech.capitole.challenge.repository.IPricesRepository;
import com.tech.capitole.challenge.service.IPricesService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PricesService implements IPricesService {

    private final IPricesRepository pricesRepository;

    @Qualifier("priceMapper")
    private final ModelMapper mapper;

    @Override
    public Mono<PricesDTO> find(RequestPrices requestPrices) {
        return pricesRepository.findPricesBy(requestPrices.getBrandId(), requestPrices.getDateApply(), requestPrices.getProductId())
                .reduce((p1, p2) -> p1.getPriority() < p2.getPriority() ? p2 : p1)
                .map(price -> mapper.map(price, PricesDTO.class));
    }
}
