create table shopping_cart(
    id bigint not null,
    date_creation date time not null,
    status varchar(20) not null,

    primary key (id)
)