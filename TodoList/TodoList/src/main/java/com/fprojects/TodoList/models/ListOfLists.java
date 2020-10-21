package com.fprojects.TodoList.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ListOfLists {

    @Id
    @GeneratedValue
    private Long id;

    private String nameOfList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfDBFolder() {
        return nameOfList;
    }

    public void setNameOfDBFolder(String nameOfFolder) {
        this.nameOfList = nameOfFolder;
    }
}
