package com.example.club.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    // BCryptPasswordEncoder로 암호화된 패스워드는 다시 원래대로 복호화가 불가능하고 매번 암호화된 값도 다르게 된다(길이는 동일)
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 더이상 밑에 메서드는 사용하지 않는다
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        // 사용자 계정은 user1
//        auth.inMemoryAuthentication().withUser("user1")
//                // 1111 패워드 인코딩 결과
//                .password("$2a$10$LeHTIWPbGyUNdfs5w62DNePN1oweVg2jsFUr/1l37.C7B/8TgzJei")
//                .roles("USER");
//
//    }

    // 추가
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/sample/all").permitAll()
                .antMatchers("/sample/member").hasRole("USER");

        http.formLogin(); // 인가 인증에 문제시 로그인 화면
//        http.csrf().disable();

        // CSRF 토큰을 사용할 때는 반드시 POST방식으로만 로그아웃을 처리한다.
//        http.logout();
    }

}
