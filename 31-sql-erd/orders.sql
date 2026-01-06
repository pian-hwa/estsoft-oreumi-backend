-- SQLite
CREATE TABLE orders (
    id          BIGINT          NOT NULL,
    customer_id BIGINT          NOT NULL,
    product_id  BIGINT          NOT NULL,
    quantity    INT             NOT NULL,
    address     VARCHAR(100)    NOT NULL,
    ordered_at  DATETIME        DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT PK_ID PRIMARY KEY (id),
    CONSTRAINT PK_CUSTOMER_ID FOREIGN KEY (customer_id) REFERENCES customers(id),
    CONSTRAINT PK_PRODUCT_ID FOREIGN KEY (product_id) REFERENCES products(id)
);