package com.fprojects.TodoList.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * Java-doc и у полей тоже
 */
@Data
public class ListDto implements Serializable { // TODO: implements Serializable

    private UUID listId;
    private String nameOfList;
    private LocalDateTime creationDate;
    private LocalDateTime changingDate;
    private String description;

    private List<ListDto> allLists;

    // TODO: не хватает полей: длата создания/ удалени и пнаример состояние списка (кторое присваивается исходя и статусов дел)
}
