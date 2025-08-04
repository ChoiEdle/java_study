use hrdb2019;
select database();


/*****************************************
	book_market_books : 도서 테이블
    book_market_cart : 장바구니 테이블
    book_market_member : 회원 테이블
******************************************/

create table book_market_books(
	bid		char(8)		primary key,
    title	varchar(20)	not null,
    price	int			not null,
    author	varchar(10)	not null,
    detail	longtext,
    uid		varchar(10)	not null,
    bdate	date
);
create table book_market_cart(
	bid			char(8)		primary key,
    quantity	int		not null,
    total		int		not null
);
select * from book_market_cart;
select * from book_market_books;
desc book_market_books;
drop table book_market_cart;
