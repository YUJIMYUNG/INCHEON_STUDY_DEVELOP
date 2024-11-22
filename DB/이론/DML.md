## DML

> DML 이란 ?  데이터 조작어
> 

### select

- 레코드 조회 SQL
- `select * from 테이블명;`
    - 지정한 테이블의 모든(*) 레코드 조회/검색
- `select 필드명1, 필드명2 from 테이블명;`
    - 지정한 테이블의 특정 필드의 레코드 조회/검색

```sql
select * from *board*;	-- 지정한 테이블의 모든(*) 필드의 레코드 조회
select *bcontent*, *bwriter* from *board*;	-- 지정한 테이블의 bcontent와 bwriter 필드의 레코드를 모두 조회
```

### insert

- 레코드 삽입/ 추가 SQL
- `insert into 테이블명 values(값1, 값2, 값3)`
    - 지정한 테이블에 컬럼 순서대로 삽입
- `insert into 테이블명(필드명1, 필드명2, 필드명3) values(값1, 값2, 값3);`
    - 원하는 필드 갯수 만큼 지정한 테이블에 각 필드에 각 값을 삽입

```sql
-- board 테이블에 필드선언 순서대로 bno=1, bcontent=안녕하세요, bwriter=유재석, bpwd=1234 를 삽입
insert into *board* values(1, '안녕하세요', '유재석', 1234); 

insert into *board* values('그래 안녕', '강호동', 4567); -- 오류 발생 : 필드의 갯수와 데이터의 갯수가 일치하지 않기때문에
insert into board(*bcontent*, *bwriter*, *bpwd*) values('그래 안녕', '강호동', 4567); -- 특정 필드의 값만 삽입시에는 필드명을 명시해야한다.
```

### update

- 특정 레코드의 필드값 수정 SQL
- `update 테이블명 set 수정할 필드명 = 새로운값 where 조건필드 = 조건값`
- 레코드 조건이 없으면 전체 수정

```sql
update *board* set *bwriter* = '신동엽' where *bno* = 3;

-- 레코드 조건이 없으면 전체 수정
update *board* set *bwriter* = '신동엽';
```

### delete

- 특정 레코드 삭제 SQL (삭제)
- 지정한 테이블의 전체 레코드 삭제
    - `delete from 테이블명`;
- 지정한 테이블의 특정 조건을 충족하는 레코드만 삭제
    - `delete from 테이블명 where 조건필드 = 조건값`