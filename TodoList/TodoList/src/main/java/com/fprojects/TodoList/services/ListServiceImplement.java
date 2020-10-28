package com.fprojects.TodoList.services;

import com.fprojects.TodoList.repodatabase.ListRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class ListServiceImplement implements ListServiceInterface {

    private final ListRepository listRepository;

    public ListServiceImplement(ListRepository listRepository) {
        this.listRepository = listRepository;
    }

    @Override
    public void deleteList(UUID listId) { listRepository.deleteById(listId); }

}
