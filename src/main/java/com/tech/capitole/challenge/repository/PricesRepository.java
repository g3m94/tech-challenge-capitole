package com.tech.capitole.challenge.repository;

import com.tech.capitole.challenge.model.Prices;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface PricesRepository extends ReactiveCrudRepository<Prices, Long> {
}
