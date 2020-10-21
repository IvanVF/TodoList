package com.fprojects.TodoList.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ListOfFolders {

    @Id
    @GeneratedValue
    private Long id;

    private String nameOfFolder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfDBFolder() {
        return nameOfFolder;
    }

    public void setNameOfDBFolder(String nameOfFolder) {
        this.nameOfFolder = nameOfFolder;
    }
}
