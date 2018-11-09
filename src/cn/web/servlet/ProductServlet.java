package cn.web.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.web.model.Product;
import cn.web.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductServiceImpl productService = new ProductServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String type = request.getParameter("type");
		if (type.equals("save")) {
			Product product = new Product();
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String remark = request.getParameter("remark");
			product.setName(name);
			product.setPrice(new BigDecimal(price));
			product.setRemark(remark);
			productService.save(product);
			response.sendRedirect("/myweb/query.jsp");
		} else if (type.equals("query")) {
			String keyword = request.getParameter("keyword");
			session.setAttribute("keyword", keyword);
			List<Product> products = productService.queryByName(keyword);
			request.setAttribute("productList", products);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		} else if (type.equals("getById")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Product product = productService.getById(id);
			request.setAttribute("product", product);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");
			dispatcher.forward(request, response);
		} else if (type.equals("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Product product = new Product();
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String remark = request.getParameter("remark");
			product.setId(id);
			product.setName(name);
			product.setPrice(new BigDecimal(price));
			product.setRemark(remark);
			productService.update(product);
			String keyword = (String) session.getAttribute("keyword");
			List<Product> products = productService.queryByName(keyword);
			request.setAttribute("productList", products);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		} else if (type.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			productService.delete(id);
			String keyword = (String) session.getAttribute("keyword");
			List<Product> products = productService.queryByName(keyword);
			request.setAttribute("productList", products);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/query.jsp");
			dispatcher.forward(request, response);
		}

	}

}
