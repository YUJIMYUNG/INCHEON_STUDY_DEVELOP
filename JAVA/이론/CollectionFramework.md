# 컬렉션 프레임워크(Collection Framework)

> 컬렉션(Colloection) : 데이터 군집
> 프레임워크(Framework): 표준화된 설계

## 컬렉션 프레임워크 핵심 인터페이스

### Colloection

1. List

- 순차 자료 구조
- 순서가 있는 자료 구조 - 예) 배열
  ```java
  // 추가
  void add(int index, E e)
  boolean add(E e)
  boolean addAll(int index, Collecntion...)
  boolean addAll(Collecntion...)

  // 조회
  E get(int index)

  // 수정
  boolean set(int index, E e)

  // 삭제
  E remove(int index)
  boolean remove(Object o)

  // 기타
  int indexOf(Object o)  // o요소의 위치 번호(왼쪽 -> 오른쪽), 없으면 -1
  int lastIndexOf(Object o) // o요소의 위치 번호(오른쪽 -> 왼쪽), 없으면 -1
  int size() // 요소의 갯수
  ```
- 구현 클래스
  - ArrayList
    - 1차원 배열(벡터)을 구현한 클래스
    - 조회 속도는 빠르지만 순서가 변경되는 사항(추가, 수정, 삭제)이 많으면 성증 저하(매번 새로운 배열이 만들어지므로)
    - 스택 구조에 가장 적합
  - LinkedList
  - Stack
    - E pop() : 마지막(가장 위쪽) 요소 꺼내기
    - E push(E e) : 끝(가장 위쪽)에 추가
  - Vector

1. Set

- 집합 자료 구조
- 중복을 허용하지 않는 자료 구조 / 기준 = equals and hashCode 메서드
- 순서는 고려하지 않는다.(순서 결정 불가)
  ```java
  // 추가
  boolean add(E e)
  boolean addAll(Collection ...)

  // 제거
  boolean remove(Object o)
  boolean removeAll(Collection ...)

  // 기타
  int size() // 요소 갯수
  ```
- 구현 클래스
  - HashSet
  - TreeSet

### Map

- 사전 자료 구조 / 조회(검색)가 목적
- 키, 값 쌍으로 구성된 데이터
- 키 : 값을 찾기위한 키워드 (중복을 허용하지 않는 자료구조 - Set(집합))
  - 중복을 허용하지 않는 이유? 값을 빠르게 찾기 위한 목적
- 값 : 값은 중복 가능(Collection…)
