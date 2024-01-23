package com.example.todoApp.Repository;

import com.example.todoApp.domain.ToDoEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ToDoRepository extends JpaRepository<ToDoEntity, Long> {
}
