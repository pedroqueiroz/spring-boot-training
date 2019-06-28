package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicDTO;
import br.com.alura.forum.controller.form.TopicForm;
import br.com.alura.forum.repository.CourseRepository;
import br.com.alura.forum.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topics")
public class TopicsController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicsRepository topicsRepository;

    @PostMapping
    public void add(@RequestBody TopicForm topic) {
        topicsRepository.save(topic.convert(courseRepository));
    }

    @GetMapping
    public List<TopicDTO> list(String courseName) {
        if (courseName != null) {
           return TopicDTO.convert(topicsRepository.findByCourseName(courseName));
        }

        return TopicDTO.convert(topicsRepository.findAll());
    }
}
