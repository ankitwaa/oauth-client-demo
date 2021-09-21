package com.example.oauthclientdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@Configuration
public class OAuthConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login(httpSecurityOAuth2LoginConfigurer -> {
            httpSecurityOAuth2LoginConfigurer.clientRegistrationRepository(clientRegistrationRepository());
        });
        http.authorizeRequests().anyRequest().authenticated();
    }

    private ClientRegistration clientRegistration(){
        return CommonOAuth2Provider.GITHUB.getBuilder("github").
                clientId("33253319bb728d88e8d8").clientSecret("3ba76b2120ac6a2606d7c798994d3e82fc6321a6").build();
    }

    private ClientRegistrationRepository clientRegistrationRepository(){
        return new InMemoryClientRegistrationRepository(clientRegistration());
    }
}
