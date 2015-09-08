package com.iboss;

//import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

//@Configuration
//@EnableWebMvcSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {//extends WebSecurityConfigurerAdapter {
	
	//@Autowired
    //private UserDetailsService userDetailsService;
		
	//@Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http.csrf().disable();
    	
        http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .antMatchers("/css/**", "/js/**", "/images/**", "**/favicon.ico").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
            	.failureUrl("/login?error")
                .loginPage("/login")
            	.defaultSuccessUrl("/login.do")
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }
  
    //@Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userDetailsService);
    }
}