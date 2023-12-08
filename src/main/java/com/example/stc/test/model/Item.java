package com.example.stc.test.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="item")
@NoArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @Column(name="type")
    String type;
    @Column(name="name")
    String name;

    @ManyToOne
    @JoinColumn(name="permission_group_id")
     PermissionGroups permissionGroups;
    @OneToOne
    @JoinColumn(name="permissions_id")
    Permissions permissions;

    @OneToOne(mappedBy = "item")
    @Transient
    Files files;

}
