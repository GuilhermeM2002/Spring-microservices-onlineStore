create table product(
    id bigint not null auto_increment,
    quantity_fk bigint not null,
    name varchar(100) not null,
    price numeric(10,2) not null,

    primary key(id)
);