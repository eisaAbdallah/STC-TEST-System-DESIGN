package com.example.stc.test.repository.impl;

import com.example.stc.test.data.ItemResponse;
import com.example.stc.test.model.Files;
import com.example.stc.test.model.Item;
import com.example.stc.test.model.PermissionGroups;
import com.example.stc.test.model.Permissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.resource.cci.ResultSet;
import javax.transaction.Transactional;

import java.sql.SQLException;
import java.util.List;


@Repository
public class RepositoryImpl implements RepositorySTC{
    @Autowired
    EntityManager entityManager;
    @Autowired
    JdbcTemplate jdbcTemplate;
    ItemResponse  itemResponse=null;
    @Override
    @Transactional
    public void createSpace(Item item) {
        this.entityManager.merge(item);
    }

    @Override
    @Transactional
    public PermissionGroups findGroupByName(String admin) {

        TypedQuery<PermissionGroups> query=entityManager.createQuery("from PermissionGroups where groupName =?1",PermissionGroups.class);
        query.setParameter(1,admin);
        query.setMaxResults(1);
        PermissionGroups permissionGroups=query.getSingleResult();
        return permissionGroups;
    }

    @Override
    @Transactional
    public Permissions findPermissionByEmail(String email) {
        TypedQuery<Permissions> query=entityManager.createQuery("from Permissions where userEmail =?1",Permissions.class);
        query.setParameter(1,email);
        query.setMaxResults(1);
        Permissions permissions=query.getSingleResult();

        return permissions;
    }

    @Override
    @Transactional
    public Item findFileByTypeAndName(String type, String name) {
        TypedQuery<Item> query=entityManager.createQuery("from Item where type =?1 AND name=?2",Item.class);
        query.setParameter(1,type);
        query.setParameter(2,name);
        query.setMaxResults(1);
        Item files=query.getSingleResult();

        return files;
    }

    @Override
    @Transactional
    public void createFileBinary(Files filesBody) {
        this.entityManager.merge(filesBody);
    }

    @Override
    public ItemResponse getFileDetails(String type, String name) {





        List<ItemResponse> itemResponseList=   this.jdbcTemplate.query("select * from item where type = ? And name = ?", new RowMapper<ItemResponse>() {

            @Override
            public ItemResponse mapRow(java.sql.ResultSet rs, int rowNum) throws SQLException {
                itemResponse=new ItemResponse(rs.getInt("id"),rs.getString("type"),rs.getString("name"),rs.getInt("permissions_id"),rs.getInt("permission_group_id"));

                return itemResponse;
            }
        },new Object[]{type,name});

        return itemResponse;
            }



    @Override
    @Transactional
    public Permissions getPermissionById(String userEmail) {
        TypedQuery<Permissions> query=entityManager.createQuery("from Permissions where   userEmail =?1  ",Permissions.class);
        query.setParameter(1,userEmail);

        query.setMaxResults(1);
        Permissions permissions=query.getSingleResult();
        return permissions;
    }


}

