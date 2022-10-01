DROP TABLE IF EXISTS addresses;

CREATE TABLE addresses
(
    id         bigint       NOT NULL AUTO_INCREMENT,
    post_index varchar(255) DEFAULT NULL,
    city       varchar(255) NOT NULL,
    street     varchar(255) NOT NULL,
    house      varchar(255) NOT NULL,
    flat       varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS companies;

CREATE TABLE companies
(
    name       varchar(50) NOT NULL,
    id         bigint      NOT NULL AUTO_INCREMENT,
    type_id    int DEFAULT NULL,
    address_id bigint      NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS filials;

CREATE TABLE filials
(
    id         bigint      NOT NULL AUTO_INCREMENT,
    company_id bigint      NOT NULL,
    name       varchar(50) NOT NULL,
    address_id bigint      NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS types;

CREATE TABLE types
(
    id   bigint NOT NULL AUTO_INCREMENT,
    name varchar(50) DEFAULT NULL,
    PRIMARY KEY (id)
);

insert into addresses (post_index, city, street, house, flat)
VALUES ('195000', 'St.Petersburg', 'Nevsky pr', '1A', '-'),
       ('101000', 'Moskow', 'Arbat', '1A', '-'),
       ('185000', 'Samara', 'Aviatsionnaya st.', '1A', '-');

insert into filials(company_id, name, address_id)
VALUES (1, 'filial 1', 1),
       (1, 'filial 2', 3);
insert into types(name)
VALUES ('OOO');
insert into companies(name, type_id, address_id)
VALUES ('company one', 1, 2);

