DROP TABLE IF EXISTS myuser CASCADE;
DROP TABLE IF EXISTS product CASCADE;
DROP TABLE IF EXISTS category CASCADE;
DROP TABLE IF EXISTS adress CASCADE;
DROP TABLE IF EXISTS cart CASCADE;
DROP TABLE IF EXISTS cart_line CASCADE;
DROP TABLE IF EXISTS order_detail CASCADE;
DROP TABLE IF EXISTS order_item CASCADE;

create type Role as ENUM ('customer', 'manager');
create type ProductType as ENUM ('figurine', 'manga', 'anime'); 

CREATE TABLE category (
	id INT GENERATED ALWAYS AS IDENTITY,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN,
	CONSTRAINT pk_category_id PRIMARY KEY (id) 
);

CREATE TABLE myuser (
	id INT GENERATED ALWAYS AS IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled BOOLEAN,
	password VARCHAR(60),
	email VARCHAR(100),
	contact_number VARCHAR(15),
	CONSTRAINT pk_user_id PRIMARY KEY(id)
);

CREATE TABLE product (
	id INT GENERATED ALWAYS AS IDENTITY,
	ProductType,
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id INT,
	supplier_id INT,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT pk_product_id PRIMARY KEY (id),
 	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category (id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id)	
);	

-- the address table to store the user billing and shipping addresses
CREATE TABLE address (
	id INT GENERATED ALWAYS AS IDENTITY,
	user_id int,
	address_line_one VARCHAR(100),
	address_line_two VARCHAR(100),
	city VARCHAR(20),
	state VARCHAR(20),
	country VARCHAR(20),
	postal_code VARCHAR(10),
	is_billing BOOLEAN,
	is_shipping BOOLEAN,
	CONSTRAINT fk_address_user_id FOREIGN KEY (user_id ) REFERENCES user_detail (id),
	CONSTRAINT pk_address_id PRIMARY KEY (id)
);

-- the cart table to store the user cart top-level details
CREATE TABLE cart (
	id INT GENERATED ALWAYS AS IDENTITY,
	user_id int,
	grand_total DECIMAL(10,2),
	cart_lines int,
	CONSTRAINT fk_cart_user_id FOREIGN KEY (user_id) REFERENCES user_detail (id),
	CONSTRAINT pk_cart_id PRIMARY KEY (id)
);

-- the cart line table to store the cart details
CREATE TABLE cart_line (
	id INT GENERATED ALWAYS AS IDENTITY,
	cart_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	is_available boolean,
	CONSTRAINT fk_cartline_product_id FOREIGN KEY (product_id) REFERENCES product (id),
	CONSTRAINT pk_cartline_id PRIMARY KEY (id)
);

-- the order detail table to store the order
CREATE TABLE order_detail (
	id INT GENERATED ALWAYS AS IDENTITY,
	user_id int,
	order_total DECIMAL(10,2),
	order_count int,
	shipping_id int,
	billing_id int,
	order_date date,
	CONSTRAINT fk_order_detail_user_id FOREIGN KEY (user_id) REFERENCES user_detail (id),
	CONSTRAINT fk_order_detail_shipping_id FOREIGN KEY (shipping_id) REFERENCES address (id),
	CONSTRAINT fk_order_detail_billing_id FOREIGN KEY (billing_id) REFERENCES address (id),
	CONSTRAINT pk_order_detail_id PRIMARY KEY (id)
);

-- the order item table to store order items
CREATE TABLE order_item (
	id INT GENERATED ALWAYS AS IDENTITY,
	order_id int,
	total DECIMAL(10,2),
	product_id int,
	product_count int,
	buying_price DECIMAL(10,2),
	CONSTRAINT fk_order_item_product_id FOREIGN KEY (product_id) REFERENCES product (id),
	CONSTRAINT fk_order_item_order_id FOREIGN KEY (order_id) REFERENCES order_detail (id),
	CONSTRAINT pk_order_item_id PRIMARY KEY (id)
);
-- adding categories
INSERT INTO category (name, description,image_url,is_active) VALUES ('Figures', 'Add description!', 'ZoroPP.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Manga', 'Add description for Manga category!', 'SNK.png', true);
INSERT INTO category (name, description,image_url,is_active) VALUES ('Clothing', 'Add description!', 'Beanie.png', true);
-- add users 
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Alex', 'Gandarilla', 'Manager', true, 'password', 'fakemail@gmail.com', '1234567890');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Oscar', 'Williams', 'Manager', true, 'password', 'bootleg@gmail.com', '1234567890');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Arlontus', 'Halliburton', 'Customer', true, 'password', 'AH@gmail.com', '3456776543');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Mercedez', 'Hueyopa', 'Customer', true, 'password', 'merchuey@gmail.com', '123344561');
INSERT INTO user_detail 
(first_name, last_name, role, enabled, password, email, contact_number) 
VALUES ('Griffen', 'MacLeod', 'Customer', true, 'password', 'guffin@gmail.com', '123344561');

-- adding products
INSERT INTO product (type, name, brand, description, unit_price, quantity, is_active, category_id, supplier_id, purchases, views)
VALUES (figurine, 'Big pp Zoro figure', 'One Piece', 'This is one big PP energy collectible', 1000, 5, true, 3, 4, 0, 0 );

-- adding a supplier correspondece address
INSERT INTO address( user_id, address_line_one, address_line_two, city, state, country, postal_code, is_billing, is_shipping) 
VALUES (4, '102 Fake Street, Made Up Road', 'Near Los Angeles, Turtleneck', 'Shueisha', 'California', 'United States', '111111', true, false );
-- adding a cart for testing 
INSERT INTO cart (user_id, grand_total, cart_lines) VALUES (4, 0, 0);