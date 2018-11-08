package cn.web.dao;

import java.util.List;

import cn.web.model.Product;

public class ProductDaoImpl extends BaseDao<Product> {

	public static void main(String[] args) {
		ProductDaoImpl impl = new ProductDaoImpl();
//		Product product = new Product();
//		product.setName("南昌电信保存1");
//		product.setRemark("江西南昌");
//		product.setPrice(200.54);
//		product.setId(7);
		// impl.save(product);
		// impl.delete(3);
		// impl.update(product);
//		Product product2 = impl.getById(5);
//		System.out.println(product2);
		List<Product> products = impl.queryByName("保存");
		for (Product temp : products) {
			System.out.println(temp);
		}

	}

//	@Override
//	protected Product getRow(ResultSet rs) throws SQLException {
//		Product product = new Product();
//		product.setId(rs.getInt("id"));
//		product.setName(rs.getString("name"));
//		product.setPrice(rs.getDouble("price"));
//		product.setRemark(rs.getString("remark"));
//		product.setDate(rs.getDate("date"));
//		System.out.println(product);
//		return product;
//	}

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

	public Product getById(int id) {
		String sql = "select * from product where id = ?";
		List<Product> productlist = super.queryByName(Product.class, sql, new Object[] { id });
		return productlist.size() > 0 ? productlist.get(0) : null;
	}

	public List<Product> queryByName(String keyword) {
		String sql = "select * from product where name like ?";
		return super.queryByName(Product.class, sql, new Object[] { "%" + keyword + "%" });

	}

}
