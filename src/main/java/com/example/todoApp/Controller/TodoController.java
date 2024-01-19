package com.example.todoApp.Controller;

import com.example.todoApp.Repository.ToDoRepository;
import com.example.todoApp.domain.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final ToDoRepository toDoRepository;

    @GetMapping("/list")
    public String index(Model model){
        List<ToDo> toDoList=toDoRepository.findAll();
        model.addAttribute("todoList", toDoList);
        return "todos";
    }

    @PostMapping("/list/create")
    public String createToDo(@RequestParam("todo") String todo){
        // database에 저장
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);
        return "redirect:/list";
    }

    @DeleteMapping("/list/delete/{id}")
    public String deleteToDO(@PathVariable("id") Long id){
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 아이템이 없습니다. id=" + id));
        toDoRepository.delete(toDo);
        return "redirect:/list";
    }
}
