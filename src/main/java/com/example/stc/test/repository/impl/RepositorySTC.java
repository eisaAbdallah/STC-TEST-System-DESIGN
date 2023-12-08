package com.example.stc.test.repository.impl;

import com.example.stc.test.data.ItemResponse;
import com.example.stc.test.model.Files;
import com.example.stc.test.model.Item;
import com.example.stc.test.model.PermissionGroups;
import com.example.stc.test.model.Permissions;

public interface RepositorySTC {

    void createSpace(Item item);

    PermissionGroups findGroupByName(String admin);

    Permissions findPermissionByEmail(String group);

    Item findFileByTypeAndName(String type, String name);

    void createFileBinary(Files filesBody);

    ItemResponse getFileDetails(String type, String name);

    Permissions getPermissionById(String permissions);
}
