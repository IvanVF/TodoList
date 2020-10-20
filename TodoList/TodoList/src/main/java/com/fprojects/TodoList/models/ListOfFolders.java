package com.fprojects.TodoList.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ListOfFolders {

    @Id
    @GeneratedValue
    private Long id;

    String name_of_db_folder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfDBFolder() {
        return name_of_db_folder;
    }

    public void setNameOfDBFolder(String nameOfDBFolder) {
        this.name_of_db_folder = nameOfDBFolder;
    }
}
