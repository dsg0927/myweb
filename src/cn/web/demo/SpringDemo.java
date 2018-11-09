package cn.web.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.web.model.Product;

public class SpringDemo {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("cn/web/demo/spring-bean.xml");
		Product product = context.getBean("product", Product.class);
		System.out.println(product);

	}

}
