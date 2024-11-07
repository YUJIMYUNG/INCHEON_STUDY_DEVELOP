package exam01;

@MyAnno(max=10, numbers = {10, 20, 30, 40})// Person 클래스의 정의 일부
public class Person {
    @MyAnno(value = "값2", max=15, numbers = {10, 20})
    private String name;

    @MyAnno(value = "값3")
    public void method(@MyAnno(value = "값4")String title){

    }
}
