-- 작업환경 테라포밍하기 전 데이터베이스 포트 번호 sidname을 먼저 확인하고 할것
-- 노트북 포트번호 1522:orcl
-- 데스크탑 포트번호 1521:orcl

create sequence seq_board
  START WITH 0
  INCREMENT BY 1
  MAXVALUE 10000
  MINVALUE 0
  NOCYCLE;


create table tbl_board(
bno	number(10,0),
title	varchar2(2000) not null,
content varchar2(2000) not null,
writer	varchar2(50) not null,
regdate	date default sysdate,
updatedate date default sysdate
);

drop table tbl_board;

alter table tbl_board add constraint pk_board primary key(bno);


insert into tbl_board(bno, title, content, writer) values(seq_board.nextval, '테스트 제목', '테스트 내용','user00');
insert into tbl_board(bno, title, content, writer) values(seq_board.nextval, '테스트 제목1', '테스트 내용1','user01');
insert into tbl_board(bno, title, content, writer) values(seq_board.nextval, '테스트 제목2', '테스트 내용2','user02');

select * from tbl_board;

commit;

 -- 12장
select * from tbl_board order by bno asc;

-- 재귀 복사를 통해 데이터의 개수를 늘린다.
insert into tbl_board(bno, title, content, writer) (select seq_board.nextval, title, content, writer from tbl_board);
commit;


-- 274 힌트
select
/*+ INDEX_DESC(tbl_board pk_board) */
*
from tbl_board where bno > 0;

-- 275 인덱스를 사용 하기 위한 목적
alter table tbl_board add constraint pk_board primary key(bno);

