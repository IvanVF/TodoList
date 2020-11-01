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

/**
 * Релизация интерфейса сервиса спискрв
 */
@Service
@Transactional
public class ListServiceImplement implements ListServiceInterface {

    private final ListRepository listRepository;
    public ListServiceImplement(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Autowired
    ListConverter converter;

    @Override
    public void deleteList(UUID listId) { listRepository.deleteById(listId); } // Реализация метода удалить список

    @Override
    public List<ListDto> getLists() { // Реализация метода получить список списков
        List<ListOfLists> list = listRepository.findAll();
        List<ListDto> listDto = list.stream().map(it -> converter.modelToDto(it)).collect(Collectors.toList());
        return listDto;
    }

    @Override
    public ListDto getOneList(UUID id) { // Реализация метода получить один список
        ListOfLists orElse = listRepository.findById(id).orElse(null);
        return converter.modelToDto(orElse);
    }

    @Override
    public ListDto postList(ListDto listDto) { // Реализация метода добавить список
        ListOfLists list = converter.dtoToModel(listDto);
        list = listRepository.save(list);
        return converter.modelToDto(list);
    }
}
