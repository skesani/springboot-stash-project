package com.example.stashservice.repository;

import com.example.stashservice.model.DataItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DataItemRepository extends JpaRepository<DataItem, Long> {

    @Query(value = "SELECT * FROM public.data_item WHERE stash_key = :stashKey", nativeQuery = true)
    Optional<DataItem> findByStashKey(@Param("stashKey") String stashKey);
}
