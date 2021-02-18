package com.vallegrande.vgteams.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.core.Ordered;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

   @Bean
   public JwtAccessTokenConverter tokenConverter() {
      JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
      converter.setSigningKey("este-es-un-seed-dificil");
      return converter;
   }

   @Bean
   public TokenStore tokenStore(JwtAccessTokenConverter tokenConverter) {
      return new JwtTokenStore(tokenConverter);
   }

   @Bean
   DefaultTokenServices tokenServices(TokenStore tokenStore, JwtAccessTokenConverter tokenConverter) {
      DefaultTokenServices tokenServices = new DefaultTokenServices();
      tokenServices.setTokenStore(tokenStore);
      tokenServices.setTokenEnhancer(tokenConverter);
      return tokenServices;
   }

   @Override
   public void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests()
            .antMatchers(HttpMethod.GET, "/**").hasAnyRole("STUDENT", "MONITOR")
            .antMatchers(HttpMethod.POST, "/").hasAnyRole( "MONITOR")
            .antMatchers(HttpMethod.PUT, "/").hasAnyRole("MONITOR")
            .antMatchers(HttpMethod.DELETE, "/{tutoringSessionId}").hasAnyRole("MONITOR")
            .anyRequest().authenticated()
            .and().cors().configurationSource(corsConfigurationSource());
   }

   @Bean
   public CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowedOrigins(Arrays.asList("https://vg-teams.vercel.app", "http://localhost:4200"));
      config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
      config.setAllowCredentials(true);
      config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));

      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", config);
      return source;
   }

   @Bean
   public FilterRegistrationBean<CorsFilter> corsFilter() {
      FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
      bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
      return bean;
   }
}
