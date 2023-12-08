package com.example.stc.test.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name="permissions")
@NoArgsConstructor
@Getter
@Setter
public class Permissions  {
    @Id

    @Column(name="id")
    int id;
    @Column(name="user_email")
    String userEmail;
    @Column(name="permission_level")
    String permission_level;

    @OneToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    PermissionGroups permissionGroups;
    @OneToOne(mappedBy = "permissions")
            @Transient
    Item item;



}
