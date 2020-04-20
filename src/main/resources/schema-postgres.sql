DROP TABLE IF EXISTS users;
CREATE TABLE public.users(
	id SERIAL primary key,
	First_name VARCHAR (50) unique NOT NULL,
	Last_name VARCHAR(50) unique NOT NULL,
	password VARCHAR (50) NOT NULL,
	email VARCHAR (50) unique NOT NULL,
	phone VARCHAR (20),
	whatsapp VARCHAR (20),
	slack VARCHAR (50),
	active BOOL,
	PROSPECT BOOL,
	unique_code NUMERIC,
	unique_code_expiration TIMESTAMP,
	attributes VARCHAR ,
	updated_on TIMESTAMP NOT NULL,
	last_login TIMESTAMP NOT NULL,
	created_on TIMESTAMP NOT NULL
);