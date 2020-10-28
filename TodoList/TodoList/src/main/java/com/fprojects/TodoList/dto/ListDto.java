package com.fprojects.TodoList.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * Java-doc и у полей тоже
 */
@Data
public class ListDto { // TODO: implements Serializable

    private UUID listId;

    private String nameOfList;

    // TODO: не хватает полей: длата создания/ удалени и пнаример состояние списка (кторое присваивается исходя и статусов дел)
}
