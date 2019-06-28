package br.com.alura.forum.repository;

import br.com.alura.forum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicsRepository extends JpaRepository<Topic, Long> {
}
