package cn.web.service;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.web.dao.ProductDaoImpl;
import cn.web.model.Product;

public class ProductServiceImpl {

	ProductDaoImpl productDao = null;

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
		ProductServiceImpl serviceImpl = context.getBean("ps", ProductServiceImpl.class);
		List<Product> products = serviceImpl.queryByName("");
		for (Product temp : products) {
			System.out.println(temp);
		}

	}

	public void setProductDao(ProductDaoImpl productDao) {
		this.productDao = productDao;
	}

	public int save(Product product) {
		return productDao.save(product);
	}

	public int delete(int id) {
		return productDao.delete(id);
	}

	public int update(Product product) {
		return productDao.update(product);
	}

	public Product getById(int id) {
		return productDao.getById(id);
	}

	public List<Product> queryByName(String keyword) {
		return productDao.queryByName(keyword);

	}

}
