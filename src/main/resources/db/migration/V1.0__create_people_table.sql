create table people (
    id serial,
    full_name varchar(50) not null,
    email varchar(50) not null,
    gender char(1) not null,
    birth_date date not null,
    city varchar(50) not null,
    constraint pk_people primary key(id),
    constraint un_email unique(email)
);