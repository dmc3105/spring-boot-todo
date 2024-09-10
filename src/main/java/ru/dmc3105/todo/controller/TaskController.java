package ru.dmc3105.todo.controller;

import ru.dmc3105.todo.model.Task;
import ru.dmc3105.todo.model.TaskStatus;
import ru.dmc3105.todo.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("task", service.findTask(id));
        return "task/edit_task";
    }

    @PostMapping("")
    public String save(@ModelAttribute Task task) {
        service.saveTask(task);
        return "redirect:/tasks";
    }

    @PostMapping("toggle_status/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void toggleStatus(@PathVariable("id") Long id) {
        service.toggleStatus(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        service.deleteTask(id);
    }
}
