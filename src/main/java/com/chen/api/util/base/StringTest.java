package com.chen.api.util.base;

/**
 * created by zhubaobao on 2017-09-11
 */
public class StringTest {

	static final int MAX = 100000;
	static final String[] arr = new String[MAX];

	public static void main(String[] args) {
		
		//1. 测试i++等，可通过反编译验证（http://blog.csdn.net/u013256816/article/details/50778902）
		// plus();
		
		//2.1 测试String类的intern()方法 （http://blog.csdn.net/seu_calvin/article/details/52291082）
		// String str2="SEUCalvin";//新加的一行代码，其余不变
		// String str1=new String("SEU")+new String("Calvin");
		// System.out.println(str1.intern() == str2);
		// System.out.println(str1=="SEUCalvin");
		// System.out.println("你好打分三大件佛奥qdqwadsdas1214@#$%^&*(".hashCode());

		//2.2 验证String类的intern方法的特点：节省空间，但是耗费时间
		// 为长度为10的Integer数组随机赋值
		// Integer[] sample = new Integer[10];
		// Random random = new Random(1000);
		// for (int i = 0; i < sample.length; i++) {
		// sample[i] = random.nextInt();
		// }
		// //记录程序开始时间
		// long t = System.currentTimeMillis();
		// //使用/不使用intern方法为10万个String赋值，值来自于Integer数组的10个数
		// for (int i = 0; i < MAX; i++) {
		// arr[i] = new String(String.valueOf(sample[i % sample.length]));
		//// arr[i] = new String(String.valueOf(sample[i %
		// sample.length])).intern();
		// }
		// System.out.println((System.currentTimeMillis() - t) + "ms");
		// System.gc();
		
		//2.3  测试intern方法的内存结构
		// String s = new String("1");
		// s.intern();
		// String s2 = "1";
		// System.out.println(s == s2);
		
		// String s3 = new String("1") + new String("1");
		// s3.intern();
		// String s4 = "11";
		// System.out.println(s3 == s4);

		//3. 测试StringBuilder和StringBuffer中的reverse方法
		// StringBuffer 和 StringBuilder
		// 类有reverse()方法，它们其实是调用的父类AbstractStringBuilder的reverse()方法
		StringBuffer sBuffer = new StringBuffer("abcD890dfg");
		System.out.println(sBuffer.reverse());

		// 4. 如何计算指定字符在字符串里出现的次数
		// 同样是使用Apache Commons Lang的StringUtils，如下：
		//int n = StringUtils.countMatches("aaaabbbb", "a");
		//Systemm.out.println(n);
		
		//判断String 创建了几个对象，用反编译验证
		String s = "a" + new String("123");// 创建了几个对象
		
	}

	static void plus() {
		int i = 0;
		int y = i++ + ++i;
		System.out.println(String.valueOf(y));
	}
}
