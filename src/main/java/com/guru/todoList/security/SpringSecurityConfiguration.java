package com.guru.todoList.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public InMemoryUserDetailsManager createUserDetails() {		
		UserDetails userDetails = createNewUser("gurunadh", "1234");
		UserDetails userDetails2 = createNewUser("guru", "1234");
		return new InMemoryUserDetailsManager(userDetails, userDetails2);
	}

	public UserDetails createNewUser(String username, String password) {
		Function<String, String> encoder = pwd -> userPasswordEncoder().encode(password);
		UserDetails userDetails = User.builder()
				.username(username)
				.roles("user", "admin")
				.passwordEncoder(encoder)
				.password(password)
				.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder userPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
			auth -> auth.anyRequest().authenticated()
		);
		http.formLogin(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		http.headers(header -> header.frameOptions(frames -> frames.disable()));
		
		return http.build();
	}
}
