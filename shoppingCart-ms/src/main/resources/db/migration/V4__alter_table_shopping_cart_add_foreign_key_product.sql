alter table shopping_cart add column product_fk bigint not null;
alter table shopping_cart add constraint shopping_cart_product_fk foreign key (product_fk) references product (id);