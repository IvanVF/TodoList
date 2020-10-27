package com.fprojects.TodoList.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ListDto {

    private UUID listId;

    private String nameOfList;

}
