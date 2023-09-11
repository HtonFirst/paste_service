package com.alex.pasteservice.service;

import com.alex.pasteservice.api.requests.PasteBoxRequest;
import com.alex.pasteservice.api.requests.PublicStatus;
import com.alex.pasteservice.api.responses.PasteBoxResponse;
import com.alex.pasteservice.api.responses.PasteBoxUrlResponse;
import com.alex.pasteservice.repository.PasteBoxEntity;
import com.alex.pasteservice.repository.PasteBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "app")
public class PasteBoxServiceImpl implements PasteBoxService {

    private String host;
    private int publicListSize;

    private final PasteBoxRepository repository;
    private final AtomicInteger atomic = new AtomicInteger(0);

    @Override
    public PasteBoxResponse getByHash(String hash) {
        PasteBoxEntity pasteBoxEntity = repository.getByHash(hash);
        return  new PasteBoxResponse(pasteBoxEntity.getData(), pasteBoxEntity.isPublic());

    }

    @Override
    public List<PasteBoxResponse> getFirstPublikPastBoxes() {
        return null;
    }

    @Override
    public PasteBoxUrlResponse create(PasteBoxRequest request) {
        int hash = generateId();
        PasteBoxEntity entity = new PasteBoxEntity();
        entity.setData(request.getData());
        entity.setId(hash);
        entity.setHash(Integer.toHexString(hash));
        entity.setPublic(request.getPublicStatus() == PublicStatus.PUBLIC);
        repository.add(entity);

       return new PasteBoxUrlResponse(host + "/" + entity.getHash());

    }

    private int generateId() {
      return   atomic.getAndIncrement();
    }
}
