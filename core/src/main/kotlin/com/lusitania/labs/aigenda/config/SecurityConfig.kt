package com.lusitania.labs.aigenda.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


@Configuration
class SecurityConfig(
        @Value("\${security.enabled:true}")
        private val isSecurityEnabled: Boolean
) {

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration().apply {
            allowedOrigins = listOf("*")
            allowedMethods = listOf("*")
            allowedHeaders = listOf("*")
        }
        val source = UrlBasedCorsConfigurationSource().apply {
            registerCorsConfiguration("/**", configuration)
        }
        return source
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.invoke {
            cors { }
            csrf { disable() }
            if (isSecurityEnabled) {
                authorizeRequests {
                    authorize("/actuator/**", permitAll)
                    authorize("/resources/**", permitAll)
                    authorize("/static/**", permitAll)
                    authorize("/.well-known/**", permitAll)
                    authorize("/logo.png", permitAll)
                    authorize("/openapi", permitAll)
                    authorize(anyRequest, authenticated)
                }
                formLogin { }
            } else {
                authorizeRequests {
                    authorize(anyRequest, permitAll)
                }
            }
        }
        return http.build()
    }
}
