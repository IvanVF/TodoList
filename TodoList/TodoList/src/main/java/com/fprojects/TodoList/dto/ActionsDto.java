package com.fprojects.TodoList.dto;

import lombok.Data;

import java.util.UUID;

/**
 * Java-doc и у полей тоже
 */
@Data
public class ActionsDto {  // TODO: implements Serializable

    private UUID actionId;

    private String nameOfAction;

    // TODO: не хватает полей !

}
