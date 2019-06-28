package br.com.alura.forum.controller;

import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class TopicsController {

    public static final Topic TOPIC = new Topic("I have questions", "About Spring Boot", new Course("Spring Boot 101", "Programming"));

    @RequestMapping
    @ResponseBody
    public List<Topic> list() {
        return Arrays.asList(TOPIC, TOPIC, TOPIC);
    }
}
