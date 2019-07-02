package br.com.alura.forum.config.security.util;

import br.com.alura.forum.constants.AuthenticationType;

import javax.servlet.http.HttpServletRequest;

public class TokenUtil {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String tokenStart = String.format("%s ", AuthenticationType.BEARER);

    public static String retrieveToken(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION_HEADER);

        if (!isTokenFormatValid(token)) {
            return null;
        }

        return extractKey(token);
    }

    private static String extractKey(String token) {
        return token.substring(tokenStart.length());
    }

    private static boolean isTokenFormatValid(String token) {
        return token != null && !token.isEmpty() && token.startsWith(tokenStart);
    }
}