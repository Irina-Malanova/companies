DROP DATABASE test_app;

CREATE DATABASE test_app
CHARACTER SET utf8mb4
COLLATE utf8mb4_0900_ai_ci;

--
-- Set default database
--
USE test_app;
DROP TABLE IF EXISTS addresses;
--
-- Create table `addresses`
--
CREATE TABLE addresses (
                           id bigint NOT NULL AUTO_INCREMENT,
                           post_index varchar(255) DEFAULT NULL,
                           city varchar(255) NOT NULL,
                           street varchar(255) NOT NULL,
                           house varchar(255) NOT NULL,
                           flat varchar(255) DEFAULT NULL,
                           PRIMARY KEY (id)
)
    ENGINE = INNODB,
AUTO_INCREMENT = 7,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_0900_ai_ci;
grant alter, create, create view, delete, drop, index, insert, references, select, show view, trigger, update, grant option on table addresses to admin;

--
-- Drop table `companies`
--
DROP TABLE IF EXISTS companies;

--
-- Create table `companies`
--
CREATE TABLE companies (
                           name varchar(50) NOT NULL,
                           id bigint NOT NULL AUTO_INCREMENT,
                           type_id int DEFAULT NULL,
                           address_id bigint NOT NULL,
                           PRIMARY KEY (id)
)
    ENGINE = INNODB,
AUTO_INCREMENT = 2,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_0900_ai_ci;

grant alter, create, create view, delete, drop, index, insert, references, select, show view, trigger, update, grant option on table companies to admin;

-- Drop table `filials`
--
DROP TABLE IF EXISTS filials;

--
-- Create table `filials`
--
CREATE TABLE filials (
                         id bigint NOT NULL AUTO_INCREMENT,
                         company_id bigint NOT NULL,
                         name varchar(50) NOT NULL,
                         address_id bigint NOT NULL,
                         PRIMARY KEY (id)
)
    ENGINE = INNODB,
AUTO_INCREMENT = 3,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_0900_ai_ci;

grant alter, create, create view, delete, drop, index, insert, references, select, show view, trigger, update, grant option on table filials to admin;


-- Drop table `types`
--
DROP TABLE IF EXISTS types;

-- Create table `types`
--
CREATE TABLE types (
                       id bigint NOT NULL AUTO_INCREMENT,
                       name varchar(50) NOT NULL,
                       PRIMARY KEY (id)
)
    ENGINE = INNODB,
AUTO_INCREMENT = 2,
CHARACTER SET utf8mb4,
COLLATE utf8mb4_0900_ai_ci;
grant alter, create, create view, delete, drop, index, insert, references, select, show view, trigger, update, grant option on table types to admin;

