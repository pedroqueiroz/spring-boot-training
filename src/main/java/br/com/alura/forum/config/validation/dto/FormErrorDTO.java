package br.com.alura.forum.config.validation.dto;

public class FormErrorDTO {

    private String field;
    private String errorMessage;

    public FormErrorDTO(String field, String errorMessage) {
        this.field = field;
        this.errorMessage = errorMessage;
    }

    public String getField() {
        return field;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
