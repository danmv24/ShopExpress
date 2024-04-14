CREATE TABLE "products" (
    id BIGSERIAL PRIMARY KEY,
    product_name VARCHAR(200) NOT NULL,
    category_id BIGINT NOT NULL,
    weight DECIMAL(10, 3),
    description TEXT,
    price DECIMAL(10, 2),
    FOREIGN KEY (category_id) REFERENCES categories (id)
);