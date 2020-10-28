package com.fprojects.TodoList.controllers;



import com.fprojects.TodoList.models.Actions;
import com.fprojects.TodoList.repodatabase.ActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Java-doc и у метолдов тоже
 */
@RestController
@RequestMapping("/action")
public class ActionsController {

    @GetMapping("/ping") //Проверка связи: по запросу http://localhost:8082/action/ping должен возвращаться pong
    public String ping() {
        return "pong";
    }

    // TODO: действия с репозитроями вынести в сервис через интерфейс, чтоб мы имели возможность подменить реализацию
    private final ActionsRepository actionsRepository;
    @Autowired
    public ActionsController(ActionsRepository actionsRepository) {
        this.actionsRepository = actionsRepository;
    }


    @PostMapping("/postNewAction") //Добавить новый связанный список дел по запросу http://localhost:8082/action/postNewAction
    public Actions addNewAction(@RequestBody Actions actionName) {
        return actionsRepository.save(actionName);
    }

    @GetMapping(path = "/getAll") //Получить список списков по запросу http://localhost:8082/action/getAll
    public @ResponseBody
    Iterable<Actions> getAllFolders() {
        return actionsRepository.findAll();
    }

    @GetMapping("/getOne/{id}") //Получить один список по номеру id http://localhost:8082/action/getOne/2
    public Actions getOneList(@PathVariable("id") Actions actions) {
        return actions;
    }

    @DeleteMapping("/delete/{id}") //Удалить список по номеру id http://localhost:8082/action/delete/2
    public void delete(@PathVariable("id") Actions actions) {
        actionsRepository.delete(actions);
    }

}
