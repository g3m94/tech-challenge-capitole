package com.tech.capitole.challenge.config;

import com.tech.capitole.challenge.dto.PricesDTO;
import com.tech.capitole.challenge.model.Prices;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.tech.capitole.challenge.util.Utils.formatDate;

@Configuration
public class MapperConfig {

    @Bean("priceMapper")
    public ModelMapper pricesMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        Converter<String, String> dateFormatter = ctx -> formatDate(ctx.getSource());

        mapper.typeMap(Prices.class, PricesDTO.class)
                .addMappings(map -> map.using(dateFormatter)
                        .map(Prices::getStartDate, PricesDTO::setStartDate))
                .addMappings(map -> map.using(dateFormatter)
                        .map(Prices::getEndDate, PricesDTO::setEndDate));

        return mapper;
    }
}
