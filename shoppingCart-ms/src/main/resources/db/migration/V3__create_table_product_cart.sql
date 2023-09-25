create table product(
    id bigint not null auto_increment,
    name varchar(100) not null,
    price numeric(10,2) not null,
    quantity numeric(10) not null,

    primary key(id)
);