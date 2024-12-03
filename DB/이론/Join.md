# JOIN

### 테이블 생성, 레코드값 삽입

```sql
create table table1(
	num int,
	primary key(num)
);

create table table2(
	no int,
	primary key(no),
	num int,
	foreign key(num) references table1(num)
)

-- 레코드(샘플) 
-- insert into 테이블명 values (값1), (값2), (값3)
insert into table1 values(1), (2), (3), (4), (5);
insert into table2 values(1,2), (2,2), (3,1), (4,1), (5,2);
```

### 교집합 - JOIN

```sql
--  교집합 : join : 서로 다른 테이블들간의 교집합(동일한 필드값) 찾기
-- 1. 하나의 테이블 조회
**select** * **from** ***table1***;

-- 2. 두개 이상의 테이블을 조회
-- select * from 테이블명1, 테이블명2
**select** * **from** ***table1***, ***table2***; -- 총 25개 행 조회됨

```

- 두개 이상의 테이블을 조회시 두 테이블간 동일한데이터가 일치했을 때 조회
    - 교집합 찾을때 주로 pk필드와 fk필드를 조건으로 설정하면 된다.
    - 교집합 필요한 이유 : pk필드값을 이용한 fk필드 조회, fk필드값을 이용한 pk필드 조회
    
1.  where 조건절 이용한 교집합 하기

```sql
**select** * **from** ***table1***, ***table2*** **where** ***table1***.num = ***table2***.num; -- 총 5개 행 조회
```

1.  inner join → 사용 권장
    - `테이블명 A inner join 테이블명B on 테이븖.pk필드명 = 테이블명B.fk필드명`
    - 장점 : 여러 절과 같이 사용시 가독성이 좋다.

```sql
**select** **from** ***table1***, ***table2*** **inner** **join** ***table2*** **on** ***table1***.num = ***table2***.num; -- 총 5개 행 조회
```


1. join on
    - `테이블명 A join 테이블명B on 테이븖.pk필드명 = 테이블명B.fk필드명`

```sql
**select** * **from** ***table1***, ***table2*** **join** ***table2*** **on** ***table1***.num = ***table2***.num; -- 총 5개 행 조회
```


1. natural join
    - `테이블명A natural join 테이블명B`
    - 교집합 조건 없이 자동으로교집합 조건을 표현하는 구문
    - 전제조건 : 교집합할 필드명이 동일해야한다. 즉, pk필드명과 fk필드명이 동일해야만 조회가 가능하다.

```sql
**select** * **from** ***table1*** **natural** **join** ***table2***;
```


1. using
    - `테이블명A join 테이블명B using( 조인필드명 )`
    - 교집합 할 필드를 using()대입해서 자동 교집합
    - 전제조건 : pk필드명과 fk필드명이 동일해야만 조회가 가능하다.

```sql
**select** * **from** ***table1*** **join** ***table2*** **using**(***num***);
```

![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/44583fe6-6727-4cd4-a1a5-cae7ec7c61f5/39451d40-a545-4695-ab63-ff66345e690a/image.png)

1. outer join
    - `테이블명A left outer join 테이블명B on 집합조건`
    - 왼쪽테이블에 있는 모든 레코드를 포함하고 오른쪽 테이블에 교집합 되는 레코드를 조회
    - 데이터가 없으면 null
    - outer 을 생략해서 사용하기도 한다.
    
    ```sql
    select * from table1 left outer join table2 on table1.num = table2.num;
    ```
    


- `테이블명A right outer join 테이블명B on 집합조건`
- 오른쪽테이블에 있는 모든 레코드를 포함하고 왼쪽 테이블에 교집합되는레코드를 조회

```sql
select * from table1 right outer join table2 on table1.num = table2.num;
```



- full outer join : mysql은 지원하지 않음
- 대신에 union(합집합) 사용
- left join과 right join 두 결과의 중복된 행을 제거하고 결합

```sql
select * from table1 left join table2 on talble1.num = table2.num union
select * from table1 right join table2 on table1.num = table2.num;
```

- 차집합 표현
- A테이블에서 B테이블의 레코드를 제외
    - `테이블명A left outer join 테이블명B on 집합조건 where 테이블명B.fk필드명 is null;`
- B테이블에서 A테이블의 레코드를 제외
    - `테이블명A right outer join 테이블명B on 집합조건 where 테이블명A.pk필드명 is null;`

```sql
select * from table1 left outer join table2 on table1.num = table2.num;
select table1.* from  left outer join table2 on table1.num = table2.num where table2.num is null;
```

