package com.valne;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import com.valne.entity.Account;
import com.valne.service.AccountService;
import com.valne.service.SessionService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
// ke thua  WebSecurityConfigurerAdapter
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	tiem bean accountService
	@Autowired
	AccountService accountService;
//	tiem bean co che ma hoa
	@Autowired
	BCryptPasswordEncoder pe;
	@Autowired
	SessionService session;
	
//	xu li login
	@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(username ->{
				try {
					Account ac = accountService.findById(username);
//					session.set("user", ac.getUsername());
					String password = pe.encode(ac.getPassword());
					String roles[] = ac.getAuthorities().stream()
							.map(er -> er.getRole().getId())
							.collect(Collectors.toList()).toArray(new String[0]);
					return User.withUsername(username).password(password).roles(roles).build();
				} catch (NoSuchElementException e) {
					// TODO: handle exception
					throw new UsernameNotFoundException(username + "Not Found");
				}
			});
		}
//	form login
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
//		phan quyen login
		http.authorizeRequests()
			.antMatchers("/order/**").authenticated()
			.antMatchers("/admin/**").hasAnyRole("ADMIN","USER")
			.antMatchers("/rest/authorities").hasRole("ADMIN")
			.anyRequest().permitAll();
//		page login
		http.formLogin()
		.loginPage("/security/login/form")
		.loginProcessingUrl("/security/login") //form action
		.defaultSuccessUrl("/security/login/success",false)
		.failureUrl("/security/login/error");
//		remember
		http.rememberMe()
			.tokenValiditySeconds(86400);
//		ngoai lề
		http.exceptionHandling()
			.accessDeniedPage("/security/unauthoried");
//		logout
		http.logout()
			.logoutUrl("/security/logoff")
			.logoutSuccessUrl("/security/logoff/success");
//		dang nhap xa hoi
		http.oauth2Login()
		.loginPage("/security/login/form")
		.defaultSuccessUrl("/oauth2/login/success",true)
		.failureUrl("/security/login/error")
		.authorizationEndpoint()
			.baseUri("/oauth2/authorization");//login html
	}
//	co che ma hoa
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	cho phep truy xuat rest api tu ben ngoai
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
	}
	
	public void loginFormOAuth2(OAuth2AuthenticationToken oauth2) {
		String email = oauth2.getPrincipal().getAttribute("email");
		String password = Long.toHexString(System.currentTimeMillis());
		
		UserDetails user = User.withUsername(email)
							.password(pe.encode(password)).roles("GUEST").build();
		Authentication auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
}
