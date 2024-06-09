package com.foot.stamp.config.swagger

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApiDocsConfig {
    @Bean
    fun publicApi(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("public-api")
            .pathsToMatch("/api/**")
            .build()
    }

    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .info(Info().title("발자꾹 API").version("1.0.0"))
    }
}
