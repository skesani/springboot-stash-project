package com.example.stashclient.controller;

import com.example.stashclient.model.DataItem;
import com.example.stashclient.service.DataItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/data")
public class DataItemController {

    private final DataItemService dataItemService;

    @Autowired
    public DataItemController(DataItemService dataItemService) {
        this.dataItemService = dataItemService;
    }

    @GetMapping("/home")
    public String home(@RequestParam(value = "ssn", required = false) String ssn, Model model) {
        if (ssn != null) {
            Optional<DataItem> clientDataItem = dataItemService.findBySsn(ssn);
            Optional<String> stashValue = dataItemService.fetchStashValue(ssn);

            if (clientDataItem.isPresent() && stashValue.isPresent()) {
                DataItem dataItem = clientDataItem.get();
                model.addAttribute("dataItem", dataItem);
                model.addAttribute("editableField", stashValue.get());
            }
        }
        return "stashForm";
    }
}
