/**
 * @author dev carmelle
 * cette class represente la table tache qui saura dans notre base de donnee
 * @attribut id, title, description, isCompleted
 * */

package org.example.todolist.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Task {
    @Id
    @Column(unique = true)
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic(optional = false)
    private String title;

    private String description;

    @Basic(optional = false)
    private boolean isCompleted;

    public Task() {

    }

}
