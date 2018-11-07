package cn.web.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import cn.web.model.Product;

public class RefDemo {
	public static void main(String[] args) throws Exception {
		Product product = new Product();
		product.setName("我的手机");
		System.out.println(product.getName());

		Class clazz = Product.class;
//		Class clazz1 = Class.forName("cn.web.model.Product");
//		Class clazz2 = product.getClass();
//		if (clazz == clazz1 && clazz1 == clazz2) {
//			System.out.println("abc");
//		}
//		Method[] methods = clazz.getMethods();
//		for (Method med : methods) {
//			System.out.println(med);
//		}
//		System.out.println("next");
//		Method[] declaredMethods = clazz.getDeclaredMethods();
//		for (Method med2 : declaredMethods) {
//			System.out.println(med2);
//		}
		Product product1 = (Product) clazz.newInstance();
		Method setName = clazz.getDeclaredMethod("setName", String.class);
		Method getName = clazz.getDeclaredMethod("getName");
		setName.invoke(product1, "反射方法赋值");
		System.out.println(getName.invoke(product1));

//		Field[] fields = clazz.getFields();
//		for (Field temp : fields) {
//			System.out.println(temp);
//		}
//		Field[] fields2 = clazz.getDeclaredFields();
//		for (Field temp2 : fields2) {
//			System.out.println(temp2);
//		}
		Object product2 = clazz.newInstance();
		Field field = clazz.getDeclaredField("name");
		field.setAccessible(true);
		field.set(product2, "通过反射属性直接赋值");
		System.out.println(field.get(product2));

	}

}
