# 컬렉션 프레임워크(Collection Framework)

> 컬렉션(Colloection) : 데이터 군집
> 프레임워크(Framework): 표준화된 설계

## 컬렉션 프레임워크 핵심 인터페이스

### Collection

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
    - 주소가 연결되어있는 자료 구조
    - 순서가 변경되는 삭제, 추가도 빠르게 처리
    - ㅁArrayLIst 보다는 속도가 느리다
    - Queue의
  - Stack
    - E pop() : 마지막(가장 위쪽) 요소 꺼내기
    - E push(E e) : 끝(가장 위쪽)에 추가
  - Vector
    - ArrayList 와 구조가 비슷
    - 쓰레드 안정성

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
  - TreeSet - 정렬 기능 추가
    **Comparator 와 Comparable**
    - java.lang.Comparable : 정렬 기준, Natural Order
    ```java
    int compareTo(T o)
    // 반환값 : 음수 - 현재 요소를 앞에 배치
    //        양수 - 현재 요소를 뒤에 배치
    //         0  - 제자리
    // 현재 대상 - 비교 대상 : 오름차순 정렬
    // 비교 대상 - 현재 대상 : 내림차순 정렬
    // (현재대상 - 비교 대상) * -1 : 내림차순 정렬
    // -(현재대상 - 비교대상) : 내림차순 정렬
    ```
    - java.util.Comparator : 대안적 기준
    ```java
    int compare(T o1, T o2);

    // ex
    TreeSet<String> items = new TreeSet<>(Comparator.reverseOrder());
    ```

### Map

- 사전 자료 구조 / 조회(검색)가 목적
- 키, 값 쌍으로 구성된 데이터
- 키 : 값을 찾기위한 키워드 (중복을 허용하지 않는 자료구조 - Set(집합))
  - 중복을 허용하지 않는 이유? 값을 빠르게 찾기 위한 목적
- 값 : 값은 중복 가능(Collection…)

```java
// 추가 / 수정
V put(K key, V value);
V putIfAbsent(K key, V value); // key값이 없을때만 value값을 추가
boolean putAll(Map ...);

// 조회
V get(Object key);
V getOrDefault(Object key, V defaultValue); // key로 조회했을 때 값이 없으면 defaultValue로 기본값 대체

// 삭제
V remove(Object key);
boolean remove(Object key, Object value); // 현재 key로 조회된 value와 값을 비교하고 일치할 때 삭제

// 기타
clear(); // 전체 비우기
int size(); // 요소의 갯수
boolean contiansKey(Object key); // key값이 있는지 체크
boolean containsValue(Object value); // value 값이 있는지 체크
Set<K> keySet(); // key값 목록
Collection<V> values(); // value값의 목록
Set<Map.Entry<K,V>> entrySet(); // Key-Value 쌍 목록
```

- 구현 클래스
  - HashMap
  - TreeMap

### Iterator : List 인터페이스에 정의

- 순서의 특징을 가지고 있는 반복자
- 순방향, 역방향

### Enumeration : 반복자 패턴 구현 예

- boolean hasMoreElements()
- E nextElement()
