package com.fprojects.TodoList.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ActionsDto {

    private UUID actionId;

    private String nameOfAction;

}
