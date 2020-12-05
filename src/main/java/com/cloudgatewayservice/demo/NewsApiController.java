package com.cloudgatewayservice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsApiController {
    @Autowired
    private NewsGatewayService service;

    @GetMapping("/topHeadlines")
    public String getTopHeadlines(){
        return service.getTopHeadlines();
    }

    @GetMapping("/search/{keyword}")
    public String searchFor(@PathVariable String keyword){
        return service.searchFor(keyword);
    }
}
