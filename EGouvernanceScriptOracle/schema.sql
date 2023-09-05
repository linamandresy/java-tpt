
CREATE TABLE users(
	id nvarchar2(36) PRIMARY KEY ,
	user_name nvarchar2(50) NOT null,
	user_password nchar(40) NOT NULL,
	user_type number(1)  DEFAULT 1
);

CREATE TABLE town(
	id nvarchar2(36) PRIMARY KEY ,
	town_name nvarchar2(20)
);

CREATE TABLE user_admin_town(
	id nvarchar2(36) PRIMARY KEY ,
	id_town nvarchar2(10) NOT NULL,
	id_user nvarchar2(10) NOT NULL,
	debut DATE NOT NULL ,
	fin DATE NOT NULL,
	FOREIGN KEY (id_town) REFERENCES town(id),
	FOREIGN KEY (id_user) REFERENCES users(id)
);


CREATE TABLE district(
	id nvarchar2(36) PRIMARY KEY ,
	district_name nvarchar2(20) NOT null
);

CREATE TABLE user_admin_district(
	id nvarchar2(36) PRIMARY KEY ,
	id_district nvarchar2(10) NOT NULL,
	id_user nvarchar2(10) NOT NULL,
	debut DATE NOT NULL,
	fin DATE NOT NULL,
	FOREIGN KEY (id_district) REFERENCES district(id),
	FOREIGN KEY (id_user) REFERENCES users(id)
);


CREATE TABLE citizen(
	id nvarchar2(36) PRIMARY KEY,
	first_name nvarchar2(50)  DEFAULT '',
	last_name nvarchar2(50) NOT NULL ,
	cin_number nvarchar2(15) ,
	birth_date DATE NOT NULL,
	id_father nvarchar2(10) ,
	id_mother nvarchar2(10) ,
	FOREIGN KEY (id_father) REFERENCES citizen(id),
	FOREIGN KEY (id_mother) REFERENCES citizen(id)
);

CREATE TABLE residency(
	id nvarchar2(10),
	residency_address nvarchar2(20) NOT null,
	id_district nvarchar2(10),
	FOREIGN KEY (id_district) REFERENCES district(id)
);


ALTER TABLE district ADD id_town nvarchar2(10) ;
ALTER TABLE district ADD CONSTRAINT fk_district_town FOREIGN KEY (id_town) REFERENCES town(id);

CREATE TABLE citizen_residency(
	id nvarchar2(36) PRIMARY KEY , 
	id_citizen nvarchar2(10) NOT NULL,
	id_residency nvarchar2(10) NOT NULL,
	debut DATE NOT NULL,
	fin DATE
);

ALTER TABLE USERS ADD id_citizen nvarchar2(10) NOT NULL;
ALTER TABLE USERS MODIFY id_citizen nvarchar2(36) ;
ALTER TABLE users ADD CONSTRAINT fk_users_citizen FOREIGN KEY (id_citizen) REFERENCES citizen(id);

ALTER TABLE residency ADD CONSTRAINT PK_Redie36y PRIMARY KEY (id);
ALTER TABLE CITIZEN_RESIDENCY ADD CONSTRAINT fk_residency FOREIGN KEY (id_residency) REFERENCES residency(id);
ALTER TABLE CITIZEN_RESIDENCY  ADD CONSTRAINT fk_citizen FOREIGN KEY (id_citizen) REFERENCES citizen(id);

-- signalement anaty mongodb

-- calendrier des evenements anaty mongodb

-- demande se service en ligne anaty mongodb

-- 25-aout-2023
CREATE TABLE signalement(
	id nvarchar2(36) primary key ,
	id_signalement nvarchar2(36) NOT NULL,
	pourcentage number(5,2) not null 
);

CREATE TABLE type_resource(
	id nvarchar2(36) primary key ,
	type_resource_name nvarchar2(20)  not null
);

CREATE TABLE resources(
	id nvarchar2(36) primary key ,
	resource_name nvarchar2(50) not null,
	id_type_resource nvarchar2(36) not null,
	foreign key (id_type_resource) references type_resource(id)
);


CREATE TABLE sondage_mere(
	id nvarchar2(36) primary key , 
	libelle_sondage nvarchar2(50) not null,
	description_sondage nvarchar2(255) ,
	author nvarchar2(36) not null,
	expiration_date date not null,
	foreign key (author) references users(id)
);


CREATE TABLE sondage_option(
	id nvarchar2(36) primary key , 
	libelle_option nvarchar2(50) not null,
	description_option nvarchar2(255) ,
	id_sondage_mere nvarchar2(36) not null,
	foreign key (id_sondage_mere) references sondage_mere(id)
);

create table sondage_citizen(
	id nvarchar2(36) primary key , 
	id_sondage nvarchar2(36) not null,
	id_option nvarchar2(36) not null,
	id_user nvarchar2(36) not null,
	foreign key (id_sondage) references sondage_mere(id),
	foreign key (id_option) references sondage_option(id),
	constraint uk_user_option unique(id_sondage,id_user)
);