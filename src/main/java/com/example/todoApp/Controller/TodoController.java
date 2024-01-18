package com.example.todoApp.Controller;

import com.example.todoApp.Repository.ToDoRepository;
import com.example.todoApp.domain.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final ToDoRepository toDoRepository;

    @GetMapping("/")
    public String index(Model model){
        List<ToDo> toDoList=toDoRepository.findAll();
        model.addAttribute("todoList", toDoList);
        return "todos";
    }

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam("todo") String todo){
        // database에 저장
        ToDo toDo = new ToDo();
        toDo.setTodo(todo);
        toDoRepository.save(toDo);
        return "redirect:/";
    }
}
