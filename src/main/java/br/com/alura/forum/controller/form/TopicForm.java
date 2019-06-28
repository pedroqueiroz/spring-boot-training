package br.com.alura.forum.controller.form;

import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.CourseRepository;

public class TopicForm {
    private String title;
    private String message;
    private String courseName;

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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Topic convert(CourseRepository courseRepository) {
        return new Topic(title, message, courseRepository.findByName(this.courseName));
    }
}
