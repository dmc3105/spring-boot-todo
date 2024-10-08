package ru.dmc3105.todo.service;

import ru.dmc3105.todo.model.Task;
import ru.dmc3105.todo.model.TaskStatus;

import java.util.List;

public interface TaskService {
    List<Task> findAllTasks();
    Task findTask(Long id);
    Task saveTask(Task task);
    Task updateTask(Task task);
    TaskStatus toggleStatus(Long id);
    void deleteTask(Long id);
}
