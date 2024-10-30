package com.tech.capitole.challenge.repository;

import com.tech.capitole.challenge.model.Brand;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BrandRepository extends ReactiveCrudRepository<Brand, Long> {
}
