package com.mustafa.springsecurity.config;

import com.mustafa.springsecurity.enm.EnmRole;
import com.mustafa.springsecurity.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    /**
     Bu metot, HTTP güvenlik yapılandırmasını yapılandırmak için kullanılır.
     HttpSecurity nesnesi, HTTP istekleri üzerindeki yetkilendirme, kimlik doğrulama ve diğer güvenlik ayarlarını yapılandırmak için kullanılır.
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // Bu metot, yapılandırmanın istek yetkilendirme ayarlarını başlatır.
                .antMatchers("/public").permitAll() // /public yolu için herkese erişim izni verir. Bu yol herhangi bir yetkilendirme gerektirmez.
                .anyRequest().authenticated() //  Diğer tüm yolların kimlik doğrulaması gerektireceğini belirtir. Bu, kullanıcıların bu yollara erişmek için kimlik doğrulaması yapmaları gerektiği anlamına gelir.
                .and()
                .formLogin() // Form tabanlı kimlik doğrulama kullanılacağını belirtir.
                .loginPage("/login") // Özel bir giriş sayfasının kullanılacağını belirtir. /login yoluna erişildiğinde, kullanıcıya giriş yapma fırsatı sunar.
                .permitAll() // Giriş sayfasına herkese erişim izni verir.
                .and()
                .logout() // Oturum kapatma işlemini yapılandırır.
                .permitAll() // Oturum kapatma işlemine herkese erişim izni verir.
                .and()
                .csrf().disable()
                .cors();

        http.userDetailsService(userDetailsService);
    }

/*    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/**")
                .hasRole(EnmRole.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        http.userDetailsService(userDetailsService);
    }*/ // todo : swagger post neden olmuyor?

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
