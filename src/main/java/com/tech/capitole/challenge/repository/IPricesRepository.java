package com.tech.capitole.challenge.repository;

import com.tech.capitole.challenge.model.Prices;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface IPricesRepository extends ReactiveCrudRepository<Prices, Long> {

    @Query("""
            SELECT A.*
            FROM PRICES A
            LEFT OUTER JOIN BRAND B ON A.BRAND_ID = B.ID
            WHERE B.ID = :brandId
            AND PARSEDATETIME(:dateApply , 'yyyy-M-d-H.m.s') BETWEEN PARSEDATETIME(A.START_DATE, 'yyyy-M-d-H.m.s') AND PARSEDATETIME(A.END_DATE, 'yyyy-M-d-H.m.s')
            AND A.PRODUCT_ID = :productId""")
    Flux<Prices> findPricesBy(
            @Param("brandId") Long brandId,
            @Param("dateApply") String dateApply,
            @Param("productId") Long productId);
}
