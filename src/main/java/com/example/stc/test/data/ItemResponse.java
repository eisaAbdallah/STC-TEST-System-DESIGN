package com.example.stc.test.data;

import com.example.stc.test.model.PermissionGroups;
import com.example.stc.test.model.Permissions;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class ItemResponse {

    int id;

    String type;

    String name;

    int permissionGroups;

    int permissions;

    public ItemResponse(int id, String type, String name, int permissionGroups, int permissions) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.permissionGroups = permissionGroups;
        this.permissions = permissions;
    }
}
