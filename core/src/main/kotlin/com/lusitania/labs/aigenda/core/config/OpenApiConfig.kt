package com.lusitania.labs.aigenda.core.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenAPI(
        @Value("\${application.description}") appDescription: String?,
        @Value("\${application.version}") appVersion: String?,
        @Value("\${application.name}") appName: String?
    ): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title(appName)
                    .version(appVersion)
                    .description(appDescription)
            )
    }
}
