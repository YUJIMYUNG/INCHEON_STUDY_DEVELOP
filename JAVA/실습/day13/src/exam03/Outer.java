package exam03;

public class Outer {
    void method(){
        class Inner {
            void innerMethod() {
                System.out.println("메서드!");
            }
        }

        Inner in = new Inner();
        in.innerMethod();
    }
}
