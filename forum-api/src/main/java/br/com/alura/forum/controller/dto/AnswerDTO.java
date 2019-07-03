package br.com.alura.forum.controller.dto;

import br.com.alura.forum.model.Answer;
import br.com.alura.forum.model.User;

import java.time.LocalDateTime;

public class AnswerDTO {

    private Long id;
    private String message;
    private LocalDateTime creationDate;
    private String authorName;

    public AnswerDTO(Answer answer) {
        id = answer.getId();
        message = answer.getMessage();
        creationDate = answer.getCreationDate();

        User author = answer.getAuthor();
        authorName = author.getName();
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getAuthorName() {
        return authorName;
    }
}
