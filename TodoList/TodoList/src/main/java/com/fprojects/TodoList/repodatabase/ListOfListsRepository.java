package com.fprojects.TodoList.repodatabase;

import com.fprojects.TodoList.models.ListOfLists;
import org.springframework.data.repository.CrudRepository;

public interface ListOfListsRepository extends CrudRepository<ListOfLists, Long>{
}
