package cafe.shop.testing.cafe.shop.login_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

  // private final CustomUserDetailsService uService;

  @Bean
  public UserDetailsService userDetailsService() {
    return new CustomUserDetailsService();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests(auth -> auth
        .requestMatchers("/").permitAll()
        .requestMatchers("/admin/**").hasAnyAuthority("Admin")
        .requestMatchers("/cashier/**").hasAnyAuthority("Cashier")
        .anyRequest().authenticated());

    http.formLogin()
        .loginPage("/login")
        .usernameParameter("username")
        .successHandler(successHandler)
        .loginProcessingUrl("/login")
        .permitAll()
        .and()
        .exceptionHandling()
          .accessDeniedPage("/forbidden")
        .and()
        .logout().logoutUrl("/logout")
        .logoutSuccessUrl("/")
        .permitAll();
    return http.build();

  }

  @Autowired
  private LoginSuccessHandler successHandler;

}