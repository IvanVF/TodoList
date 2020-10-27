package com.fprojects.TodoList.models;

import javax.persistence.*;
import java.util.UUID;

/**
 * Java-doc и у полей тоже
 */
@Entity
// TODO: желетельно принудительно указать в какой таблице лежит сущность @Table
public class Actions { // TODO: единственное число

    @Id
    @GeneratedValue // TODO: не нужноь указывать. ID присваивается в конструткоре  либо при создании UUID гарантирует что персечения с другими ID не будет
    // TODO: желательноь указать в какой колонке лежит     @Column
    private UUID actionId; // TODO: проще просто id, т.к. что это id для  Actions и атк понятно

    private String nameOfAction; // TODO: тоже просто name


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_of_lists_id")
    private ListOfLists listOfLists; // TODO: почему список списков. у нас же просто список дел, а начи list

    // TODO: не хватет полей по заланию:
    //  * дата создания,
    //  * дата редактирования,
    //  * отметка о выполнении
    //  * Приоритет, который сделать перечислением
    //  * описание

    // TODO: все эти геттеры / серреты можно заменить на аннотапции @Getter/@Setter
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
