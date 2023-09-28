create table shopping_cart(
    id bigint not null,
    token varchar not null,
    date_creation date time not null,
    status varchar(15) not null,

    primary key (id)
)