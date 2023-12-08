package com.example.stc.test.service.impl;

import com.example.stc.test.data.CreateRequestDTO;
import com.example.stc.test.data.ItemResponse;
import com.example.stc.test.model.Item;

public interface BackingService {
    void createSpace(CreateRequestDTO createRequestDTO);

    void createFolder(CreateRequestDTO createRequestDTO);

    void createFile(CreateRequestDTO createRequestDTO);

    ItemResponse getFileDetails(CreateRequestDTO createRequestDTO);
}
