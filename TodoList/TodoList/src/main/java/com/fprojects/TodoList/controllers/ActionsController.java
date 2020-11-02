package com.fprojects.TodoList.controllers;



import com.fprojects.TodoList.dto.ActionsDto;
import com.fprojects.TodoList.models.Actions;
import com.fprojects.TodoList.repodatabase.ActionsRepository;
import com.fprojects.TodoList.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Контроллер дел
 */
@RestController
@RequestMapping("/action")
public class ActionsController {

    private final ActionService actionService;

    public ActionsController(ActionService actionService) {
        this.actionService = actionService;
    }

    @DeleteMapping("/delete/{id}") // Удалить дело по номеру id http://localhost:8082/action/delete/2
    public void deleteAction(@PathVariable("id") UUID id) { actionService.deleteAction(id); }

    @GetMapping("/getAll") //Получить список дел по запросу http://localhost:8082/action/getAll
    public List<ActionsDto> getActions(
            @RequestParam(defaultValue = "no") String nameSorting,
            @RequestParam(defaultValue = "no") String creationDateSorting,
            @RequestParam(defaultValue = "no") String changingDateSorting
    ) { return actionService.getActions(nameSorting, creationDateSorting, changingDateSorting); }

    @GetMapping("/getOne/{id}") //Получить один список по номеру id http://localhost:8082/action/getOne/2
    public ActionsDto getOneAction(@PathVariable(value = "id") UUID id) {return actionService.getOneAction(id); }

    @PostMapping("/postNewAction")
    public ActionsDto postAction(@RequestBody ActionsDto actionDto) {
        return actionService.postAction(actionDto);
    }

    @PutMapping("/changeAction/{id}")
    public ActionsDto changeAction(@PathVariable(value = "id") UUID id, @RequestBody ActionsDto actionDto) { return actionService.changeAction(id,  actionDto); }

    @GetMapping("/ping") //Проверка связи: по запросу http://localhost:8082/action/ping должен возвращаться pong
    public String ping() {
        return "pong";
    }


    // TODO: действия с репозитроями вынести в сервис через интерфейс, чтоб мы имели возможность подменить реализацию
    /*private final ActionsRepository actionsRepository;
    @Autowired
    public ActionsController(ActionsRepository actionsRepository) {
        this.actionsRepository = actionsRepository;
    }


    @PostMapping("/postNewAction") //Добавить новое связанное дело по запросу http://localhost:8082/action/postNewAction
    public Actions addNewAction(@RequestBody Actions actionName) {
        return actionsRepository.save(actionName);
    }*/

    /*@GetMapping(path = "/getAll") //Получить список списков по запросу http://localhost:8082/action/getAll
    public @ResponseBody Iterable<Actions> getAllFolders() {
        return actionsRepository.findAll();
    }*/

    /*@GetMapping("/getOne/{id}") //Получить один список по номеру id http://localhost:8082/action/getOne/2
    public Actions getOneList(@PathVariable("id") Actions actions) {
        return actions;
    }*/

    /*@DeleteMapping("/delete/{id}") //Удалить список по номеру id http://localhost:8082/action/delete/2
    public void delete(@PathVariable("id") Actions actions) {
        actionsRepository.delete(actions);
    }*/

}
