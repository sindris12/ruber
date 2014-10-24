CREATE TABLE ru_products
(
  id int Identity (1, 1) primary key NOT NULL,
  description nvarchar(258),
  displayName nvarchar(128),
  capacity int,
  image nvarchar(128)

)