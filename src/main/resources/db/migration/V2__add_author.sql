drop table if exists author;

create table author (
                        id bigint not null,
                        first_name varchar(255) not null,
                        last_name varchar(255) not null,
                        primary key (id)
) engine=InnoDB;

insert into author values (1, 'Ifeanyichukwu', 'otiwa');