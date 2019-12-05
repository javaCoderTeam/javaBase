package com.chen.api.util.generic.genericMethod;

/**
 * 泛型方法，是在调用方法的时候指明泛型的具体类型。
 * <p>
 * public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
 *
 * @author Chen WeiJie
 * @date 2019-12-05 15:37:05
 **/
public class GenericMethod {


    /**
     * 1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     * 2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * 3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * 4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     *
     * @param tClass
     * @param <T>
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> T getGenericMethod(Class<T> tClass) throws IllegalAccessException, InstantiationException {

        T instance = tClass.newInstance();
        return instance;
    }


    public <E> void getClassType(E e) {
        System.out.println(e);
    }


    /**
     * 泛型方法与可变参数
     *
     * @param args
     * @param <T>
     */
    public <T> void printMsg(T... args) {

        for (T arg : args) {
            System.out.println(arg.toString());
        }
    }


    //泛型类中的’？’是类型实参，而不是类型形参


    public static void main(String[] args) {

        GenericMethod genericMethod = new GenericMethod();
        //普通泛型方法
        String name = "zhang san";
        genericMethod.getClassType(name);

        // 可变参数的泛型方法
        genericMethod.printMsg("111", 222, "aaaa", "2323.4", 55.55);
    }


}
