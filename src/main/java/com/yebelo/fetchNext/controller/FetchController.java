package com.yebelo.fetchNext.controller;

import com.yebelo.fetchNext.exception.CategoryCodeNotFoundException;
import com.yebelo.fetchNext.model.Category;
import com.yebelo.fetchNext.model.CategoryResponse;
import com.yebelo.fetchNext.service.FetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FetchController {

    /* to inject the FetchService bean */
    @Autowired
    private FetchService fetchService;

    /*
        url: http://localhost:8080/FetchNextNumber
        Http method: post
        { "categoryCode" : 10 }
     */
    @PostMapping(value = "/FetchNextNumber",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryResponse> fetchNextNum(@RequestBody Category category) throws CategoryCodeNotFoundException {
       CategoryResponse response = fetchService.fetchNextValue(category.getCategoryCode());
        return ResponseEntity.ok(response);
    }
}
