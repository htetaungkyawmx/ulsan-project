//package org.mdt.ulsanproject.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//@Configuration
//public class WebConfig {
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.addAllowedOrigin("http://localhost:3000");  // Allow React app running on port 3000
//        corsConfig.addAllowedMethod("*");  // Allow all methods (GET, POST, PUT, DELETE, etc.)
//        corsConfig.addAllowedHeader("*");  // Allow all headers
//        corsConfig.setAllowCredentials(true);  // Allow credentials (cookies, etc.)
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig);  // Apply CORS globally
//
//        return source;
//    }
//}
