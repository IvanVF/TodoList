package com.fprojects.TodoList.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class ListOfLists {

    @Id
    @GeneratedValue
    private UUID listId;

    private String nameOfList;

    public UUID getListId() {
        return listId;
    }

    public void setListId(UUID id) {
        this.listId = id;
    }

    public String getNameOfList() {
        return nameOfList;
    }

    public void setNameOfList(String nameOfList) {
        this.nameOfList = nameOfList;
    }
}
