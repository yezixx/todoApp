package com.example.todoApp.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Table(name = "todo")
@Entity(name="ToDoEntity")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ToDoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String todo;

    private boolean completed;

    public Boolean getComplete(){
        return completed;
    }
}
