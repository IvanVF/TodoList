package com.fprojects.TodoList.repodatabase;

import com.fprojects.TodoList.models.ListOfActions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ListOfActionsRepository extends JpaRepository<ListOfActions, UUID> {
}
