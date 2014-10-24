CREATE TABLE ru_drivers
(
  id int Identity (1, 1) primary key NOT NULL,
  uuid int FOREIGN KEY REFERENCES ru_users(id),
  productID int FOREIGN KEY REFERENCES ru_products(id),
  priceID int FOREIGN KEY REFERENCES ru_prices(id)
)


