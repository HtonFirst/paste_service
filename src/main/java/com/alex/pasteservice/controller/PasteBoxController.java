package com.alex.pasteservice.controller;

import com.alex.pasteservice.api.requests.PasteBoxRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
public class PasteBoxController {

    @GetMapping("/")
    public Collection<String> getPublicPasteList() {
        return Collections.emptyList();
    }

    @GetMapping("/{hash}")
    public String getByHash(@PathVariable String hash) {
        return "hash = " + hash;
    }

    @PostMapping("/")
    public String  add(@RequestBody PasteBoxRequest request) {
        return  request.getData();
    }
}
