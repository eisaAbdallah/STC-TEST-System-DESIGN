package com.example.stc.test.model;
import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="permission_groups")
@NoArgsConstructor
@Getter
@Setter
public class PermissionGroups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;

    @Column(name="group_name")
    String groupName;

    @OneToMany(mappedBy="permissionGroups")
    List<Item> item;

    @OneToOne(mappedBy = "permissionGroups")
    @Transient
    Permissions permissions;
}
