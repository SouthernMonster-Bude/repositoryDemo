package o.test;

public class A1 {
            static {
                System.out.println("Class A static");
            }
            void show() {
                System.out.println("Class A");
            }
        }

class B extends A1 {
            static {
                System.out.println("Class B static");
            }
            void show() {
                System.out.println("Class B");
            }

            public static void main(String[] args) {
                A a=new A();
                a.show();
                A b=new B();
                b.show();
            }
        }