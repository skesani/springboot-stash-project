package com.example.stashservice.service;

import com.example.stashservice.model.DataItem;
import com.example.stashservice.repository.DataItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DataItemService {

    private static final Logger logger = LoggerFactory.getLogger(DataItemService.class);

    private final DataItemRepository dataItemRepository;

    @Autowired
    public DataItemService(DataItemRepository dataItemRepository) {
        this.dataItemRepository = dataItemRepository;
    }

    public Optional<DataItem> findById(Long id) {
        return dataItemRepository.findById(id);
    }

    public Optional<DataItem> findByStashKey(String stashKey) {
        logger.info("Searching for DataItem with stashKey: {}", stashKey);
        return dataItemRepository.findByStashKey(stashKey);
    }
}
