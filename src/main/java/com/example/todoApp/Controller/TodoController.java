package com.example.todoApp.Controller;

import com.example.todoApp.Service.ToDoService;
import com.example.todoApp.domain.ToDoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TodoController {
    private final ToDoService toDoService;

    @GetMapping("/")
    public String root(){
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<ToDoEntity> toDoList=this.toDoService.getList();
        model.addAttribute("toDoList", toDoList);
        return "todolist";
    }

    @PostMapping("/list")
    public String createToDo(@RequestParam("todoContent") String todoContent){
        // database에 저장
        this.toDoService.create(todoContent);
        return "redirect:/list";
    }

    @PostMapping("/list/delete/{id}")
    public String deleteToDO(@PathVariable("id") Long id){
        this.toDoService.delete(id);
        return "redirect:/list";
    }

    @PostMapping("/list/update/{id}")
    public String updateToDo(@PathVariable("id") Long id){
        this.toDoService.update(id);
        return "redirect:/list";
    }
}
