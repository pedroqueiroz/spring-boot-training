package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.DetailedTopicDTO;
import br.com.alura.forum.controller.dto.TopicDTO;
import br.com.alura.forum.controller.form.UpdatedTopicForm;
import br.com.alura.forum.controller.form.TopicForm;
import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.CourseRepository;
import br.com.alura.forum.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
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
    @Transactional
    public ResponseEntity<TopicDTO> add(@RequestBody @Valid TopicForm topicForm, UriComponentsBuilder uriBuilder) {
        Topic topic = topicForm.convert(courseRepository);

        topicsRepository.save(topic);

        return ResponseEntity
            .created(uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri())
            .body(new TopicDTO(topic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        topicsRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public DetailedTopicDTO detail(@PathVariable Long id) {
        return new DetailedTopicDTO(topicsRepository.getOne(id));
    }

    @GetMapping
    public List<TopicDTO> list(String courseName) {
        if (courseName != null) {
           return TopicDTO.convert(topicsRepository.findByCourseName(courseName));
        }

        return TopicDTO.convert(topicsRepository.findAll());
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDTO> update(@PathVariable Long id, @RequestBody @Valid UpdatedTopicForm updatedTopicForm) {
        return ResponseEntity.ok(new TopicDTO(updatedTopicForm.update(id, topicsRepository)));
    }
}
