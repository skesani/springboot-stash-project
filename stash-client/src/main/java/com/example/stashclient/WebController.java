
package com.example.stashclient;

import com.example.stashclient.model.DataItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WebController {

    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String key) {
        if (key != null) {
            String url = "http://localhost:8080/api/data/key/" + key;
            DataItem dataItem = restTemplate.getForObject(url, DataItem.class);
            model.addAttribute("dataItem", dataItem);
        }
        return "stashForm";
    }
}
