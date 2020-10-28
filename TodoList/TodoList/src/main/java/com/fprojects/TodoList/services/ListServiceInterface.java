package com.fprojects.TodoList.services;

import com.fprojects.TodoList.dto.ListDto;

import java.util.UUID;

/**
 * Интерфейс сервиса спискрв
 */

public interface ListServiceInterface {

    void deleteList(UUID listId);
    ListDto getLists();

}
