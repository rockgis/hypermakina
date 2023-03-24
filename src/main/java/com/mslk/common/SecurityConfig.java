package com.mslk.common;

import com.mslk.common.util.CustomPasswordEncoding;
import com.mslk.hypermakina.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.StaticResourceLocation;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private MemberService memberService;



    protected SecurityConfig(MemberService memberService) {
        this.memberService = memberService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {


        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .antMatchers(getResources()).permitAll()
                .antMatchers("/dashboard","/help","/api/**","/sns/**").permitAll()
                .antMatchers("/admin/**","/snsad/**").hasRole("ADMIN")
                       //.antMatchers("/user/**").hasRole("MEMBER")
                .antMatchers("/admin").authenticated()
             .and() // 로그인 설정
                .formLogin()
                .loginPage("/admin/login")
                .defaultSuccessUrl("/admin")
                .permitAll()
             .and() // 로그아웃 설정
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
             .and()
                .csrf()
                .ignoringAntMatchers("/admin/*post")
                .ignoringAntMatchers("/admin/*del")
                .ignoringAntMatchers("/admin/*search")
                .ignoringAntMatchers("/admin/*/edit")
                .ignoringAntMatchers("/snsad/post/*")
                .ignoringAntMatchers("/snsad/*post")
                .ignoringAntMatchers("/snsad/*del")
                .ignoringAntMatchers("/snsad/*search")
                .ignoringAntMatchers("/snsad/*/edit")
                .ignoringAntMatchers("/snsad/post/*")
                .ignoringAntMatchers("/*_check")

                //.ignoringAntMatchers("/post")
             .and()
                // 403 예외처리 핸들링
                .exceptionHandling()
                .accessDeniedPage("/admin/denied");

    }


    private String[] getResources() {
        return  Arrays.stream(StaticResourceLocation.values())
                .flatMap(StaticResourceLocation::getPatterns)
                .toArray(String[]::new);
    }
}

