package com.fprojects.TodoList.services;

import com.fprojects.TodoList.converter.ListConverter;
import com.fprojects.TodoList.dto.ListDto;
import com.fprojects.TodoList.models.ListOfLists;
import com.fprojects.TodoList.repodatabase.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ListServiceImplement implements ListServiceInterface {

    private final ListRepository listRepository;

    @Autowired
    ListConverter converter;

    public ListServiceImplement(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Override
    public List<ListDto> getLists() {
        List<ListOfLists> list = listRepository.findAll();
        List<ListDto> listDto = list.stream().map(it -> converter.modelToDto(it)).collect(Collectors.toList());
        return listDto;
    }

    @Override
    public void deleteList(UUID listId) { listRepository.deleteById(listId); }

}
