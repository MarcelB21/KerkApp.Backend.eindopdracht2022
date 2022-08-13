package nl.novi.backend.spring.api.kerkapp.config;

import nl.novi.backend.spring.api.kerkapp.Service.CustomUserDetailsService;
import nl.novi.backend.spring.api.kerkapp.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
                .authoritiesByUsernameQuery("SELECT username, authority FROM authorities AS a WHERE username=?");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //JWT token authentication
        http
                .httpBasic().and().csrf().disable().formLogin().disable()
                .cors().and()
                .authorizeRequests()
                .antMatchers("/authenticate").permitAll()/*allen dit punt mag toegankelijk zijn voor niet ingelogde gebruikers*/
                .antMatchers("/authenticated").authenticated()
                .antMatchers( "/users").permitAll()
                .antMatchers("/users").hasRole("ADMIN")
                .antMatchers("/users/**").hasRole("ADMIN")
                .antMatchers("/event/**").hasRole("ADMIN")

                .antMatchers("/{username}/authorities").hasRole("ÄDMIN")
                .antMatchers("/{username}/authorities/{authority}").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST,"/Bible/{bookname}/{chapter}/{verse}/photo").hasAnyRole("ADMIN", "SUPERUSER")
                .antMatchers("/upload").hasAnyRole("ADMIN", "SUPERUSER")

                .antMatchers("/Bible/**").hasAnyRole("ADMIN", "SUPERUSER", "USER")
                .antMatchers("/Bible").hasAnyRole("ADMIN","SUPERUSER", "ÜSER")
                .antMatchers("/creed").hasAnyRole("ADMIN","SUPERUSER", "ÜSER")
                .antMatchers("/Catechisms").hasAnyRole("ADMIN", "SUPERUSER", "USER")
                .antMatchers("/Catechisms/**").hasAnyRole("ADMIN", "SUPERUSER", "USER")
                .antMatchers("/download/{fileName}").hasAnyRole("ADMIN", "SUPERUSER", "USER")
                .antMatchers("/{username}").hasAnyRole("ADMIN", "SUPERUSER", "USER")
                .antMatchers("/events/all").hasAnyRole("ADMIN", "SUPERUSER", "USER")

                /*voeg de antmatchers toe voor admin(post en delete) en user (overige)*/
                .and()
                .authorizeRequests().anyRequest().authenticated()
//                .anyRequest().permitAll()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

    }

}
