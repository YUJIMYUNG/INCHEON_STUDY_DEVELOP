package example.컬렉션프레임워크;

import org.antlr.v4.runtime.tree.Tree;

import java.util.*;

public class Example {
    public static void main(String[] args) {
        // 컬렉션 프레임워크 : 자료들을 저장한은 방법(자료 구조), 자료구조 기반으로 여러가지 인터페이스/클래스
        // 인터페이스 : 추상메서드를 선언하고 각 클래스들이 구현하여 사용한다.
        // 1. List 인터페이스 : 요소를 순서대로 저장하며, 중복 허용
            //  List 구현 클래스 : ArrayList, Vector, LinkedList 등
        List<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        // 차이점 : List타입으로 선언된 변수는 ArrayList, Vector, LinkedList 를 모두 저장할 수 있다.
        // ArrayList 타입으로 선언된 변수는 ArrayList로만 저장할 수 있다.
        // 즉 인터페이스 타입의 변수는 해당 인터페이스를 구현한 모든 클래스의 객체들을 저장할 수 있다.
        // List<> list3 = new List<>(); -> 오류 : 인터페이스는 객체를 생성할 수 없다.(인터페이스는 생성자가 없으므로)
        List<String> list3 = new ArrayList<>(); // 배열 기반(인덱스), 검색/읽기가 많을 떄 사용
        List<String> list4 = new Vector<>();    // 배열 기반(인덱스), 동기화(대기상태), (웨이팅)
        List<String> list5 = new LinkedList<>();// 연결 리스트 기반(두 객체를 참조해서 연결함)

        // 2. Set 인터페이스 : 요소의 저장 순서를 보장하지 않고, 중복을 허용하지 않는다.
            // 1). Set 구현 클래스 : TreeSet, LinkedHashSet, LinkedSet 등
        Set<String> set1 = new HashSet<>();         // 중복이 없는 자료 구조를 사용할 때,빠른 검색
        Set<String> set2 = new LinkedHashSet<>();   // 저장된 순서를 유지하고, 중복이 없는 구조
        Set<String> set3 = new TreeSet<>();         // 자동 정렬을 필요로 할 때 사용, 중복이 없는 구조

        // 3. Map 인터페이스 : key, value 를 쌍으로 저장하고, key는 중복 불가, value는 중복 허용
            // 1) Map 구현 클래스 : HashMap, LinkedHashMap, TreeMap 등
        Map<String, Integer> map1 = new HashMap<>();        // key의 순서를 유지하지 않는다. 빠른검색 가능
        Map<String, Integer> map2 = new LinkedHashMap<>();  // 입력된 key순서를 유지한다
        Map<String, Integer> map3 = new TreeMap<>();        // 자동정렬, key의 순서를 유지하지 않는다.

        // 4. < > : 제네릭 타입, 컬렉션 프레임워크에서 주로 사용된다. JPA와 같이 여러 라이브러리에서도 사용된다.
            // 제네릭 타입이란? 클래스를 만들때 멤버변수/메소드 타입을 정의하지 않고 인스턴스를 생성할 때 타입을 정의한다.
            // 1) 제네릭 타입이 없을 때 고려할 사항 : 형변환이 필요하다, 타입 안정성 부족
        Box box = new Box();
        box.value = "유재석";
        Box box2 = new Box();
        box2.value = 40;

        String str1 = (String)box.value;
        int int2 = (Integer)box2.value;

            // 2) 제네릭 타입이 있을 때
        Container<String> cont1 = new Container<>();
        cont1.value = "유재석";
        Container<Integer> cont2 = new Container<>();
        cont2.value = 40;

    }
}

class Container<T> {
    T value;
}

class Box {
    Object value;
}