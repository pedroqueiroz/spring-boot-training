package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicDTO;
import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.Topic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicsController {

    private static final Topic TOPIC = new Topic("I have questions", "About Spring Boot", new Course("Spring Boot 101", "Programming"));

    @RequestMapping
    public List<TopicDTO> list() {
        return TopicDTO.convert(Arrays.asList(TOPIC, TOPIC, TOPIC));
    }
}
