package com.fprojects.TodoList.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class ListOfLists {

    @Id
    @Column(name = "list_of_lists_id")
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "listOfLists")
    private List<ListOfActions> listOfAction = new ArrayList<>();

    public List<ListOfActions> getListOfAction() {
        return listOfAction;
    }

    public void setListOfAction(List<ListOfActions> listOfAction) {
        this.listOfAction = listOfAction;
    }

}
