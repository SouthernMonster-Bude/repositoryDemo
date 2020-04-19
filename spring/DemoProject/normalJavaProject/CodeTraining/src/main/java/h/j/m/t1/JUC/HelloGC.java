package h.j.m.t1.JUC;

public class HelloGC {
    public static int oneAddone(int x,int y){
        return x+y;
    }
    public static void main(String[] args) throws InterruptedException {
        int res = oneAddone(1,1);
        int[] a =new int[1024*1024*500];
        System.out.println("HELLO GC -> "+res);
//        while (true){}
    }
}

