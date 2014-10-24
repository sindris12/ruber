CREATE TABLE ru_ratings
(
  id int Identity (1, 1) primary key NOT NULL,
  uuid int FOREIGN KEY REFERENCES ru_users(id),
  driverID int FOREIGN KEY REFERENCES ru_drivers(id),
  rating float,
  comment nvarchar(256)
)


