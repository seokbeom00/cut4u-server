create database cut4u;

create table user
(
    id bigint primary key auto_increment,
    email varchar(30),
    password varchar(20) not null,
    name varchar(10) not null,
    profileimg varchar(200)
);

select * from user;

truncate user;

drop table user;