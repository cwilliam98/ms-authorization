package com.programabolsas.instrutores.msauthorization.components;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.programabolsas.instrutores.msauthorization.model.entities.User;
import com.programabolsas.instrutores.msauthorization.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {

    @Autowired
    private UserRepository customerRepository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Optional<User> user = Optional.ofNullable(customerRepository.findByUsername(authentication.getName()));

        Map<String, Object> map = new HashMap<>();
        map.put("userName", user.get().getUsername());
        map.put("userID", user.get().getUsername());

        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
        token.setAdditionalInformation(map);

        return token;

    }
}