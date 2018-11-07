package cn.web.dao;

import cn.web.model.Product;

public class ProductDaoImpl extends BaseDao {

	public static void main(String[] args) {
		ProductDaoImpl impl = new ProductDaoImpl();
		Product product = new Product();
		product.setName("南昌电信更新1");
		product.setRemark("江西南昌");
		product.setPrice(200.5);
		product.setId(4);
		// impl.save(product);
		// impl.delete(3);
		impl.update(product);

	}

	public int save(Product product) {
		String sql = "insert into product (name , price , remark) values (? , ? ,?)";
		return super.update(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}

	public int delete(int id) {
		String sql = "delete from product where id = ?";
		return super.update(sql, new Object[] { id });
	}

	public int update(Product product) {
		String sql = "update product set name = ? , remark = ? , price = ? where id = ?";
		return super.update(sql,
				new Object[] { product.getName(), product.getRemark(), product.getPrice(), product.getId() });
	}

}
