package com.fprojects.TodoList.converter;

import com.fprojects.TodoList.dto.ListDto;
import com.fprojects.TodoList.models.ListOfLists;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListConverter {

    public ListDto modelToDto(ListOfLists listOfLists) {
        ModelMapper mapper = new ModelMapper();
        ListDto map = mapper.map(listOfLists, ListDto.class);
        return map;
    }

    public List<ListDto> modelToDto(List<ListOfLists> listOfLists) {
        return listOfLists.stream().map(x -> modelToDto(x)).collect(Collectors.toList());
    }

    public ListOfLists dtoToModel(ListDto dto) {
        ModelMapper mapper = new ModelMapper();
        ListOfLists map = mapper.map(dto, ListOfLists.class);
        return map;
    }

    public List<ListOfLists> dtoToModel(List<ListDto> dto) {
        return dto.stream().map(x -> dtoToModel(x)).collect(Collectors.toList());
    }

}
