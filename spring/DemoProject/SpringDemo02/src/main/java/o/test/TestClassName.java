package o.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class TestClassName {
    public static void main(String[] args) {
        new B2();
    }
}
class A {
    A(){
        Class clazz = this.getClass();
        System.out.println(clazz.getName());
    }
}
class B extends A{}

class A2<T> {
    A2(){
        Class clazz = this.getClass();
        //获得泛型的类型
        Type genericSuperClass = clazz.getGenericSuperclass();
        //genericSuperClass是ParameterizedTypeImpl 向上造型
        ParameterizedType superClass = (ParameterizedType) genericSuperClass;
        //转换成ParameterizedType,获取所有泛型参数的Class对象
        Type[] actualTypeArgments = superClass.getActualTypeArguments();
        System.out.println(clazz.getName());
        System.out.println(genericSuperClass);
        System.out.println(genericSuperClass.getClass());
        System.out.println(superClass);
        for(Object obj : actualTypeArgments){
            System.out.println(obj);
        }
    }
}
class B2 extends A2<Integer>{}
