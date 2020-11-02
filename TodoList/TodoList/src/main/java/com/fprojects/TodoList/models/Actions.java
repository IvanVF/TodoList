package com.fprojects.TodoList.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Описание таблицы дел
 */
@Getter
@Setter
@Entity
// TODO: желетельно принудительно указать в какой таблице лежит сущность @Table
public class Actions { // TODO: единственное число

    @Id
    @GeneratedValue // TODO: не нужноь указывать. ID присваивается в конструткоре  либо при создании UUID гарантирует что персечения с другими ID не будет
    // TODO: желательноь указать в какой колонке лежит     @Column
    private UUID actionId; // TODO: проще просто id, т.к. что это id для  Actions и атк понятно

    private String nameOfAction; // TODO: тоже просто name
    private LocalDateTime creationDate;
    private LocalDateTime changingDate;
    private String description;
    private Byte priority; // 1 - 5
    private boolean completeLabel;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id")
    private ListOfLists listOfLists; // TODO: почему список списков. у нас же просто список дел, а начи list

    // TODO: не хватет полей по заланию:
    //  * дата создания,
    //  * дата редактирования,
    //  * отметка о выполнении
    //  * Приоритет, который сделать перечислением
    //  * описание

}
