
DROP TABLE IF EXISTS item , permissions , permission_groups , files;
create table item(
  id  SERIAL PRIMARY KEY  not null,
  type varchar(100) ,
  name varchar(100) ,
  permissions_id int,
  permission_group_id int

);

create table permissions(
  id SERIAL PRIMARY KEY  not null,
  user_email varchar(100),
  permission_level varchar(100),
  group_id int

);

create table permission_groups(
  id  SERIAL PRIMARY KEY   not null,
  group_name varchar(100)

);

create table files(
  id SERIAL PRIMARY KEY  not null,
  file bytea,
  item_id int

);