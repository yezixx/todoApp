package com.example.todoApp.Service;

import com.example.todoApp.Repository.ToDoRepository;
import com.example.todoApp.domain.ToDoEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public List<ToDoEntity> getList(){
        return this.toDoRepository.findAll();
    }

    public void create(String todoContent){
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setTodo(todoContent);
        toDoEntity.setCompleted(false);
        this.toDoRepository.save(toDoEntity);
    }

    @Transactional
    public void delete(Long id){
        ToDoEntity toDoEntity = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 Todo가 없습니다. id=" + id));
        toDoRepository.delete(toDoEntity);
        this.toDoRepository.delete(toDoEntity);
    }

    public void update(Long id){
        ToDoEntity toDoEntity = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 Todo가 없습니다. id=" + id));
        toDoEntity.setCompleted(!toDoEntity.getComplete());
        toDoRepository.save(toDoEntity);
    }
}
