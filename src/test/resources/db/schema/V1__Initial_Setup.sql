create EXTENSION IF NOT EXISTS "uuid-ossp";


create table address_book(

   	id uuid NOT NULL DEFAULT uuid_generate_v4() ,
    
    title varchar  NOT NULL , 
    
    first_name varchar NOT NULL, 
    
    last_name varchar NOT NULL,
    
    mobile varchar NOT NULL,
    
    home_phone varchar,
    
    city varchar NOT NULL,
    
    post_code varchar,
    
    CONSTRAINT contact_pkey PRIMARY KEY (id)
	
);



CREATE UNIQUE INDEX contact_idx ON address_book USING btree (id);
