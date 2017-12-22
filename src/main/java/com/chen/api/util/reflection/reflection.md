- 简介
 
 每个类对应一个Class对象，这个Class对象放在.class文件中，当我们的程序中首次主动使用某类型时，会把该类型所对应的Class对象加载进内存
 
- 获取class对象的方法

有三种方法
1. Class.forName("全限定名")；（其中，全限定名为包名+类名）。（会初始化类）
2. 类字面常量，如String.class，对应String类的Class对象。(不会初始化类)
3. 通过getClass()方法获取Class对象，如String str = "abc";str.getClass();。
