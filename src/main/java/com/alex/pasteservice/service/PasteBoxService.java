package com.alex.pasteservice.service;

import com.alex.pasteservice.api.requests.PasteBoxRequest;
import com.alex.pasteservice.api.responses.PasteBoxResponse;
import com.alex.pasteservice.api.responses.PasteBoxUrlResponse;

import java.util.List;

public interface PasteBoxService {
    PasteBoxResponse getByHash(String hash);
    List<PasteBoxResponse> getFirstPublikPastBoxes();
    PasteBoxUrlResponse create(PasteBoxRequest request);




}
