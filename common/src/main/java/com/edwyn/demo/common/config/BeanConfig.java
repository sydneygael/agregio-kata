package com.edwyn.demo.common.config;

import com.edwyn.demo.offers.domain.OffersFactory;
import com.edwyn.demo.port.UseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "com.edwyn.demo",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = UseCase.class)
)
public class BeanConfig {

    @Bean
    public OffersFactory offerDomainService() {
        return new OffersFactory();
    }
}
