package com.example.stc.test.service.impl;

import com.example.stc.test.data.CreateRequestDTO;

import com.example.stc.test.data.ItemResponse;
import com.example.stc.test.exception.RuntimeExceptionCutomized;
import com.example.stc.test.model.Files;
import com.example.stc.test.model.Item;
import com.example.stc.test.model.PermissionGroups;
import com.example.stc.test.model.Permissions;
import com.example.stc.test.repository.impl.RepositorySTC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

@Service
public class BackingServiceImpl implements  BackingService {
    @Autowired
    RepositorySTC repository;

    @Override
    public void createSpace(CreateRequestDTO createRequestDTO) {
        Item item=new Item();
        PermissionGroups permissionGroups= this.repository.findGroupByName(createRequestDTO.getGroup());
        if(permissionGroups==null){

            throw new RuntimeExceptionCutomized("No Group Found", HttpStatus.NOT_FOUND);
        }
        Permissions permissions= this.repository.findPermissionByEmail(createRequestDTO.getUserEmail());

        item.setName(createRequestDTO.getName());
        item.setType(createRequestDTO.getType());
        item.setPermissionGroups(permissionGroups);
        item.setPermissions(permissions);
        this.repository.createSpace(item);

    }

    @Override
    public void createFolder(CreateRequestDTO createRequestDTO) {
        Item item=new Item();
        PermissionGroups permissionGroups= this.repository.findGroupByName(createRequestDTO.getGroup());
        if(permissionGroups==null){

            throw new RuntimeExceptionCutomized("No Group Found", HttpStatus.NOT_FOUND);
        }
        Permissions permissions= this.repository.findPermissionByEmail(createRequestDTO.getUserEmail());

        item.setName(createRequestDTO.getName());
        item.setType(createRequestDTO.getType());
        item.setPermissionGroups(permissionGroups);
        item.setPermissions(permissions);
        this.repository.createSpace(item);
    }

    @Override
    public void createFile(CreateRequestDTO createRequestDTO) {
        Item item=new Item();
        PermissionGroups permissionGroups= this.repository.findGroupByName(createRequestDTO.getGroup());
        if(permissionGroups==null){

            throw new RuntimeExceptionCutomized("No Group Found", HttpStatus.NOT_FOUND);
        }
        Permissions permissions= this.repository.findPermissionByEmail(createRequestDTO.getUserEmail());

        item.setName(createRequestDTO.getName());
        item.setType(createRequestDTO.getType());
        item.setPermissionGroups(permissionGroups);
        item.setPermissions(permissions);

        this.repository.createSpace(item);
        Item files= this.repository.findFileByTypeAndName(createRequestDTO.getType(),createRequestDTO.getName());
        Files filesBody=new Files();
        filesBody.setItem(files);

        filesBody.setFile("test".getBytes(StandardCharsets.UTF_8));
        this.repository.createFileBinary(filesBody);


    }

    @Override
    public ItemResponse getFileDetails(CreateRequestDTO createRequestDTO) {

      ItemResponse item=  this.repository.getFileDetails(createRequestDTO.getType(),createRequestDTO.getName());



      Permissions permissions=this.repository.getPermissionById(createRequestDTO.getUserEmail());
        if(!permissions.getPermission_level().equals("EDIT")){


            throw new RuntimeExceptionCutomized("You Are Not Allowed To View This File Details",HttpStatus.UNAUTHORIZED);
        }
      return item;
    }


    }

