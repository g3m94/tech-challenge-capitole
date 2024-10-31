package com.tech.capitole.challenge.service;

import com.tech.capitole.challenge.dto.PricesDTO;
import com.tech.capitole.challenge.model.RequestPrices;
import com.tech.capitole.challenge.service.impl.PricesService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Objects;

@SpringBootTest
public class PricesServiceTest {

    @Autowired
    private PricesService service;

    @Test
    @DisplayName("Return price when request at 10:00 on the 14th for product 35455 for brand 1")
    void returnPriceWhenIsRequestOne() {
        Mono<PricesDTO> pricesDTOMono = service.find(getRequestBodyTestOne());
        System.out.println("Result Test One: " + pricesDTOMono.block());

        StepVerifier.create(pricesDTOMono)
                .expectNextMatches(Objects::nonNull)
                .verifyComplete();
    }

    @Test
    @DisplayName("Return price when request at 16:00 on the 14th for product 35455 for brand 1")
    void returnPriceWhenIsRequestTwo() {
        Mono<PricesDTO> pricesDTOMono = service.find(getRequestBodyTestTwo());
        System.out.println("Result Test Two: " + pricesDTOMono.block());

        StepVerifier.create(pricesDTOMono)
                .expectNextMatches(Objects::nonNull)
                .verifyComplete();
    }

    @Test
    @DisplayName("Return price when request at 21:00 on the 14th for product 35455 for brand 1")
    void returnPriceWhenIsRequestThree() {
        Mono<PricesDTO> pricesDTOMono = service.find(getRequestBodyTestThree());
        System.out.println("Result Test Three: " + pricesDTOMono.block());

        StepVerifier.create(pricesDTOMono)
                .expectNextMatches(Objects::nonNull)
                .verifyComplete();
    }

    @Test
    @DisplayName("Return price when request at 10:00 on the 15th for product 35455 for brand 1")
    void returnPriceWhenIsRequestFour() {
        Mono<PricesDTO> pricesDTOMono = service.find(getRequestBodyTestFour());
        System.out.println("Result Test Four: " + pricesDTOMono.block());

        StepVerifier.create(pricesDTOMono)
                .expectNextMatches(Objects::nonNull)
                .verifyComplete();
    }

    @Test
    @DisplayName("Return price when request at 21:00 on the 16th for product 35455 for brand 1")
    void returnPriceWhenIsRequestFive() {
        Mono<PricesDTO> pricesDTOMono = service.find(getRequestBodyTestFive());
        System.out.println("Result Test Five: " + pricesDTOMono.block());

        StepVerifier.create(pricesDTOMono)
                .expectNextMatches(Objects::nonNull)
                .verifyComplete();
    }

    private RequestPrices getRequestBodyTestOne() {
        RequestPrices requestPrices = new RequestPrices();
        requestPrices.setProductId(35455L);
        requestPrices.setBrandId(1L);
        requestPrices.setDateApply("2020-06-14-10.00.00");
        return requestPrices;
    }

    private RequestPrices getRequestBodyTestTwo() {
        RequestPrices requestPrices = new RequestPrices();
        requestPrices.setProductId(35455L);
        requestPrices.setBrandId(1L);
        requestPrices.setDateApply("2020-06-14-16.00.00");
        return requestPrices;
    }

    private RequestPrices getRequestBodyTestThree() {
        RequestPrices requestPrices = new RequestPrices();
        requestPrices.setProductId(35455L);
        requestPrices.setBrandId(1L);
        requestPrices.setDateApply("2020-06-14-21.00.00");
        return requestPrices;
    }

    private RequestPrices getRequestBodyTestFour() {
        RequestPrices requestPrices = new RequestPrices();
        requestPrices.setProductId(35455L);
        requestPrices.setBrandId(1L);
        requestPrices.setDateApply("2020-06-15-10.00.00");
        return requestPrices;
    }

    private RequestPrices getRequestBodyTestFive() {
        RequestPrices requestPrices = new RequestPrices();
        requestPrices.setProductId(35455L);
        requestPrices.setBrandId(1L);
        requestPrices.setDateApply("2020-06-16-21.00.00");
        return requestPrices;
    }

}
