INSERT INTO permission_groups  (id,group_name) VALUES (1,'admin');

INSERT INTO permissions  (id, user_email, permission_level, group_id) VALUES (1,'stc@stc.com','EDIT',1);
INSERT INTO permissions  (id, user_email, permission_level, group_id) VALUES (2,'stc2@stc.com','VIEW',1);
