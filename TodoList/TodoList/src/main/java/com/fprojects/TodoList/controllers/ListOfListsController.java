package com.fprojects.TodoList.controllers;

import com.fprojects.TodoList.models.ListOfLists;
import com.fprojects.TodoList.repodatabase.ListOfListsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/list")
public class ListOfListsController {


    @GetMapping("/ping") //Проверка связи: по запросу http://localhost:8082/list/ping должен возвращаться pong
    public String ping() {
        return "pong";
    }

    @Autowired
    private ListOfListsRepository listOfListsRepository;


    @PostMapping("/postNewList/{listName}") //Добавить новый список дел по запросу http://localhost:8082/list/postNewList/First
    public @ResponseBody
    String addNewFolder(@PathParam("listName") @PathVariable String listName) {
        ListOfLists newList = new ListOfLists();
        newList.setNameOfDBFolder(listName);
        listOfListsRepository.save(newList);
        return listName + " Saved";
    }

    @GetMapping(path = "/getAll") //Получить список списков по запросу http://localhost:8082/list/getAll
    public @ResponseBody
    Iterable<ListOfLists> getAllFolders() {
        return listOfListsRepository.findAll();
    }

    @GetMapping("/getOne/{id}") //Получить один список по запросу http://localhost:8082/list/all
    public ListOfLists getOneList(@PathVariable("id") ListOfLists listOfLists) {
        return listOfLists;
    }

    @DeleteMapping("/delete/{id}") //Удалить список по запросу http://localhost:8082/list/delete/2
    public void delete(@PathVariable("id") ListOfLists listOfLists) {
        listOfListsRepository.delete(listOfLists);
    }

}
