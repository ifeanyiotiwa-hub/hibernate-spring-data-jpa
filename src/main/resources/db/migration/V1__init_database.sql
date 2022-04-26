drop table if exists book;
drop table if exists hibernate_sequence;
drop table if exists author;

create table book (
                      id bigint not null,
                      author varchar(255),
                      isbn varchar(255),
                      publisher varchar(255),
                      title varchar(255),
                      author_id bigint,
                      primary key (id)
) engine=InnoDB;

create table hibernate_sequence (
    next_val bigint
) engine=InnoDB;

insert into hibernate_sequence values ( 1 );