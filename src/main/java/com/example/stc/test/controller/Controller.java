package com.example.stc.test.controller;

import com.example.stc.test.data.CreateRequestDTO;
import com.example.stc.test.data.ItemResponse;
import com.example.stc.test.model.Item;
import com.example.stc.test.service.impl.BackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.stc.test.urls.RequestUrls.*;

@RestController
public class Controller {
@Autowired
    BackingService backingService;
@PostMapping(CREATE_SPACE)
public ResponseEntity<?> createSpace(@RequestBody CreateRequestDTO createRequestDTO){


    this.backingService.createSpace(createRequestDTO);

    return ResponseEntity.ok().body("Space Created Successfully");
 }
    @PostMapping(CREATE_FOLDER)
    public ResponseEntity<?> createFolder(@RequestBody CreateRequestDTO createRequestDTO){


        this.backingService.createFolder(createRequestDTO);

        return ResponseEntity.ok().body("Folder Created Successfully");
    }
    @PostMapping(CREATE_FILE)
    public ResponseEntity<?> createFile(@RequestBody CreateRequestDTO createRequestDTO){


        this.backingService.createFile(createRequestDTO);

        return ResponseEntity.ok().body("File Created Successfully");
    }

    @GetMapping(VIEW_FILE_DETAILS)
    public ResponseEntity<?> getFileDetails(@RequestParam("type")String type,@RequestParam("email")String email,@RequestParam("name")String name ){
        CreateRequestDTO createRequestDTO=new CreateRequestDTO();
        createRequestDTO.setName(name);
        createRequestDTO.setUserEmail(email);
        createRequestDTO.setType(type);
        ItemResponse item=   this.backingService.getFileDetails(createRequestDTO);

        return ResponseEntity.ok().body(item);
    }
    
}
