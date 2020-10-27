package com.fprojects.TodoList.controllers;

import com.fprojects.TodoList.converter.ListConverter;
import com.fprojects.TodoList.dto.ListDto;
import com.fprojects.TodoList.models.ListOfLists;
import com.fprojects.TodoList.repodatabase.ListOfListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ListOfListsController {

    // TODO: действия с репозитроями вынести в сервис через интерфейс, чтоб мы имели возможность подменить реализацию
    @Autowired
    ListOfListsRepository listOfListsRepository;
    @Autowired
    ListConverter converter;

    @GetMapping("/getAll")
    public List<ListDto> getAllLists() {
        List<ListOfLists> getAllLists = listOfListsRepository.findAll();
        return converter.modelToDto(getAllLists);
    }

    @PostMapping("/postNewList")
    public ListDto save(@RequestBody ListDto dto) {
        ListOfLists listOfLists = converter.dtoToModel(dto);
        listOfLists = listOfListsRepository.save(listOfLists);
        return converter.modelToDto(listOfLists);
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
