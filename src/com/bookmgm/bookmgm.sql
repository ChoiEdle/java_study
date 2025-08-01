use hrdb2019;
select database();

-- 테이블 3개 생성, book_tj, book_yes24, book_aladin
-- bid:pk('b001',트리거생성), title, author, price, isbn(랜덤정수4자리생성),bdate
create table book_aladin(
	bid		char(4)		primary key,
    title	varchar(20)	not null,
    author	varchar(10)	not null,
    price	int not null,
    isbn	int,
    bdate	date
);

-- trigger 생성 : 여러개의 sql문 포함
delimiter $$

create trigger trg_book_tj_bid
before insert on book_tj	-- 테이블명
for each row
begin
declare max_code int;	-- 'M0001'

-- 현재 저장된 값 중 가장 큰 값을 가져옴
select ifnull(max(convert(right(bid,3), unsigned)),0)
into max_code
from book_tj;

-- 'M0001' 형식으로 아이디 생성, lpad(값, 크기, 채워지는 문자형식) : 1
set new.bid = concat('B', lpad(max_code + 1, 3, '0'));

end $$
delimiter ;

desc book_tj;
select * from book_aladin;
select * from book_yes24;
select * from book_tj;
insert into book_tj(title, author, price, isbn, bdate)
values('책이름','저자',2000,floor(rand()*10000),curdate());

select floor(rand()*10000) from dual;



