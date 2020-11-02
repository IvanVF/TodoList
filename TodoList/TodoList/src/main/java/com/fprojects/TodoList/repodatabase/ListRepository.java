package com.fprojects.TodoList.repodatabase;

import com.fprojects.TodoList.models.ListOfLists;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Репозиторий списка дел
 */
public interface ListRepository extends JpaRepository<ListOfLists, UUID> {
}
