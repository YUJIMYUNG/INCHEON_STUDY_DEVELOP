package example.자료의저장;

import java.util.*;

public class Example1 {
    public static void main(String[] args) {
        // [생각해보기1] 이름 : 유재석, 나이 : 40, 이름 : 신동엽, 나이 : 50
        // 조건1 : 위 4가지 자료를 자바에서 저장하는 방법
        // 1. 변수 : 하나의 자료를 젖아하는 메모리 공간
        // 자료가 4개니까 변수 4개를 만든다.
        // 특징 : 자료 개수에 따라 변수가 많아지므로 관리가 힘들다.
        String name1 = "유재석";
        int age1 = 40;

        String name2 = "신동엽";
        int age2 = 50;

        // 2. 배열 : 하나의 타입의 여러 자료들을 하나의 변수에 저장하는 메모리 공간
        // 여러 자료들을 하나의 변수에 순서대로 저장
        // 특징 : 파이썬/JS 와 다르게 자바 배열은 동일한 타입만 저장할 수 있다, 각 자료들마다 속성 정보를 알 수 없다.
        String[] array = new String[4];
        int[] age = new int[4];

        array[0] = "유재석";
        array[1] = "40";
        array[3] = "신동엽";
        array[4] = "50";

        // 3. 클래스타입 : 서로 다른 타입의 여러 자료들을 하나의 자료로 저장하는 메모리 공간
        // 특징 : 자료들을 저장할때 자료들의 상징적인 이름을 붙일 수 있다.
        ValueDto valueDto = new ValueDto();
        valueDto.name1 = "유재석";
        valueDto.age1 = 40;
        valueDto.name2 = "신동엽";
        valueDto.age2 = 50;

        // 4. 컬렉션 프레임워크  : 여러 자료들을 미리 만들어진 자료구조(클래스)에 따라 자료를 저장하는 메모리 공간
        Map<String, String> valueMap = new HashMap<>();
        valueMap.put("name1", "유재석");
        valueMap.put("age1", "40");
        valueMap.put("name2", "신동엽");
        valueMap.put("age2", "50");


        // 5. List
        // 6. Object

        // [생각해보기2]
        // Remote 클래스에 Tv와 Audio 인터페이스 타입의 자료를 모두 저장할 수 있도록 코드를 수정하시오.
        // Tv와 Audio 타입을 Remote 클래스가 구현한다.
        Remo r1 = new Remote();


        // [생각해보기3]
        // ArrayList 타입의 자료와 LinkedList타입의 자료를 하나의 타입으로 저장하는 방법
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
    }

}

interface Tv{}
interface Audio{}
interface Remo extends Tv{};
class Remote implements Tv, Audio, Remo{}

class ValueDto {
    String name1;
    int age1;
    String name2;
    int age2;
}
