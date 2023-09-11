package com.alex.pasteservice.api.responses;

import com.alex.pasteservice.api.requests.PublicStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PasteBoxResponse {
    private final String data;
    private final boolean isPublic;
}
