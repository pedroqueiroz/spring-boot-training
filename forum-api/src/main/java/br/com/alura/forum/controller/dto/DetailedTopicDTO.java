package br.com.alura.forum.controller.dto;

import br.com.alura.forum.model.Topic;
import br.com.alura.forum.model.TopicStatus;
import br.com.alura.forum.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DetailedTopicDTO {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime creationDate;
    private String authorName;
    private TopicStatus status;
    private List<AnswerDTO> answers;

    public DetailedTopicDTO(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.creationDate = topic.getCreationDate();

        User author = topic.getAuthor();
        this.authorName = author.getName();

        this.status = topic.getStatus();
        this.answers = topic.getAnswers().stream()
            .map(AnswerDTO::new)
            .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
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

    public TopicStatus getStatus() {
        return status;
    }

    public List<AnswerDTO> getAnswers() {
        return answers;
    }
}
