package com.example.apigateway.config;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.server.SecurityWebFilterChain;

import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.config.CorsRegistry;

import java.util.Arrays;
import java.util.List;


@Configuration
//@EnableWebFluxSecurity
@EnableWebSecurity
public class SecurityConfig {


//

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

    //----CorsFilterChain

//@Bean
//    public WebMvcAutoConfiguration corsConfiguration(){
//        return new WebMvcAutoConfiguration(){
//            public void addCorsMapping(CorsRegistry registry){
//                registry.addMapping("**").allowedOrigins("http://localhost:3000")
//                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH")
//                        .allowCredentials(true)
//                        .allowedHeaders("*");
//            }
//        };
//    }


    public CorsConfigurationSource configurationSourceLink() {
        CorsConfiguration configuration = new CorsConfiguration();

//        configuration.addAllowedOrigin("http://localhost:3000");
//        configuration.addAllowedOrigin("*");
        configuration.setAllowedOrigins(List.of("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("HEAD", "GET", "PUT", "POST", "DELETE", "OPTIONS"));
//        org.springframework.web.cors.UrlBasedCorsConfigurationSource source = new org.springframework.web.cors.UrlBasedCorsConfigurationSource();
//        WebFlux
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }


    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {

//        http.authorizeExchange(exchanges -> exchanges
//                                .pathMatchers(HttpMethod.POST, "/post-service/api/post/**").hasRole("USER")
//                                .pathMatchers(HttpMethod.PUT, "/post-service/api/post/**").hasRole("USER")
//                                .pathMatchers(HttpMethod.DELETE, "/post-service/api/post/**").hasRole("USER")
//                                .pathMatchers(HttpMethod.GET, "/post-service/api/post").hasRole("USER")
//                                .pathMatchers(HttpMethod.POST, "/post-service/api/post/**").hasRole("USER")
////                        .pathMatchers(HttpMethod.POST, "/api/post/**").hasRole("USER").authenticated()
////                                .pathMatchers(HttpMethod.PUT, "/api/post/**").permitAll()
//                                .pathMatchers(HttpMethod.GET, "/user-service/api/user/**").permitAll()
//                                .pathMatchers(HttpMethod.GET, "/user-service/api/user/{username}/info").permitAll()
//                                .pathMatchers(HttpMethod.GET, "/user-service/api/user/getAll").permitAll()
//                                .pathMatchers(HttpMethod.PUT, "/user-service/api/user/**").permitAll()
//                                .pathMatchers(HttpMethod.DELETE, "/user-service/api/user/**").permitAll()
//
//
////                        .pathMatchers(HttpMethod.GET, "/api/post/**/api/order/getUserOrder").authenticated()
////                        .pathMatchers(HttpMethod.POST, "/api/post/**/api/order/placeOrder").authenticated()
////                        .pathMatchers(HttpMethod.POST, "/api/post/**/api/order/**").hasRole("ADMIN")
////                        .pathMatchers(HttpMethod.PUT, "/api/post/**/api/order/**").hasRole("ADMIN")
////                        .pathMatchers(HttpMethod.DELETE, "/api/post/**/api/order/**").hasRole("ADMIN")
////                        .pathMatchers(HttpMethod.DELETE, "/inventory-service/api/invertory/**").hasRole("ADMIN")
////                        .pathMatchers(HttpMethod.GET, "/post-service/api/product/getAll").permitAll()
//                                .pathMatchers(HttpMethod.POST, "/user-service/api/auth/register").permitAll()
//                                .pathMatchers(HttpMethod.POST, "/user-service/api/auth/login").permitAll()
//                                .pathMatchers(HttpMethod.POST, "/user-service/api/auth/**").permitAll()
//                                .pathMatchers(HttpMethod.GET, "/actuator/**").permitAll()
//                                .pathMatchers(HttpMethod.GET, "/actuator/gateway/routes").permitAll()
//                );
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


        http.formLogin(formLoginSpec -> formLoginSpec.disable());
        http.httpBasic(httpBasicSpec -> httpBasicSpec.disable());
        http.cors(corsSpec -> corsSpec.configurationSource(configurationSourceLink()));
//        http.csrf(csrfSpec -> csrfSpec.disable()formLogin(formLoginSpec -> formLoginSpec.disable()));
        http.csrf(csrfSpec -> csrfSpec.disable());

        return http.build();
    }
        ;
//
//}
    }
