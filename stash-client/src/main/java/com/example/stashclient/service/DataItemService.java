package com.example.stashclient.service;

import com.example.stashclient.model.DataItem;
import com.example.stashclient.model.StashDataItem;
import com.example.stashclient.repository.DataItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class DataItemService {

    private final DataItemRepository dataItemRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public DataItemService(DataItemRepository dataItemRepository, RestTemplate restTemplate) {
        this.dataItemRepository = dataItemRepository;
        this.restTemplate = restTemplate;
    }

    public Optional<DataItem> findBySsn(String ssn) {
        return dataItemRepository.findBySsn(ssn);
    }

    public Optional<String> fetchStashValue(String ssn) {
        String url = "http://localhost:8080/api/data/key/" + ssn; // Replace with actual stash server URL
        try {
            StashDataItem stashDataItem = restTemplate.getForObject(url, StashDataItem.class);
            return Optional.ofNullable(stashDataItem.getStashValue());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
