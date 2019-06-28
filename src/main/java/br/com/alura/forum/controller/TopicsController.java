package br.com.alura.forum.controller;

import br.com.alura.forum.controller.dto.TopicDTO;
import br.com.alura.forum.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicsController {

    @Autowired
    private TopicsRepository topicsRepository;

    @RequestMapping
    public List<TopicDTO> list(String courseName) {
        if (courseName != null) {
           return TopicDTO.convert(topicsRepository.findByCourseName(courseName));
        }

        return TopicDTO.convert(topicsRepository.findAll());
    }
}
