CREATE TABLE "orders" (
    order_id BIGSERIAL PRIMARY KEY,
    order_date TIMESTAMP,
    total_price DECIMAL(10, 2)
);