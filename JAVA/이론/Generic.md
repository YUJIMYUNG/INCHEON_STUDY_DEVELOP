# 지네릭스

> **지네릭스란?**
> JDK5 버전 부터 추가
> 다양한 자료형을 수용하는 Object 클래스를 사용하면 타입의 안정성 X, 형변환의 번거로움의 단점이 있다.
> 그 점을 보완하기 위해 만들어짐

```java
public class Box<T> { // 지네릭 클래스
    private T item;

    public void setItem(T item){
        this.item = item;
    }

    public T getItem(){
        return item;
    }
}

// 컴파일시
public class Box {
    private Object item;

    public void setItem(Object item){
        this.item = item;
    }

    public Object getItem(){
        return item;
    }
}

// 컴파일 완료
```

- 자료형이 결정되는 시점 : 객체를 생성할 때 타입 힌트를 가지고 알 수 있다!

### 제한된 지네릭 클래스

```java
// <T extends 타입> -> T는 타입의 하위클래스
// <T extends 타입1 & 타입2> -> T는 타입1의 하위 클래스이고 타입2의 하위클래스
public class Box<T extends Fruit> {
    private Fruit item;

    public void setItem(Fruit item){
        this.item = item;
    }

    public Fruit getItem(){
        return item;
    }
}
```

### 와일드 카드

```java
<?> : <? extends Object> -> ?는 Object의 하위 클래스 -> 모든 자료형 // 메서드 호출 시에 자료형 결정
<? extends 타입> -> ?는 타입의 하위 클래스 : 타입으로 상한 제한
<? super 타입> > ?는 타입의 상위 클래스 : 타입으로 하한 제한
```

### 지네릭 메서드

- 메서드가 호출 될 때 자료형 결정
