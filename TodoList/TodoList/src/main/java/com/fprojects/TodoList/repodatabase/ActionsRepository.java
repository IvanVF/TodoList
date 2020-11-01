package com.fprojects.TodoList.repodatabase;

import com.fprojects.TodoList.models.Actions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Репозисторий дел
 */
public interface ActionsRepository extends JpaRepository<Actions, UUID> {
}
