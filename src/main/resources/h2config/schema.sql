-- schema.sql
CREATE TABLE brand
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE prices
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand_id   BIGINT,
    start_date VARCHAR(25) NOT NULL,
    end_date   VARCHAR(25) NOT NULL,
    price_list BIGINT,
    product_id BIGINT,
    priority   BIGINT,
    price      FLOAT,
    currency   VARCHAR(10) NOT NULL,
    FOREIGN KEY (brand_id) REFERENCES brand (id)
);