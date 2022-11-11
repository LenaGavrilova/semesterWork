CREATE TABLE users
(
    login    varchar(20) not null primary key,
    email    varchar(50) not null,
    country  varchar(30) not null,
    password varchar(30) not null,
    isAdmin  int  default 0
);

CREATE TABLE carts(
    login varchar NULL references users(login),
    productID int NULL references products(id),
    amount int NULL
);
CREATE TABLE categories
(
    cid   serial         NOT NULL primary key,
    cname varchar(50) NOT NULL
);
CREATE TABLE products(
    id serial NOT NULL primary key ,
    name varchar(50),
    image varchar ,
    price int,
    title varchar,
    description varchar,
    cateID int references categories(cid)
    );

CREATE TABLE orders(
    oid serial NOT NULL primary key,
    login varchar NULL references users(login),
    pid int references products(id)
);
ALTER TABLE users ALTER COLUMN password TYPE varchar(50);



