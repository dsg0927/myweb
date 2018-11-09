package cn.web.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.web.model.Product;

public class ProductDaoImpl {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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
		return jdbcTemplate.update(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}

	public int delete(int id) {
		String sql = "delete from product where id = ?";
		return jdbcTemplate.update(sql, id);
	}

	public int update(Product product) {
		String sql = "update product set name = ? , remark = ? , price = ? where id = ?";
		return jdbcTemplate.update(sql,
				new Object[] { product.getName(), product.getRemark(), product.getPrice(), product.getId() });
	}

	public Product getById(int id) {
		String sql = "select * from product where id = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), id);
	}

	public List<Product> queryByName(String keyword) {
		String sql = "select * from product where name like ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), "%" + keyword + "%");

	}

}
