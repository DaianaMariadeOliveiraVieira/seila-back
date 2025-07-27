package com.cefet.ds_projeto_seila.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.cefet.ds_projeto_seila.security.JwtAuthenticationFilter;
import com.cefet.ds_projeto_seila.services.ClienteDetailsService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class SecurityConfig {

    @Autowired
    private ClienteDetailsService clienteDetailsService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/h2-console/**").permitAll()
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                .requestMatchers(HttpMethod.POST, "/clientes").permitAll()
                .requestMatchers(HttpMethod.POST, "/auth").permitAll()

                // Clientes
                .requestMatchers(HttpMethod.GET, "/clientes/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/clientes/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/clientes/**").hasRole("CLIENTE")
                .requestMatchers(HttpMethod.DELETE, "/clientes/**").hasRole("ADMIN")
                // Filmes
                .requestMatchers(HttpMethod.GET, "/filmes/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/filmes").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/filmes/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/filmes/**").hasRole("ADMIN")
                //Filmes por gênero
                .requestMatchers(HttpMethod.GET, "/filmes/genero/**").permitAll()
                 .requestMatchers(HttpMethod.POST, "/filmes/genero").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/filmes/genero/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/filmes/genero/**").hasRole("ADMIN")
                //Historico
                .requestMatchers(HttpMethod.GET, "/historico/**").hasAnyRole("ADMIN", "CLIENTE") // Permite que clientes vejam seu histórico e admin veja todos tbm
                .requestMatchers(HttpMethod.POST, "/historico/**").hasRole("CLIENTE")
                .requestMatchers(HttpMethod.PUT, "/historico/**").hasRole("CLIENTE")
                .requestMatchers(HttpMethod.DELETE, "/historico/**").hasRole("CLIENTE")
                //Perfil
                .requestMatchers(HttpMethod.GET, "/perfil/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/perfil/**").hasRole("CLIENTE")
                .requestMatchers(HttpMethod.PUT, "/perfil/**").hasRole("CLIENTE")
                .requestMatchers(HttpMethod.DELETE, "/perfil/**").hasRole("ADMIN")
                
                // Avaliações
                .requestMatchers(HttpMethod.GET, "/avaliacoes/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/avaliacoes/**").hasRole("CLIENTE")
                .requestMatchers(HttpMethod.PUT, "/avaliacoes/**").hasRole("CLIENTE")
                .requestMatchers(HttpMethod.DELETE, "/avaliacoes/**").hasRole("ADMIN")
                //Genero
                .requestMatchers(HttpMethod.GET, "/generos/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/generos").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/generos/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/generos/**").hasRole("ADMIN")
                // Assinaturas
                .requestMatchers(HttpMethod.GET, "/assinaturas/**").hasAnyRole("ADMIN", "CLIENTE")
                .requestMatchers(HttpMethod.POST, "/assinaturas").hasRole("CLIENTE")
                .requestMatchers(HttpMethod.PUT, "/assinaturas/**").hasRole("CLIENTE")
                .requestMatchers(HttpMethod.DELETE, "/assinaturas/**").hasRole("ADMIN")
                // Planos (geralmente só ADMIN mexe)
                .requestMatchers(HttpMethod.GET, "/planos/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/planos").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/planos/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/planos/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .headers(headers -> headers.frameOptions().disable()) // Para H2 Console
            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(clienteDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
      return new WebMvcConfigurer() {
          @Override
          public void addCorsMappings(CorsRegistry registry) {
              registry.addMapping("/**")
                  .allowedOrigins("http://localhost:4200")
                  .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                  .allowedHeaders("*")
                  .allowCredentials(true);
          }
      };
    }
}
