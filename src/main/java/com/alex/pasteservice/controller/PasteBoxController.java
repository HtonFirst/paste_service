package com.alex.pasteservice.controller;

import com.alex.pasteservice.api.requests.PasteBoxRequest;
import com.alex.pasteservice.api.responses.PasteBoxResponse;
import com.alex.pasteservice.api.responses.PasteBoxUrlResponse;
import com.alex.pasteservice.service.PasteBoxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PasteBoxController {

    private final PasteBoxService service;

    @GetMapping("/")
    public List<PasteBoxResponse> getPublicPasteList() {
        return service.getFirstPublikPastBoxes();
    }

    @GetMapping("/{hash}")
    public PasteBoxResponse getByHash(@PathVariable String hash) {
        return service.getByHash(hash);
    }

    @PostMapping("/")
    public PasteBoxUrlResponse add(@RequestBody PasteBoxRequest request) {
        return  service.create(request);
    }
}
