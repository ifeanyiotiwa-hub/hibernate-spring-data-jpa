drop table if exists book;
drop table if exists author;


create table book (
                      id IDENTITY not null,
                      author varchar(255),
                      isbn varchar(255),
                      publisher varchar(255),
                      title varchar(255),
                      author_id bigint,
                      publisher_id bigint,
                      primary key (id)
);


create table author (
                        id IDENTITY not null,
                        first_name varchar(255) not null,
                        last_name varchar(255) not null,
                        primary key (id)
);