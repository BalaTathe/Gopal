package com.demo.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import com.demo.controller.services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class Securitycon  {
	@Autowired
	GoogleOAuth2SuccessHandler googleOAuth2SuccessHandler;
	@Autowired
	CustomUserDetailService customUserDetailService;
  
	    @SuppressWarnings({ "deprecation", "removal" })
		@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        
	    	http
	    	.authorizeRequests()
	    	.requestMatchers("/","/shop/**","/forgotpass","/register").permitAll()
	    	.requestMatchers("/index/**").hasRole("ADMIN")
	    	.anyRequest().authenticated()
	    	.and()
	    	.formLogin()
	    	.loginPage("/login")
	    	.permitAll()
	    	.failureUrl("/login?error=true")
	    	.defaultSuccessUrl("/")
	    	.usernameParameter("email")
	    	.passwordParameter("password")
	    	.and()
	    	.oauth2Login()
	    	.loginPage("/login")
	    	.successHandler(googleOAuth2SuccessHandler)
	    	.and()
	    	.csrf().disable();
	    	http.headers().frameOptions().disable();
	    	
	    	return http.build();
	    	
	        
	        

	    }
	    @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    	return new BCryptPasswordEncoder();
	    }
//	    @Bean
//	 	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
//	    	auth.userDetailsService(customUserDetailService);
//	    }
//	    @Bean
//	    protected void configures(WebSecurity web)throws Exception{
//	    	web.ignoring().requestMatchers("/resources/**","/static/**","/images/**","/productimages/**","/css/**","/js/**");
//	    }
	

	        @Bean
	        public WebSecurityCustomizer webSecurityCustomizer() {
	            return (web) -> web.ignoring().requestMatchers("/resources/**","/static/**","/images/**","/productImages/**","/css/**","/js/**");
	        }

	    
	    

		
	}
	
	


