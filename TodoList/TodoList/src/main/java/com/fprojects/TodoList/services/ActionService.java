package com.fprojects.TodoList.services;

import com.fprojects.TodoList.dto.ActionsDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

/**
 * Интерфейс сервиса дел
 */
public interface ActionService {

    void deleteAction(UUID actionId);

    Page<ActionsDto> getActions(String nameSorting, String creationDateSorting, String changingDateSorting, Pageable pageable);

    //List<ActionsDto> getActions(String nameSorting, String creationDateSorting, String changingDateSorting);
    ActionsDto getOneAction(UUID id);
    ActionsDto postAction(ActionsDto actionDto);
    ActionsDto changeAction(UUID id, ActionsDto actionsDto);
}
