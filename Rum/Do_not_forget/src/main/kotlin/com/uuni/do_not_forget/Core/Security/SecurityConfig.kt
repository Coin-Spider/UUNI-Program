package com.uuni.do_not_forget.Core.Security

import com.uuni.do_not_forget.Filter.JWT.JwtAuthenticationTokenFilter
import org.apache.tomcat.util.http.parser.Authorization
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.csrf.CsrfTokenRequestHandler
import org.springframework.web.cors.CorsConfiguration

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwt: JwtAuthenticationTokenFilter,
){
    @Bean
    fun filterChain(http: HttpSecurity, environment: Environment): SecurityFilterChain {
        val requestHandler:CsrfTokenRequestHandler
        if (environment.getProperty("spring.h2.console.enabled", Boolean::class.java, false)) {
            // 若开启 h2-console 则允许 iframe
            http.headers { headers ->
                headers.frameOptions { frameOptions ->
                    frameOptions.disable()
                }
            }
        }

        http.csrf { csrf ->
            csrf.disable()
        }

        http.httpBasic { httpBasic ->
            httpBasic.disable()
        }

        http.addFilterBefore(JwtAuthenticationTokenFilter(),UsernamePasswordAuthenticationFilter::class.java)
        http.authorizeHttpRequests { authorizeHttpRequests->
            authorizeHttpRequests
                .requestMatchers("/**").permitAll()
        }

        return http.build()
    }
}