package com.fprojects.TodoList.repodatabase;

import com.fprojects.TodoList.models.Actions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Репозисторий дел
 */
@Repository
public interface ActionsRepository extends JpaRepository<Actions, UUID> {
}
