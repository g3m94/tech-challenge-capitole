package com.tech.capitole.challenge.controller;

import com.tech.capitole.challenge.dto.PricesDTO;
import com.tech.capitole.challenge.model.RequestPrices;
import com.tech.capitole.challenge.model.SuccessResponse;
import com.tech.capitole.challenge.service.IPricesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = PricesController.class)
public class PricesControllerTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private IPricesService service;

    private PricesDTO pricesDTO;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        pricesDTO = new PricesDTO();
        pricesDTO.setProductId(35455L);
        pricesDTO.setBrandId(1L);
        pricesDTO.setPriceList(2L);
        pricesDTO.setStartDate("dom, 14 junio 2020 15:00:00 GMT+02:00");
        pricesDTO.setEndDate("dom, 14 junio 2020 18:30:00 GMT+02:00");
        pricesDTO.setPrice(25.45);
    }

    @Test
    @DisplayName("Return success response when find fee")
    void returnSuccessResponseWhenFindFee() {
        when(service.find(getRequestBody())).then(invocationOnMock -> Mono.just(pricesDTO));

        WebTestClient.ResponseSpec responseSpec = webClient.post()
                .uri("/prices/find")
                .bodyValue(getRequestBody())
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        responseSpec
                .expectStatus().isOk()
                .expectBody(SuccessResponse.class)
                .consumeWith(response -> System.out.println("Response: " + response.getResponseBody()));
    }

    private RequestPrices getRequestBody() {
        RequestPrices requestPrices = new RequestPrices();
        requestPrices.setProductId(35455L);
        requestPrices.setBrandId(1L);
        requestPrices.setDateApply("2020-06-14-16.00.00");
        return requestPrices;
    }
}
