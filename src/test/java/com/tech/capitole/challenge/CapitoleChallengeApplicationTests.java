package com.tech.capitole.challenge;

import com.tech.capitole.challenge.controller.PricesControllerTest;
import com.tech.capitole.challenge.service.impl.PricesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(PricesControllerTest.class)
class CapitoleChallengeApplicationTests {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private PricesService pricesService;


    @Test
    void contextLoads() {
    }

}
