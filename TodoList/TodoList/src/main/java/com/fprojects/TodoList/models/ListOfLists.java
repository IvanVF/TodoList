package com.fprojects.TodoList.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ListOfLists {

    @Id
    @GeneratedValue
    private UUID ListId;

    private String nameOfList;

    public UUID getListId() {
        return ListId;
    }

    public void setListId(UUID id) {
        this.ListId = id;
    }

    public String getNameOfList() {
        return nameOfList;
    }

    public void setNameOfDBFolder(String nameOfFolder) {
        this.nameOfList = nameOfFolder;
    }
}
