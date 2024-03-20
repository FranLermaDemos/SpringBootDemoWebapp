INSERT INTO brands (brand_id, brand_name) VALUES
	(1, 'ACME'),
	(2, 'ACME2');

INSERT INTO currencies (iso, symbol) VALUES
	('EUR', '€'),
	('USD', '$');

INSERT INTO products (product_id, description) VALUES
	(35455, 'Producto 1');
	
	
INSERT INTO prices (price_list, brand_id, product_id, priority, start_date, end_date, price, currency_iso) VALUES
	(DEFAULT, 1, 35455, 0, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 35.5, 'EUR'),
	(DEFAULT, 1, 35455, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 25.45, 'EUR'),
	(DEFAULT, 1, 35455, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 30.5, 'EUR'),
	(DEFAULT, 1, 35455, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 38.95, 'EUR');
	