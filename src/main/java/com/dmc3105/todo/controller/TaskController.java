package com.dmc3105.todo.controller;

import com.dmc3105.todo.model.Task;
import com.dmc3105.todo.model.TaskStatus;
import com.dmc3105.todo.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private TaskService service;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("tasks", service.findAllTasks());
        return "task/view_all_tasks";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("taskStatuses", TaskStatus.values());
        model.addAttribute("defaultTaskStatus", TaskStatus.UNCOMPLETED);
        return "task/create_new_task";
    }

    @PostMapping("")
    public String save(@ModelAttribute Task task) {
        service.saveTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        service.deleteTask(id);
        return "redirect:/tasks";
    }
}
