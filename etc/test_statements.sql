INSERT INTO ru_products(description, displayName, capacity, image) VALUES ("Very large car","Hummer H3", 5, "/img/hummer.png" )
INSERT INTO ru_products(description, displayName, capacity, image) VALUES ("Cabrio", "BMW Z3", 1, "/img/bmw_z3.png" )
INSERT INTO ru_products(description, displayName, capacity, image) VALUES ("No gas", "Tesla Model S", 6, "/img/tesla.png" )
INSERT INTO ru_products(description, displayName, capacity, image) VALUES ("Supercar", "LaFerrari", 1, "/img/laferrari.png" )
INSERT INTO ru_products(description, displayName, capacity, image) VALUES ("Minivan", "Dodge Carivan", 7, "/img/carivan.png" )

INSERT INTO ru_prices(currencyCode, displayName, lowEstimate, highEstimate, surgeMiltiplier) VALUE ('USD', 'UberBlack', 10, 20, 1.25)

INSERT INTO ru_drivers(uuid, productID, priceID) VALUES (2, 1, 1)

INSERT INTO ru_ratings(uuid, driverID, rating, comment) VALUES (1, 1, 4, 'Very nice driver')
INSERT INTO ru_ratings(uuid, driverID, rating, comment) VALUES (3, 1, 2, 'Talks too much!')
INSERT INTO ru_ratings(uuid, driverID, rating, comment) VALUES (4, 1, 5, 'Excellent driver!')


UPDATE ru_products SET image='http://www.automobilesreview.com/img/hummer-h3-sensation/thumbs/hummer-h3-sensation-01.jpg' WHERE id=1;