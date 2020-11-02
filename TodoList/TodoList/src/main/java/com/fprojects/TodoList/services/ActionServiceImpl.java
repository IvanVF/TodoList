package com.fprojects.TodoList.services;

import com.fprojects.TodoList.converter.ActionConverter;
import com.fprojects.TodoList.dto.ActionsDto;
import com.fprojects.TodoList.models.Actions;
import com.fprojects.TodoList.repodatabase.ActionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Релизация интерфейса сервиса дел
 */
@Service
@Transactional
public class ActionServiceImpl implements ActionService {

    private final ActionsRepository actionsRepository;
    public ActionServiceImpl(ActionsRepository actionsRepository) { this.actionsRepository = actionsRepository; }

    @Autowired
    ActionConverter converter;

    @Override
    public void deleteAction(UUID id) { actionsRepository.deleteById(id); }

    @Override
    public List<ActionsDto> getActions() {
        List<Actions> actions = actionsRepository.findAll(Sort.by("nameOfAction").ascending());
        List<ActionsDto> actionsDtoList = actions.stream().map(it -> converter.modelToDto(it)).collect(Collectors.toList());
        return actionsDtoList;
    }

    @Override
    public ActionsDto getOneAction(UUID id) {
        Actions action = actionsRepository.findById(id).orElse(null);
        return converter.modelToDto(action);
    }

    @Override
    public ActionsDto postAction(ActionsDto actionDto) {
        actionDto.setCreationDate(LocalDateTime.now());
        Actions action = converter.dtoToModel(actionDto);
        action = actionsRepository.save(action);
        return converter.modelToDto(action);
    }

    @Override
    public ActionsDto changeAction(UUID id, ActionsDto actionDto) {
        actionDto.setChangingDate(LocalDateTime.now());

        Actions action = converter.dtoToModel(actionDto);
        action = actionsRepository.save(action);
        return converter.modelToDto(action);
    }

}
