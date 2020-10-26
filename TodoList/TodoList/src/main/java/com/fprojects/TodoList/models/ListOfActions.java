package com.fprojects.TodoList.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class ListOfActions {

    @Id
    @GeneratedValue
    private UUID actionId;

    private String nameOfAction;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_of_lists_id")
    private ListOfLists listOfLists;


    public ListOfLists getListOfLists() {
        return listOfLists;
    }

    public void setListOfLists(ListOfLists listOfLists) {
        this.listOfLists = listOfLists;
    }

    public UUID getActionId() {
        return actionId;
    }

    public void setActionId(UUID actionId) {
        this.actionId = actionId;
    }

    public String getNameOfAction() {
        return nameOfAction;
    }

    public void setNameOfAction(String nameOfAction) {
        this.nameOfAction = nameOfAction;
    }
}
