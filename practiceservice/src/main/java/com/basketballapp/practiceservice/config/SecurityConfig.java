// package com.basketballapp.practiceservice.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.config.ConfigurableBeanFactory;

// import static org.springframework.security.config.Customizer.withDefaults;

// import java.util.Collection;
// import java.util.Map;

// // import org.keycloak.adapters.KeycloakConfigResolver;
// // import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
// // import org.keycloak.adapters.springsecurity.KeycloakSecurityComponents;
// // import
// //
// org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
// // import
// // org.keycloak.adapters.springsecurity.client.KeycloakClientRequestFactory;
// // import org.keycloak.adapters.springsecurity.client.KeycloakRestTemplate;
// // import
// //
// org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.beans.factory.config.ConfigurableBeanFactory;
// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.ComponentScan;
// // import org.springframework.context.annotation.Configuration;
// // import org.springframework.context.annotation.Scope;
// // import
// //
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// // import
// // org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // import
// //
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// // import org.springframework.security.config.http.SessionCreationPolicy;
// // import
// // org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
// // import org.springframework.security.core.session.SessionRegistryImpl;
// // import org.springframework.security.web.DefaultSecurityFilterChain;
// // import
// //
// org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
// // import
// //
// org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
// // import org.springframework.security.web.server.SecurityWebFilterChain;

// // @Configuration
// // @EnableWebSecurity
// // @ComponentScan(basePackageClasses = KeycloakSecurityComponents.class)
// // public class SecurityConfig {

// // @Autowired
// // public KeycloakClientRequestFactory keycloakClientRequestFactory;

// // @Bean
// // public SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws
// // Exception {
// // http
// // .oauth2Client()
// // .disable()
// // .authorizeHttpRequests()
// // .anyRequest()
// // .authenticated();

// // http.oauth2ResourceServer().jwt();

// // http.sessionManagement()
// // .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

// // return http.build();

// // }

// // // @Bean
// // // public KeycloakConfigResolver KeycloakConfigResolver() {
// // // return new KeycloakSpringBootConfigResolver();
// // // }

// // // @Bean
// // // @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// // // public KeycloakRestTemplate keycloakRestTemplate() {
// // // return new KeycloakRestTemplate(keycloakClientRequestFactory);
// // // }
// // }

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Scope;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.Customizer;
// import
// org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import
// org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import
// org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import
// org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import
// org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import
// org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
// import org.springframework.security.core.session.SessionRegistryImpl;
// import org.springframework.security.web.SecurityFilterChain;
// import
// org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
// import
// org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
// import
// org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
// import
// org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
// import
// org.springframework.security.oauth2.server.resource.web.DefaultBearerTokenResolver;

// import com.google.common.net.HttpHeaders;
// import com.optimagrowth.license.service.LicenseService;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

// @Bean
// public SecurityFilterChain configure(HttpSecurity http) throws Exception {
// http
// .oauth2Client()
// .and()
// .oauth2Login()
// .tokenEndpoint()
// .and()
// .userInfoEndpoint();

// http
// .sessionManagement()
// .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

// http
// .authorizeHttpRequests()
// .requestMatchers("/unauthenticated", "/oauth2/**", "/login/**").permitAll()
// .anyRequest()
// .fullyAuthenticated()
// .and()
// .logout()
// .logoutSuccessUrl(
// "http://localhost:8080/realms/ostock/protocol/openid-connect/logout?redirect_uri=http://localhost:8081/");

// return http.build();
// }

// // @Bean
// // BearerTokenResolver bearerTokenResolver() {
// // DefaultBearerTokenResolver bearerTokenResolver = new
// // DefaultBearerTokenResolver();
// //
// bearerTokenResolver.setBearerTokenHeaderName(HttpHeaders.PROXY_AUTHORIZATION);
// // return bearerTokenResolver;
// // }
// }