package com.fprojects.TodoList.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Java-doc и у полей тоже
 */@Entity
public class ListOfLists { // TODO: почему множественное число и список списов? у нас же просто псико дел

    @Id
    @Column(name = "list_of_lists_id") // TODO: список списков???
    @GeneratedValue
    private UUID listId; // TODO: и так понятно что это id для списка

    // TODO: указать в какой колонке лежит
    private String nameOfList; // TODO: и так понятно что это name для списка


    // TODO: не хватает полей по заданию: даты создания и обновлдения


    // TODO: все эти геттеры / серреты можно заменить на аннотапции @Getter/@Setter
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "listOfLists")
    private List<Actions> listOfAction = new ArrayList<>();

    public List<Actions> getListOfAction() {
        return listOfAction;
    }

    public void setListOfAction(List<Actions> listOfAction) {
        this.listOfAction = listOfAction;
    }

}
