use hrdb2019;
select database();


/*****************************************
	book_market_books : 도서 테이블
    book_market_cart : 장바구니 테이블
    book_market_member : 회원 테이블
******************************************/
create table book_market_member(
	name	varchar(10)	not null,
    phone	char(13)	not null
);
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
update book_market_cart
set quantity = 1
where bid = 'ISBN1234';
select * from book_market_books;
desc book_market_books;
drop table book_market_cart;
insert into book_market_books(bid, title, price, author, detail, uid, bdate)
values('ISBN1234', '쉽게 배우는 JSP 웹 프로그래밍', 27000, '송미영', '단계별로 쇼핑몰을 구현하여 배우는 JSP 웹 프로그래밍', 'IT전문서', '2018-10-08');
insert into book_market_books(bid, title, price, author, detail, uid, bdate)
values('ISBN1235', '안드로이드 프로그래밍', 33000, '우재남', '실습 단계별 명쾌한 멘토링', 'IT전문서', '2022-01-22');
insert into book_market_books(bid, title, price, author, detail, uid, bdate)
values('ISBN1236', '스크래치', 22000, '고광일', '컴퓨팅 사고력을 키우는 블록 코딩', '컴퓨터입문', '2019-06-10');

select bid, title, price, author, detail, uid, bdate
from book_market_books;

truncate book_market_cart;

update book_market_cart set quantity = 1 where bid = 'ISBN1234';
select * from book_market_member;
insert into book_market_member (name, phone)
values('홍길동','010-1111-1111');

use hrdb2019;
select database();

desc book_market_cart;
alter table book_market_cart
add constraint fk_book_market_cart_bid foreign key(bid)
references book_market_books(bid);

desc employee;
desc book_market_cart;
alter table book_market_cart
add column bdate date;
select * from book_market_cart;

select * from book_market_books;
select c.bid, quantity, total, bdate, b.price 
from book_market_cart c 
inner join book_market_books b
on c.bid = b.bid;
