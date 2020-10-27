package com.fprojects.TodoList.controllers;



import com.fprojects.TodoList.models.ListOfActions;
import com.fprojects.TodoList.repodatabase.ActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/action")
public class ActionsController {

    @GetMapping("/ping") //Проверка связи: по запросу http://localhost:8082/action/ping должен возвращаться pong
    public String ping() {
        return "pong";
    }

    private final ActionsRepository actionsRepository;
    @Autowired
    public ActionsController(ActionsRepository actionsRepository) {
        this.actionsRepository = actionsRepository;
    }


    @PostMapping("/postNewAction") //Добавить новый связанный список дел по запросу http://localhost:8082/action/postNewAction
    public ListOfActions addNewAction(@RequestBody ListOfActions actionName) {
        return actionsRepository.save(actionName);
    }

    @GetMapping(path = "/getAll") //Получить список списков по запросу http://localhost:8082/action/getAll
    public @ResponseBody
    Iterable<ListOfActions> getAllFolders() {
        return actionsRepository.findAll();
    }

    @GetMapping("/getOne/{id}") //Получить один список по номеру id http://localhost:8082/action/getOne/2
    public ListOfActions getOneList(@PathVariable("id") ListOfActions listOfActions) {
        return listOfActions;
    }

    @DeleteMapping("/delete/{id}") //Удалить список по номеру id http://localhost:8082/action/delete/2
    public void delete(@PathVariable("id") ListOfActions listOfActions) {
        actionsRepository.delete(listOfActions);
    }

}
