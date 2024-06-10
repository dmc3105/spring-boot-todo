package com.dmc3105.todo.service;

import com.dmc3105.todo.model.Task;
import com.dmc3105.todo.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private TaskRepository repository;

    @Override
    public List<Task> findAllTasks() {
        return repository.findAll();
    }

    @Override
    public Task findTask(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Task saveTask(Task task) {
        return repository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return repository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
