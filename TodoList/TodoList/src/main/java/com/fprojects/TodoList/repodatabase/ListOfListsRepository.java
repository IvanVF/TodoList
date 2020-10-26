package com.fprojects.TodoList.repodatabase;

import com.fprojects.TodoList.models.ListOfLists;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ListOfListsRepository extends CrudRepository<ListOfLists, UUID>{
}
