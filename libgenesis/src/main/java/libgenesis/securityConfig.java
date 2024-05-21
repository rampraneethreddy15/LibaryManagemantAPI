package libgenesis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class securityConfig {
	
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		
		UserDetails admin = User.withUsername("ram").password(encoder.encode("12345")).roles("ADMIN").build();
		UserDetails user = User.withUsername("keerthi").password(encoder.encode("54321")).roles("USER").build();
		
		return new InMemoryUserDetailsManager(admin, user);
	 
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Throwable {
		
		return http
			.csrf((csrf) -> csrf.disable())
			.authorizeHttpRequests(registry -> {
			registry.requestMatchers("books").permitAll();
			registry.requestMatchers("transactions/**").hasRole("ADMIN");
			registry.requestMatchers("books/authors").hasRole("USER");
			registry.anyRequest().authenticated();
		})
			.formLogin(formLogin -> formLogin.permitAll())
			.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}

}
