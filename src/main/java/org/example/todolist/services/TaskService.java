/**
 * ===============================================================
 *                       TaskService
 * ===============================================================
 *
 * This service class contains the business logic used to manage
 * Task entities within the TodoList application.
 * It communicates with the TaskRepository to execute CRUD
 * operations on the database.
 *
 * ---------------------------------------------------------------
 * Class: TaskService
 * Repository used: TaskRepository
 * ---------------------------------------------------------------
 *
 * Methods:
 *
 * 1. addTask(Task task)
 *    - Saves a new task or updates an existing one.
 *    - Delegates the persistence to TaskRepository.save(task).
 *    - @param task : the task to create or update.
 *
 *    Example:
 *       Task task = new Task();
 *       task.setTitle("Plan weekly schedule");
 *       task.setDescription("Prepare tasks for next week");
 *       task.setCompleted(false);
 *       taskService.addTask(task);
 *
 * 2. getAllTasks()
 *    - Fetches every task stored in the database.
 *    - Returns a List<Task>.
 *
 *    Example:
 *       List<Task> tasks = taskService.getAllTasks();
 *
 * 3. getTaskById(Integer id)
 *    - Retrieves a single task by its unique identifier.
 *    - Returns an Optional<Task>, empty if the task is not found.
 *
 *    Example:
 *       Optional<Task> task = taskService.getTaskById(5);
 *
 * 4. updateTask(Task task)
 *    - Updates an existing task.
 *    - Usually checks the existence of the task before calling save().
 *
 *    Example:
 *       Task edit = new Task(3, "Update resume", "Add recent projects", false);
 *       taskService.updateTask(edit);
 *
 * 5. deleteTask(Integer id)
 *    - Removes a task from the database based on its ID.
 *    - May throw an exception if the task does not exist.
 *
 *    Example:
 *       taskService.deleteTask(4);
 *
 * ---------------------------------------------------------------
 *
 * Notes:
 * - This service layer centralizes all business-related logic.
 * - Any future rules (e.g., validation, reminders, logging)
 *   should be placed here instead of the controller.
 * - Encourages proper separation of concerns:
 *      Controller → Service → Repository
 *
 * ===============================================================
 */
package org.example.todolist.services;


import org.example.todolist.entities.Task;
import org.example.todolist.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(Task task){
        this.taskRepository.save(task);
    }
}
