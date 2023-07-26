DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS branch_address;

CREATE TABLE client
(
    id                    serial PRIMARY KEY,
    identification_type   VARCHAR(50),
    identification_number VARCHAR(13),
    names                 VARCHAR(100),
    email                 VARCHAR(50),
    cellphone             VARCHAR(20),
    province              VARCHAR(50),
    city                  VARCHAR(100),
    address               VARCHAR(100)
);

CREATE TABLE branch_address
(
    id        serial PRIMARY KEY,
    province  varchar(255),
    city      varchar(255),
    address   varchar(255),
    client_id bigint NOT NULL,
    CONSTRAINT fk_branch_address_client_id FOREIGN KEY (client_id) REFERENCES client (id)
);