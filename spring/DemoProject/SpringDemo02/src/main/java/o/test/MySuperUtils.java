package o.test;
import java.lang.reflect.Array;
public class MySuperUtils {
    public static <T>T[] cancat(T[] o1,T[] o2,Class<T> type) {
        T[] des = (T[]) Array.newInstance(type,o1.length+o2.length);
        System.arraycopy(o1, 0, des, 0, o1.length);
        System.arraycopy(o2, 0, des, o1.length, o2.length);
        return des;
    }
}
