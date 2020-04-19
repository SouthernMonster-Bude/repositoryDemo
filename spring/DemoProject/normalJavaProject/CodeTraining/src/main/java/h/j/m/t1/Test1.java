package h.j.m.t1;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class Test1 {
   // @Test
    public void testDemo(){
        String timeSlot = "0930-1300";
        int begin = Integer.parseInt(timeSlot.split("-")[0]);
        int end = Integer.parseInt(timeSlot.split("-")[1]);
        int now = Integer.parseInt(new SimpleDateFormat("HHmm").format(new Date()));
        System.out.println("begin:"+begin+",end:"+end);
        System.out.println("now:"+now);
        System.out.println("result:"+(begin<=now && now <=end));
    }
    @Test
    public void testIntegerEqual() {
        /** -128~127 之外的数**/
        Integer tem = 129;
        Integer tem1 = 129;
        System.out.println(tem == tem1); // false
        System.out.println(tem.equals(tem1)); // true
        /** -128~127之内的数 **/
        Integer tem2 = 127;
        Integer tem3 = 127;
        System.out.println(tem2 == tem3);//true
//        Properties
//        HashSet
//        HashMap
//        Hashtable



    }

    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }
    static class A {
        protected int value;
        public A (int v) {
            setValue(v);
        }
        public void setValue(int value) {
            this.value= value;
        }
        public int getValue() {
            try {
                value ++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }
    static class B extends A {
        public B () {
            super(5);
            setValue(getValue()- 3);
        }
        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}
