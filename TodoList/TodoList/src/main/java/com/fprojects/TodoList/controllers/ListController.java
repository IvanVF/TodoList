package com.fprojects.TodoList.controllers;

import com.fprojects.TodoList.dto.ListDto;
import com.fprojects.TodoList.repodatabase.ListRepository;
import com.fprojects.TodoList.services.ListServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер списков
 */
@RestController
@RequestMapping("/list")
public class ListController {

    private final ListServiceInterface listServiceInterface;

    @Autowired
    ListRepository listRepository;

    public ListController(ListServiceInterface listServiceInterface) {
        this.listServiceInterface = listServiceInterface;
    }

    @DeleteMapping("/delete/{id}") // Удалить list по id http://localhost:8082/list/delete/7bc44265-630a-44ce-af01-018cd6260377
    public void deleteList(@PathVariable("id") UUID listId) {
        listServiceInterface.deleteList(listId);
    }

    @GetMapping("/getAll") // Получить список списков по запросу http://localhost:8082/list/getAll
    public List<ListDto> getLists() { return listServiceInterface.getLists(); }

    @GetMapping("/getOne/{id}") // Получить 1 список по Id http://localhost:8082/list/getOne/44a7fd82-6583-401d-8bff-049ea4de2c95
    public ListDto getOneList(@PathVariable(value = "id") UUID id) {
        return listServiceInterface.getOneList(id);
    }

    @PostMapping("/postNewList") //Добавить новый список дел по запросу http://localhost:8082/list/postNewList , body: { "nameOfList": "DTO1" }
    public ListDto postList(@RequestBody ListDto dto) {
        return listServiceInterface.postList(dto);
    }

    // TODO: действия с репозитроями вынести в сервис через интерфейс, чтоб мы имели возможность подменить реализацию

}
