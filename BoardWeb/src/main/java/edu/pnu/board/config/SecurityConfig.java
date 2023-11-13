package edu.pnu.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(csrf->csrf.disable());
		
		http.authorizeHttpRequests(auth->auth
				.requestMatchers(new AntPathRequestMatcher("/board/**")).authenticated()
				.requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("ADMIN")
				.anyRequest().permitAll());
		
		http.formLogin(frm->frm
				.loginPage("/system/login")
				.defaultSuccessUrl("/board/getBoardList", true));
		
		http.oauth2Login(oauth2->{
			oauth2.loginPage("/login");
		});
		
		http.exceptionHandling(ex->ex
				.accessDeniedPage("/system/accessDenied"));
		
		http.logout(logout->logout
				.logoutUrl("/system/logout")
				.invalidateHttpSession(true)
				.logoutSuccessUrl("/"));
		
		return http.build();
	}
}
