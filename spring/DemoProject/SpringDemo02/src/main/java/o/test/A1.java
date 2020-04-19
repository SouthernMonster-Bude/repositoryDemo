package o.test;

public class A1 {
            static {
                System.out.println("Class A static");
            }
            void show() {
                System.out.println("Class A");
            }
        }

class B1 extends A1 {
            static {
                System.out.println("Class B static");
            }
            void show() {
                System.out.println("Class B");
            }

            public static void main(String[] args) {
                A1 a=new A1();
                a.show();
                A1 b=new B1();
                b.show();
            }
        }