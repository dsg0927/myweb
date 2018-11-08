package cn.web.service;

import java.util.List;

import cn.web.dao.ProductDaoImpl;
import cn.web.model.Product;

public class ProductServiceImpl {

	ProductDaoImpl productDao = new ProductDaoImpl();

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
