/**
 * ===============================================================
 *                        TodoList API - Documentation
 * ===============================================================
 *
 * This API allows you to manage a list of tasks TodoList.
 * It provides REST operations to create, read, update,
 * and delete tasks.
 *
 * ---------------------------------------------------------------
 * MODEL : Task
 * ---------------------------------------------------------------
 *  - id (Long) : Unique identifier
 *  - title (String) : Task title (required)
 *  - description (String) : Optional description
 *  - completed (boolean) : Task status (default: false)
 *
 * ===============================================================
 *                  1. CREATE A TASK (POST)
 * ===============================================================
 *  URL : POST /api/task
 *  Description : Creates a new task
 *
 *  JSON request example :
 *  {
 *      "title": "Prepare the meeting",
 *      "description": "Create slides and organize notes",
 *      "completed": false
 *  }
 *
 *  Example response :
 *  HTTP 201 CREATED
 *
 *  Possible errors :
 *  - 400 BAD REQUEST : Missing fields or invalid JSON
 *
 * ===============================================================
 *                  2. GET ALL TASKS (GET)
 * ===============================================================
 *  URL : GET /api/task
 *  Description : Returns the full list of tasks
 *
 *  Example response :
 *  HTTP 200 OK
 *  [
 *      {
 *          "id": 1,
 *          "title": "Prepare the meeting",
 *          "description": "Create slides",
 *          "completed": false
 *      },
 *      {
 *          "id": 2,
 *          "title": "Walk the dog",
 *          "description": "20-minute walk",
 *          "completed": true
 *      }
 *  ]
 *
 * ===============================================================
 *                  3. GET ONE TASK BY ID (GET)
 * ===============================================================
 *  URL : GET /api/task/{id}
 *  Description : Retrieves the task corresponding to the given ID
 *
 *  Example :
 *  GET /api/task/2
 *
 *  Response :
 *  HTTP 200 OK
 *  {
 *      "id": 2,
 *      "title": "Walk the dog",
 *      "description": "20-minute walk",
 *      "completed": true
 *  }
 *
 *  Possible errors :
 *  - 404 NOT FOUND : Task not found
 *
 * ===============================================================
 *                  4. UPDATE A TASK (PUT)
 * ===============================================================
 *  URL : PUT /api/task/{id}
 *  Description : Updates an existing task
 *
 *  JSON request example :
 *  {
 *      "title": "Prepare the meeting",
 *      "description": "Finalize documents and check equipment",
 *      "completed": true
 *  }
 *
 *  Example response :
 *  HTTP 200 OK
 *  {
 *      "message": "Task updated successfully"
 *  }
 *
 *  Possible errors :
 *  - 404 NOT FOUND : Task does not exist
 *
 * ===============================================================
 *                  5. DELETE A TASK (DELETE)
 * ===============================================================
 *  URL : DELETE /api/task/{id}
 *  Description : Deletes a task
 *
 *  Example :
 *  DELETE /api/task/3
 *
 *  Response :
 *  HTTP 204 NO CONTENT
 *
 *  Possible errors :
 *  - 404 NOT FOUND : Task not found
 *
 * ===============================================================
 *                  CURL REQUEST EXAMPLES
 * ===============================================================
 *
 *  1. Create a task :
 *     curl -X POST http://localhost:8080/api/task \
 *     -H "Content-Type: application/json" \
 *     -d '{"title":"Do the groceries","description":"Buy milk and fruits","completed":false}'
 *
 *  2. Get all tasks :
 *     curl -X GET http://localhost:8080/api/task
 *
 *  3. Get a task :
 *     curl -X GET http://localhost:8080/api/task/2
 *
 *  4. Update a task :
 *     curl -X PUT http://localhost:8080/api/task/2 \
 *     -H "Content-Type: application/json" \
 *     -d '{"title":"Walk the dog","description":"Longer walk","completed":false}'
 *
 *  5. Delete a task :
 *     curl -X DELETE http://localhost:8080/api/task/2
 *
 * ===============================================================
 * Notes :
 * - All requests must be in JSON format.
 * - The Content-Type: application/json header is required.
 * ===============================================================
 */

package org.example.todolist.controllers;

import org.example.todolist.entities.Task;
import org.example.todolist.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/task/")
public class TaskController{
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void addTask(@RequestBody Task task){
        this.taskService.addTask(task); // use the service from save the task in the database
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Task> getAllTasks(){
        return this.taskService.getAllTasks();
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Task getTaskById(@PathVariable("id") Long id){
        return this.taskService.getTaskById(id); // user service to get task by id
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void updateTask(@PathVariable("id") Long id, @RequestBody Task task){
        task.setId(id);
        this.taskService.updateTask(task); // use service to update task
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void deleteTask(@PathVariable("id") Long id){
        this.taskService.deleteTask(id); // use service to delete task by id
    }
}
