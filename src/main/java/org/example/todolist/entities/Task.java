/**
 * @author dev carmelle
 * This class represents the Task table that will be stored
 * in the database.
 * @attributes id, title, description, completed
 */


package org.example.todolist.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Schema(description = "represent a task")
public class Task {
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Id
    @Column(unique = true)
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "identifiant unique in database")
    private Long id;
    @Schema(description = "title of the task")
    @Basic(optional = false)
    private String title;
    @Schema(description = "description of the task")
    private String description;

    @Basic(optional = false)
    @Schema(description = "if a task is conpleted or no")
    private boolean completed;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Task() {

    }

}
