CREATE TABLE ru_trips
(
  id int Identity (1, 1) primary key NOT NULL,
  uuid int FOREIGN KEY REFERENCES ru_users(id),
  requestTime BIGINT,
  productID int FOREIGN KEY REFERENCES ru_products(id),
  distance float,
  startTime BIGINT,
  endTime BIGINT,
  status nvarchar(128)
)


