package com.example.stashservice.controller;

import com.example.stashservice.model.DataItem;
import com.example.stashservice.service.DataItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/data")
public class DataItemController {

    private static final Logger logger = LoggerFactory.getLogger(DataItemController.class);

    private final DataItemService dataItemService;

    @Autowired
    public DataItemController(DataItemService dataItemService) {
        this.dataItemService = dataItemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataItem> getDataById(@PathVariable Long id) {
        return dataItemService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/key/{stashKey}")
    public ResponseEntity<DataItem> getDataByStashKey(@PathVariable String stashKey) {
        logger.info("Received request for DataItem with stashKey: {}", stashKey);
        return dataItemService.findByStashKey(stashKey)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
