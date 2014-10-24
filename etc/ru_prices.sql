CREATE TABLE ru_prices
(
  id int Identity (1, 1) primary key NOT NULL,
  currencyCode nvarchar(128),
  displayName nvarchar(128),
  lowEstimate float,
  highEstimate float,
  surgeMultiplier float
)