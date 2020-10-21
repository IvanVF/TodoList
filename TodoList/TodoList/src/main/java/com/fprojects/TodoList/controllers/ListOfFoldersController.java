package com.fprojects.TodoList.controllers;

import com.fprojects.TodoList.models.ListOfFolders;
import com.fprojects.TodoList.repodatabase.ListOfFoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/addNewFolder/{folderName}")
    public @ResponseBody
    String addNewFolder(@PathParam("folderName") @PathVariable String folderName) {
        ListOfFolders newFolder = new ListOfFolders();
        newFolder.setNameOfDBFolder(folderName);
        listOfFoldersRepository.save(newFolder);
        return folderName + " Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<ListOfFolders> getAllFolders() {
        return listOfFoldersRepository.findAll();
    }

}
