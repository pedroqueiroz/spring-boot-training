package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.DetailedTopicDTO;
import br.com.alura.forum.controller.dto.TopicDTO;
import br.com.alura.forum.controller.form.TopicForm;
import br.com.alura.forum.controller.form.UpdatedTopicForm;
import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.CourseRepository;
import br.com.alura.forum.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

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
        if (topicExists(id)) {
            return ResponseEntity.notFound().build();
        }

        topicsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailedTopicDTO> detail(@PathVariable Long id) {
        if (topicExists(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new DetailedTopicDTO(topicsRepository.getOne(id)));
    }

    @GetMapping
    public Page<TopicDTO> list(@RequestParam(required = false) String courseName,
                               @PageableDefault Pageable pageable) {

        if (courseName != null) {
           return TopicDTO.convert(topicsRepository.findByCourseName(courseName, pageable));
        }

        return TopicDTO.convert(topicsRepository.findAll(pageable));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDTO> update(@PathVariable Long id, @RequestBody @Valid UpdatedTopicForm updatedTopicForm) {
        if (topicExists(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new TopicDTO(updatedTopicForm.update(id, topicsRepository)));
    }

    private boolean topicExists(Long id) {
        Optional<Topic> optionalTopic = topicsRepository.findById(id);

        if (!optionalTopic.isPresent()) {
            return true;
        }

        return false;
    }
}
