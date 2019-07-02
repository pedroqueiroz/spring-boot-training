package br.com.alura.forum.controller.dto;

public class TokenDTO {
    private final String token;
    private final String authenticationType;

    public TokenDTO(String token, String authenticationType) {
        this.token = token;
        this.authenticationType = authenticationType;
    }

    public String getToken() {
        return token;
    }

    public String getAuthenticationType() {
        return authenticationType;
    }
}
