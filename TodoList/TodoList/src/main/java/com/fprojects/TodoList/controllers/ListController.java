package com.fprojects.TodoList.controllers;

import com.fprojects.TodoList.converter.ListConverter;
import com.fprojects.TodoList.dto.ListDto;
import com.fprojects.TodoList.models.ListOfLists;
import com.fprojects.TodoList.repodatabase.ListRepository;
import com.fprojects.TodoList.services.ListServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/list")
public class ListController {

    private final ListServiceInterface listServiceInterface;

    // TODO: действия с репозитроями вынести в сервис через интерфейс, чтоб мы имели возможность подменить реализацию
    @Autowired
    ListRepository listRepository;
    @Autowired
    ListConverter converter;

    public ListController(ListServiceInterface listServiceInterface) {
        this.listServiceInterface = listServiceInterface;
    }

    @DeleteMapping("/delete/{id}") // Удалить list по id http://localhost:8082/list/delete/7bc44265-630a-44ce-af01-018cd6260377
    public void deleteList(@PathVariable("id") UUID listId) {
        listServiceInterface.deleteList(listId);
    }

    @GetMapping("/getAll")
    public List<ListDto> getLists() { return listServiceInterface.getLists(); }

    @PostMapping("/postNewList") //Добавить новый список дел по запросу http://localhost:8082/list/postNewList , body: { "nameOfList": "DTO1" }
    public ListDto postList(@RequestBody ListDto dto) {
        return listServiceInterface.postList(dto);
    }

    /*@GetMapping("/getAll")
    public ListDto getLists() { return listServiceInterface.getLists(); }/*

    /*@GetMapping("/getAll") // Получить список списков по запросу http://localhost:8082/list/getAll
    public List<ListDto> getAllLists() {
        List<ListOfLists> getAllLists = listRepository.findAll();
        return converter.modelToDto(getAllLists);
    }*/

    /*@PostMapping("/postNewList") //Добавить новый список дел по запросу http://localhost:8082/list/postNewList , body: { "nameOfList": "DTO1" }
    public ListDto save(@RequestBody ListDto dto) {
        ListOfLists listOfLists = converter.dtoToModel(dto);
        listOfLists = listRepository.save(listOfLists);
        return converter.modelToDto(listOfLists);
    }*/

    @GetMapping("/getOne/{id}") // Получить 1 список по Id http://localhost:8082/list/getOne/44a7fd82-6583-401d-8bff-049ea4de2c95
    public ListDto findById(@PathVariable(value = "id") UUID id) {
        ListOfLists orElse = listRepository.findById(id).orElse(null);
        return converter.modelToDto(orElse);
    }




    /*@GetMapping("/ping") //Проверка связи: по запросу http://localhost:8082/list/ping должен возвращаться pong
    public String ping() {
        return "pong";
    }

    @Autowired
    private ListOfListsRepository listOfListsRepository;


    @PostMapping("/postNewList/{listName}") //Добавить новый список дел по запросу http://localhost:8082/list/postNewList/First
    public @ResponseBody
    String addNewFolder(@PathParam("listName") @PathVariable String listName) {
        ListOfLists newList = new ListOfLists();
        newList.setNameOfList(listName);
        listOfListsRepository.save(newList);
        return listName + " Saved";
    }

    @GetMapping(path = "/getAll") //Получить список списков по запросу http://localhost:8082/list/getAll
    public @ResponseBody
    Iterable<ListOfLists> getAllFolders() {
        return listOfListsRepository.findAll();
    }

    @GetMapping("/getOne/{id}") //Получить один список по номеру id http://localhost:8082/list/getOne/2
    public ListOfLists getOneList(@PathVariable("id") ListOfLists listOfLists) {
        return listOfLists;
    }

    @DeleteMapping("/delete/{id}") //Удалить список по номеру id http://localhost:8082/list/delete/2
    public void delete(@PathVariable("id") ListOfLists listOfLists) {
        listOfListsRepository.delete(listOfLists);
    }*/

}
