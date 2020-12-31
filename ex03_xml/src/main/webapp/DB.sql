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



-- 377 댓글 처리를 위한 영속 영역 쿼리 작성
create table tbl_reply(
rno number(10, 0),
bno number(10, 0) not null,
reply varchar2(1000) not null,
replyer varchar2(50) not null,
replyDate date default sysdate,
updateDate date default sysdate
);

create sequence seq_reply;

alter table tbl_reply add constraint pk_reply primary key(rno);

alter table tbl_reply add constraint fk_reply_board
foreign key(bno) references tbl_board(bno);

-- 380
select * from tbl_board where rownum <10 order by bno desc;

-- 383(결과 확인 - JUNIT 테스트 후 쿼리 실행 할것)
select * from tbl_reply order by rno desc;

-- 471 트랜잭션 예제를 위한 실습 쿼리
create table tbl_sample1(col1 varchar2(500));
create table tbl_sample2(col2 varchar2(50));

-- 475 474페이지의 junit 테스트 결과를 확인 할 수 있다.
select * from tbl_sample1;
select * from tbl_sample2;

-- 477 트랜잭션 어노테이션이 적용으로 인해 테이블내부 데이터 삭제
delete tbl_sample1;
delete tbl_sample2;
commit;

-- 480
alter table tbl_board add (replycnt number default 0);

-- 댓글의 갯수를 보기 위한 쿼리
update tbl_board set replycnt = (
                                select count(rno) 
                                from tbl_reply
                                where tbl_reply.bno = tbl_board.bno);
-- commit을 때려야 결과를 확인 할 수 있습니다.                                
                                commit;
                                
-- chap 25
-- 첨부파일을 담당하는 테이블을 생성(550)
create table tbl_attach(
    uuid        varchar2(100) not null,
    uploadPath  varchar2(200) not null,
    fileName    varchar2(100) not null,
    fileType    char(1) default 'I',
    bno         number(10,0)
);

alter table tbl_attach add constraint pk_attach primary key(uuid);

alter table tbl_attach add constraint fk_board_attach foreign key(bno) references tbl_board(bno);

-- chap 35 Remember-Me 테이블
create table persistent_logins(
username    varchar(64) not null,
series      varchar(64) primary key,
token       varchar(64) not null,
last_used   timestamp not null);