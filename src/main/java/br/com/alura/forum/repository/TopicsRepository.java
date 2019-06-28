package br.com.alura.forum.repository;

import br.com.alura.forum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicsRepository extends JpaRepository<Topic, Long> {
   List<Topic> findByCourseName(String courseName);
}
