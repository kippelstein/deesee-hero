package com.company.poc.web.configurations

import io.swagger.v3.oas.models.OpenAPI
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
internal class SwaggerConfig {
    @Bean
    fun apI(): OpenAPI {
        return OpenAPI()
    }
}
