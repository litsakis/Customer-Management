package com.litsakis.crm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.litsakis.crm.service.MyUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration  {

	 @Bean
	    public UserDetailsService userDetailsService() {
	        return new MyUserDetailsService();
	    }
	 
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 

	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(passwordEncoder());
                    return authProvider;
	    }
	
	 
	
	/*
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	 http.authorizeRequests()
	 .antMatchers("/customer/showForm*").hasAnyRole("MANAGER", "ADMIN")
	 .antMatchers("/customer/save*").hasAnyRole("MANAGER", "ADMIN")
	 .antMatchers("/customer/delete").hasRole("ADMIN")
	 .antMatchers("/customer/**").hasRole("EMPLOYEE")
	 .antMatchers("/resources/**").permitAll()
	 .and()
	 .formLogin()
	 .loginPage("/showMyLoginPage")
	.loginProcessingUrl("/authenticateTheUser")
	.permitAll()
	 .and()
	 .logout().permitAll()
	 .and()
	 .exceptionHandling().accessDeniedPage("/access-denied");
	 return http.build();
	}
	*/
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	 http.authorizeRequests()
	 .antMatchers("/").permitAll()
     .antMatchers("/login").permitAll()
     .antMatchers("/registration").permitAll()
     .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
     .authenticated().and().csrf().disable().formLogin()
     .loginPage("/login").failureUrl("/login?error=true")
     .defaultSuccessUrl("/customers/list")
     .usernameParameter("user_name")
     .passwordParameter("password")
     .and().logout()
     .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
     .logoutSuccessUrl("/login").and().exceptionHandling()
     .accessDeniedPage("/access-denied");
	 return http.build();
	}
	

	    @Bean
	    public WebSecurityCustomizer webSecurityCustomizer() {
       return  (web) ->  web.ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }

}
