CREATE TABLE item (
    id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    image_url VARCHAR(255),
    user_id INTEGER,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    category_id BIGINT NOT NULL,
    CONSTRAINT pk_item PRIMARY KEY (id)
);

ALTER TABLE item ADD CONSTRAINT uc_item_category UNIQUE (category_id);

ALTER TABLE item ADD CONSTRAINT FK_ITEM_ON_USER FOREIGN KEY (user_id) REFERENCES olx_user (id);

CREATE TABLE category (
    id BIGINT NOT NULL,
    name VARCHAR(255),
    CONSTRAINT pk_category PRIMARY KEY (id)
);

ALTER TABLE item ADD CONSTRAINT FK_ITEM_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);

--INSERT INTO category(id,name) values (1, "Eletronics");
--INSERT INTO category(id,name) values (2, "Furniture");
--INSERT INTO category(id,name) values (3, "Clothing");
--INSERT INTO category(id,name) values (4, "Books");
--INSERT INTO category(id,name) values (5, "Toys");
