package br.com.alura.forum.controller.form;

import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.TopicsRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdatedTopicForm {
    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String title;

    @NotNull @NotEmpty @Length(min = 10)
    private String message;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Topic update(Long id, TopicsRepository topicsRepository) {
        Topic topic = topicsRepository.getOne(id);

        topic.setTitle(title);
        topic.setMessage(message);

        return topic;
    }

}
