package com.fprojects.TodoList.repodatabase;

import com.fprojects.TodoList.models.ListOfFolders;
import org.springframework.data.repository.CrudRepository;

public interface ListOfFoldersRepository extends CrudRepository<ListOfFolders, Long> {
}
