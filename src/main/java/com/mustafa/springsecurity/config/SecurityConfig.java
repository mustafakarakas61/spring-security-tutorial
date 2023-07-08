package com.mustafa.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

/*    *//**
     Bu metot, HTTP güvenlik yapılandırmasını yapılandırmak için kullanılır.
     HttpSecurity nesnesi, HTTP istekleri üzerindeki yetkilendirme, kimlik doğrulama ve diğer güvenlik ayarlarını yapılandırmak için kullanılır.
     *//*
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
                .permitAll(); // Oturum kapatma işlemine herkese erişim izni verir.
    }

    *//**
     Bu metot, kimlik doğrulama yapılandırmasını yapılandırmak için kullanılır.
     AuthenticationManagerBuilder nesnesi, kimlik doğrulama yöntemlerini ve kullanıcı bilgilerini yapılandırmak için kullanılır.
     *//*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication() // Bellekte kullanıcı bilgilerini tutarak kimlik doğrulama yapılacağını belirtir.
                .withUser("admin").password("{noop}password").roles("ADMIN") // "admin" kullanıcısını ve şifresini belirler. {noop} öneki, şifrenin doğrudan depolanacağını ve şifreleme kullanılmayacağını belirtir. "admin" kullanıcısının "ADMIN" rolüne sahip olduğu belirtilir.
                .and()
                .withUser("user").password("{noop}password").roles("USER"); // "user" kullanıcısını ve şifresini belirler. "user" kullanıcısının "USER" rolüne sahip olduğu belirtilir.
    }*/

}
