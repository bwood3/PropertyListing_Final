create schema if not exists property;

create sequence if not exists property.property_seq;

create table if not exists property.property (
    id bigint not null default nextval('property.property_seq'),
    location varchar(255),
    price double precision,
    sqr_footage double precision,
    bedrooms integer,
    bathrooms integer,
    primary key (id)
    );

-- create schema if not exists property
-- DROP SCHEMA IF EXISTS property CASCADE;