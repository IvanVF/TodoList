package com.fprojects.TodoList.controllers;

import com.fprojects.TodoList.models.ListOfFolders;
import com.fprojects.TodoList.repodatabase.ListOfFoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/list")
public class ListOfFoldersController {


    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @Autowired
    private ListOfFoldersRepository listOfFoldersRepository;


    @PostMapping("/addNewFolder/{folderName}") //Добавить новую папку со списком дел по запросу http://localhost:8082/list/addNewFolder/First
    public @ResponseBody
    String addNewFolder(@PathParam("folderName") @PathVariable String folderName) {
        ListOfFolders newFolder = new ListOfFolders();
        newFolder.setNameOfDBFolder(folderName);
        listOfFoldersRepository.save(newFolder);
        return folderName + " Saved";
    }

    @GetMapping(path = "/all") //Получить список папок по запросу http://localhost:8082/list/all
    public @ResponseBody
    Iterable<ListOfFolders> getAllFolders() {
        return listOfFoldersRepository.findAll();
    }

    @RequestMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFolder(@PathVariable String id) {

    }

    @GetMapping("/{id}")
    public ListOfFolders getOne(@PathVariable("id") ListOfFolders listOfFolders) { return listOfFolders; }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") ListOfFolders listOfFolders) { listOfFoldersRepository.delete(listOfFolders); }

}
