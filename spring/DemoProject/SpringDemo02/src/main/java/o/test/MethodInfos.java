package o.test;

import java.util.HashMap;
import java.util.Map;

public class MethodInfos {
    public static void main(String[] args) {
        System.out.println(getCurrentMethodsInfos());
    }

    public static Map<String,String> getCurrentMethodsInfos(){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String className = stackTrace[2].getClassName();//调用的类名
        String methodName = stackTrace[2].getMethodName();//调用的方法名
        int lineNumber = stackTrace[2].getLineNumber();//调用的行数
        Map<String,String> map = new HashMap<String,String>();
        map.put("className",className);
        map.put("methodName",methodName);
        map.put("lineNumber",lineNumber+"");
        System.out.println(map);
        return  map;
    }

}
