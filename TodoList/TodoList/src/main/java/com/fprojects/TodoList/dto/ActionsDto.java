package com.fprojects.TodoList.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * DTO для дел
 */
@Data
public class ActionsDto implements Serializable {  // TODO: implements Serializable

    private UUID actionId;
    private String nameOfAction;
    private LocalDateTime creationDate;
    private LocalDateTime changingDate;
    private String description;
    private Byte priority; // 1 - 5
    private boolean completeLabel;
    private UUID listId;

    // TODO: не хватает полей !

}
