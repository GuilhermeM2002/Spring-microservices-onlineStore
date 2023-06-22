create table shopping_cart(
    id bigint not null auto_increment,
    name varchar(40) not null,
    price numeric(6, 2) not null,
    quantity int not null,

    primary key (id)
)