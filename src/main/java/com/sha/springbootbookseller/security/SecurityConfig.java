package com.sha.springbootbookseller.security;


import com.sha.springbootbookseller.repository.IUserRepository;
import com.sha.springbootbookseller.security.jwt.JwtAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig  {

    private final JwtAuthorizationFilter jwtAuthFilter;

   //private final AuthenticationProvider authenticationProvider;

//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//
//    http.csrf(withDefaults())
//            .authorizeHttpRequests()
//            .requestMatchers("/api/v1/auth/**")
//            .permitAll()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
//            .authenticationProvider(authenticationProvider)
//            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//
//    return http.build();
//}




    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
        http.csrf(withDefaults());
        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        http.sessionManagement(withDefaults());

        //jwt filter
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }

    @Bean
    private PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }





//    @Bean
//    public JwtAuthorizationFilter jwtAuthorizationFilter(){
//        return new JwtAuthorizationFilter();
//    }



//     @Bean
//    public WebMvcConfigurer corsConfigurer(){
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("*")
//                        .allowedMethods("*");
//            }
//        };
//        @Bean
//         public CorsConfiguration corsConfiguration(){
//            CorsConfiguration configuration = new CorsConfiguration();
//             configuration.
//
//
//         }



    }


