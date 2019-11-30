create table user
(
    id       serial not null
        constraint user_pk
            primary key,
    name     varchar,
    email    varchar,
    password varchar
);

create table coffee_shop
(
    id       serial not null
        constraint coffee_shop_pk
            primary key,
    name     varchar,
    location varchar
);

create table feedback
(
    id       serial not null
        constraint feedback_pk
            primary key,
    heading        varchar,
    comment        varchar,
    user_id        integer
        constraint feedback_user_id___fk
            references "user",
    coffee_shop_id integer
        constraint feedback_coffee_id___fk
            references coffee_shop
);

create table rate
(
	id             serial not null
        constraint rate_pk
            primary key,
    coffee_criteria  integer,
    food_criteria  integer,
    service_criteria  integer,
    atmosphere_criteria  integer,
    user_id        integer
        constraint rate_user_id_fk
            references "user",
    coffee_shop_id integer
        constraint rate_coffee_shop_id_fk
            references coffee_shop
);