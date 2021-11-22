create table users (
    id                      bigserial primary key,
    name                    varchar(100) not null unique,
    password                varchar(20) not null,
    login                   varchar(200) unique,
    created_at              timestamp(6) default current_timestamp
);

insert into users (name, password, login)
values
('user', '123', 'bob'),
('admin', '1234', 'john'),
('user2', '123123', 'pol'),
('admin2', '1234', 'tom'),
('user3', 'afadsf', 'sam'),
('user4', '1asdfa', 'koul'),
('user5', 'fkhjk', 'lu'),
('user6', '1sgsdfg', 'nap');
