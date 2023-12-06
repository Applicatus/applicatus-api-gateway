package com.example.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import reactor.core.publisher.Mono;
//import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
//import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;

@Configuration
@EnableWebFluxSecurity
//@CrossOrigin(origins = "http://localhost:3000")
//@RequireArgsConstructor
public class SecurityConfig {


//    @Bean
//    public CorsWebFilter corsFilter() {
//        org.springframework.web.cors.CorsConfiguration corsConfiguration = new org.springframework.web.cors.CorsConfiguration();
//        corsConfiguration.setAllowCredentials(true);
//        corsConfiguration.getAllowedOriginPatterns();
////        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
//        corsConfiguration.addAllowedHeader("origin");
//        corsConfiguration.addAllowedHeader("content-type");
//        corsConfiguration.addAllowedHeader("accept");
//        corsConfiguration.addAllowedHeader("authorization");
//        corsConfiguration.addAllowedHeader("cookie");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfiguration);
//        return new CorsWebFilter(source);
//    }

//    private final AuthTokenFilter jwtFilter;
//    private final AuthenticationProvider authenticationProvider;
//

//        @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedOrigins("http://localhost:8072","http://localhost:3000");
//            }
//        };
//    }

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(exchanges -> exchanges
                                .pathMatchers(HttpMethod.POST, "/post-service/api/post/**").hasRole("USER")
                                .pathMatchers(HttpMethod.PUT, "/post-service/api/post/**").hasRole("USER")
                                .pathMatchers(HttpMethod.DELETE, "/post-service/api/post/**").hasRole("USER")
                                .pathMatchers(HttpMethod.GET, "/post-service/api/post").hasRole("USER")
                                .pathMatchers(HttpMethod.POST, "/post-service/api/post/**").hasRole("USER")
//                        .pathMatchers(HttpMethod.POST, "/api/post/**").hasRole("USER").authenticated()
//                                .pathMatchers(HttpMethod.PUT, "/api/post/**").permitAll()
                                .pathMatchers(HttpMethod.GET, "/user-service/api/user/**").permitAll()
                                .pathMatchers(HttpMethod.GET, "/user-service/api/user/{username}/info").hasAnyRole()
                                .pathMatchers(HttpMethod.GET, "/user-service/api/user/getAll").permitAll()
                                .pathMatchers(HttpMethod.PUT, "/user-service/api/user/**").permitAll()
                                .pathMatchers(HttpMethod.DELETE, "/user-service/api/user/**").permitAll()


//                        .pathMatchers(HttpMethod.GET, "/api/post/**/api/order/getUserOrder").authenticated()
//                        .pathMatchers(HttpMethod.POST, "/api/post/**/api/order/placeOrder").authenticated()
//                        .pathMatchers(HttpMethod.POST, "/api/post/**/api/order/**").hasRole("ADMIN")
//                        .pathMatchers(HttpMethod.PUT, "/api/post/**/api/order/**").hasRole("ADMIN")
//                        .pathMatchers(HttpMethod.DELETE, "/api/post/**/api/order/**").hasRole("ADMIN")
//                        .pathMatchers(HttpMethod.DELETE, "/inventory-service/api/invertory/**").hasRole("ADMIN")
//                        .pathMatchers(HttpMethod.GET, "/post-service/api/product/getAll").permitAll()
                                .pathMatchers(HttpMethod.POST, "/user-service/api/auth/register").permitAll()
                                .pathMatchers(HttpMethod.POST, "/user-service/api/auth/login").permitAll()
                                .pathMatchers(HttpMethod.POST, "/user-service/api/auth/**").permitAll()
                                .pathMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                                .pathMatchers(HttpMethod.GET, "/actuator/gateway/routes").permitAll()
                );
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//                http.oauth2ResourceServer( oauth2 -> oauth2
//                                .jwt(jwtSpec -> jwtSpec.jwtAuthenticationConverter()));



//                .oauth2ResourceServer(oauth2ResourceServer ->
//                oauth2ResourceServer
//                        .jwt
//                                (jwt -> jwt
//                                        .jwtAuthenticationConverter(grantedAuthoritiesExtractor())
//                                )
        http.httpBasic(httpBasicSpec -> httpBasicSpec.disable());
        http.csrf(csrfSpec -> csrfSpec.disable().formLogin(formLoginSpec -> formLoginSpec.disable()));

        return http.build();
    }
        ;
//                .oauth2ResourceServer(
//                        oauth2ResourceServer -> oauth2ResourceServer.jwt.jwtDecoder()
//        ).jwt().jwtAuthenticationConverter().jwtDecoder();
//
//                .oauth2ResourceServer(oauth2ResourceServer ->
//                        oauth2ResourceServer
//                                .jwt
//                                        (jwt -> jwt
//                                        .jwtAuthenticationConverter(grantedAuthoritiesExtractor())
//                                )
//                );

//                  .oauth2ResourceServer(
//                oauth2ResourceServer -> oauth2ResourceServer
//                        .jwt(jwt -> jwt.jwtDecoder(jwtDecoder))

//
//
//
////                .oauth2ResourceServer(oauth2ResourceServer ->
////                        oauth2ResourceServer
////                                .jwt(jwt -> jwt
////                                        .jwtAuthenticationConverter(grantedAuthoritiesExtractor())
////                                )
////                );
//
////                .oauth2ResourceServer((oauth2) -> oauth2.jwt((Customizer<ServerHttpSecurity.OAuth2ResourceServerSpec.JwtSpec>)))
////
////                .oauth2ResourceServer().jwt().jwtAuthenticationConverter(grantedAuthoritiesExtractor()).and()
////                .and().csrf().disable();
//
//        return http.build();
//    }
//
//    @Bean
//    public ReactiveJwtDecoder reactiveJwtDecoder() {
//        // Replace "your-jwk-set-uri" with the actual URL of your JSON Web Key Set (JWKS) endpoint.
//        return ReactiveJwtDecoders.fromIssuerLocation("your-jwk-set-uri");
//    }
//
//    Converter<Jwt, Mono<AbstractAuthenticationToken>> grantedAuthoritiesExtractor(){
//        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
//       // jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());
//        return new ReactiveJwtAuthenticationConverterAdapter(jwtAuthenticationConverter);
//    }
//}
    }
