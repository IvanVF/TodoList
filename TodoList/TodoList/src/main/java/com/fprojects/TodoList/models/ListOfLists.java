package com.fprojects.TodoList.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Описание таблицы списка дел
 */
@Getter
@Setter
@Entity
public class ListOfLists { // TODO: почему множественное число и список списов? у нас же просто псико дел

    @Id
    @Column(name = "list_id") // TODO: список списков???
    @GeneratedValue
    private UUID listId; // TODO: и так понятно что это id для списка

    // TODO: указать в какой колонке лежит
    private String nameOfList; // TODO: и так понятно что это name для списка
    private LocalDateTime creationDate;
    private LocalDateTime changingDate;
    private String description;


    // TODO: не хватает полей по заданию: даты создания и обновлдения


    // TODO: все эти геттеры / серреты можно заменить на аннотапции @Getter/@Setter


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "listOfLists")
    private List<Actions> listOfAction = new ArrayList<>();
}
