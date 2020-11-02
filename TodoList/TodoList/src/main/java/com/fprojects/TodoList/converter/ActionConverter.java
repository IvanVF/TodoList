package com.fprojects.TodoList.converter;

import com.fprojects.TodoList.dto.ActionsDto;
import com.fprojects.TodoList.models.Actions;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Конвертер дел из entity в DTO и обратно
 */
@Component
public class ActionConverter {

    public ActionsDto modelToDto(Actions actions) {
        ModelMapper mapper = new ModelMapper();
        ActionsDto map = mapper.map(actions, ActionsDto.class);
        return map;
    }

    public List<ActionsDto> modelToDto(List<Actions> actions) {
        return actions.stream().map(x -> modelToDto(x)).collect(Collectors.toList());
    }

    public Actions dtoToModel(ActionsDto dto) {
        ModelMapper mapper = new ModelMapper();
        Actions map = mapper.map(dto, Actions.class);
        return map;
    }

    public List<Actions> dtoToModel(List<ActionsDto> dto) {
        return dto.stream().map(x -> dtoToModel(x)).collect(Collectors.toList());
    }


}
