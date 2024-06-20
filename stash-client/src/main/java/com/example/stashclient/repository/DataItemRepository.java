package com.example.stashclient.repository;

import com.example.stashclient.model.DataItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DataItemRepository extends JpaRepository<DataItem, Long> {
    Optional<DataItem> findBySsn(String ssn);

}
