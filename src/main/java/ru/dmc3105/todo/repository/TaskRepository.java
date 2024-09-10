package ru.dmc3105.todo.repository;

import ru.dmc3105.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
