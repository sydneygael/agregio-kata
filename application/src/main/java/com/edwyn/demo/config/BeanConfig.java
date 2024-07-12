package com.edwyn.demo.config;

import com.edwyn.demo.domain.service.OfferDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public OfferDomainService offerDomainService() {
        return new OfferDomainService();
    }
}
