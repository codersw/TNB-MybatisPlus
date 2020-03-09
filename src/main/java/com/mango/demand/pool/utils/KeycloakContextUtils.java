package com.mango.demand.pool.utils;

import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

/**
 * 获取keycloak登录信息
 * @author swen
 */
public class KeycloakContextUtils {

    private KeycloakContextUtils() {
    }

    public static Optional<AccessToken> getAccessToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof KeycloakAuthenticationToken) || !authentication.isAuthenticated()) {
            return empty();
        }
        KeycloakSecurityContext credentials = (KeycloakSecurityContext) authentication.getCredentials();
        return of(credentials.getToken());
    }

    public static Optional<String> getUsername() {
        Optional<AccessToken> accessToken = getAccessToken();
        return accessToken.map(AccessToken::getPreferredUsername);
    }

    public static Optional<String> getEmail() {
        Optional<AccessToken> accessToken = getAccessToken();
        return accessToken.map(AccessToken::getEmail);
    }
}
