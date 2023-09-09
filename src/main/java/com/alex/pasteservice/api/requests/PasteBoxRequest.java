package com.alex.pasteservice.api.requests;

import lombok.Data;

@Data
public class PasteBoxRequest {

    private String data;
    private Long expirationTimeSeconds;
    private PublicStatus publicStatus;
}
