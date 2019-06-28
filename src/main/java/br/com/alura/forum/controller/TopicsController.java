package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicDTO;
import br.com.alura.forum.controller.form.TopicForm;
import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.CourseRepository;
import br.com.alura.forum.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("topics")
public class TopicsController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TopicsRepository topicsRepository;

    @PostMapping
    public ResponseEntity<TopicDTO> add(@RequestBody @Valid TopicForm topicForm, UriComponentsBuilder uriBuilder) {
        Topic topic = topicForm.convert(courseRepository);

        topicsRepository.save(topic);

        return ResponseEntity
            .created(uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri())
            .body(new TopicDTO(topic));
    }

    @GetMapping
    public List<TopicDTO> list(String courseName) {
        if (courseName != null) {
           return TopicDTO.convert(topicsRepository.findByCourseName(courseName));
        }

        return TopicDTO.convert(topicsRepository.findAll());
    }
}
