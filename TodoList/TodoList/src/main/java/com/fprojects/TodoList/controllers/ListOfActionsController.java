package com.fprojects.TodoList.controllers;



import com.fprojects.TodoList.models.ListOfActions;
import com.fprojects.TodoList.models.ListOfLists;
import com.fprojects.TodoList.repodatabase.ListOfActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/action")
public class ListOfActionsController {

    @GetMapping("/ping") //Проверка связи: по запросу http://localhost:8082/action/ping должен возвращаться pong
    public String ping() {
        return "pong";
    }

    private final ListOfActionsRepository listOfActionsRepository;
    @Autowired
    public ListOfActionsController(ListOfActionsRepository listOfActionsRepository) {
        this.listOfActionsRepository = listOfActionsRepository;
    }

    /*@PostMapping("/postNewAction/{actionName}") //Добавить новый список дел по запросу http://localhost:8082/action/postNewAction/First
    public @ResponseBody
    String addNewFolder(@PathParam("actionName") @PathVariable String actionName) {
        ListOfActions newAction = new ListOfActions();
        newAction.setNameOfAction(actionName);
        listOfActionsRepository.save(newAction);
        return actionName + " Saved";
    }*/

    @PostMapping("/postNewAction") //Добавить новый список дел по запросу http://localhost:8082/action/postNewAction/First
    public ListOfActions addNewAction(@RequestBody ListOfActions actionName) {
        return listOfActionsRepository.save(actionName);
        //ListOfActions newAction = new ListOfActions();
        //newAction.setNameOfAction(actionName);
        //listOfActionsRepository.save(newAction);
        //return actionName + " Saved";
    }

    @GetMapping(path = "/getAll") //Получить список списков по запросу http://localhost:8082/action/getAll
    public @ResponseBody
    Iterable<ListOfActions> getAllFolders() {
        return listOfActionsRepository.findAll();
    }

    @GetMapping("/getOne/{id}") //Получить один список по номеру id http://localhost:8082/action/getOne/2
    public ListOfActions getOneList(@PathVariable("id") ListOfActions listOfActions) {
        return listOfActions;
    }

    @DeleteMapping("/delete/{id}") //Удалить список по номеру id http://localhost:8082/action/delete/2
    public void delete(@PathVariable("id") ListOfActions listOfActions) {
        listOfActionsRepository.delete(listOfActions);
    }

}
