/**
 * ===============================================================
 *                      TaskRepository
 * ===============================================================
 *
 * Interface providing access to Task entity data.
 * It extends JpaRepository, which automatically provides
 * CRUD operations and pagination support.
 *
 * ---------------------------------------------------------------
 * Interface: TaskRepository
 * Entity: Task
 * Primary key: Integer (or Long depending on the model)
 * ---------------------------------------------------------------
 *
 * Main inherited methods:
 *
 * - save(entity):
 *       Saves or updates a task.
 *
 * - findById(id):
 *       Returns a task wrapped in an Optional.
 *
 * - findAll():
 *       Returns all tasks.
 *
 * - findAll(Pageable pageable):
 *       Returns tasks with pagination.
 *
 * - deleteById(id):
 *       Deletes a task by its ID.
 *
 * - delete(entity):
 *       Deletes the given entity.
 *
 * - count():
 *       Returns the total number of tasks.
 *
 * ---------------------------------------------------------------
 * Example usage:
 *
 * @Service
 * public class TaskService {
 *
 *     private final TaskRepository taskRepository;
 *
 *     public TaskService(TaskRepository taskRepository) {
 *         this.taskRepository = taskRepository;
 *     }
 *
 *     public Task create(Task t) {
 *         return taskRepository.save(t);
 *     }
 *
 *     public List<Task> findAllTasks() {
 *         return taskRepository.findAll();
 *     }
 *
 *     public Optional<Task> findById(Integer id) {
 *         return taskRepository.findById(id);
 *     }
 *
 *     public void delete(Integer id) {
 *         taskRepository.deleteById(id);
 *     }
 * }
 *
 * ---------------------------------------------------------------
 * Notes:
 * - You can add custom methods such as:
 *       List<Task> findByCompleted(boolean completed);
 *       List<Task> findByTitleContaining(String keyword);
 *
 * - No extra code is required for basic CRUD operations.
 * ===============================================================
 */


package org.example.todolist.repositories;

import org.example.todolist.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
