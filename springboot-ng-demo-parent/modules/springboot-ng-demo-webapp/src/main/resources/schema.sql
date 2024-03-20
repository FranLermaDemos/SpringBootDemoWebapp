create sequence prices_seq start with 1 increment by 50;
create table brands (brand_id bigint not null, brand_name varchar(255), primary key (brand_id));
create table currencies (iso varchar(3) not null, symbol varchar(255), primary key (iso));
create table prices (price_list bigint GENERATED BY DEFAULT AS IDENTITY(NO CACHE) not null primary key, price numeric(38,2), brand_id bigint, end_date timestamp(6), priority bigint, product_id bigint, start_date timestamp(6), currency_iso varchar(3));
create table products (product_id bigint not null, description varchar(255), primary key (product_id));
alter table if exists prices add constraint FKtfkvp7f37rned2mybilsmh5m5 foreign key (brand_id) references brands;
alter table if exists prices add constraint FKetoplsv73br1tnbxopl0gdl8n foreign key (currency_iso) references currencies;
alter table if exists prices add constraint FKhpva2t51a39twh6gdkxdcllyf foreign key (product_id) references products;
alter table if exists products_prices add constraint FK4myrte5ihns0ib2hh8bh4kie5 foreign key (prices_price_list) references prices;
alter table if exists products_prices add constraint FK1csktp8egcba9i85uo0hpkwhq foreign key (product_entity_product_id) references products;