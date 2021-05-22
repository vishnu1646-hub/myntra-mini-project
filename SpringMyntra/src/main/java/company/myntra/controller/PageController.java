package company.myntra.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.apache.tiles.request.servlet.ServletUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import company.myntra.dao.MyntraplpDao;
import company.myntra.model.Myntraplp;
import company.myntra.model.Product;

@Controller
public class PageController {

	private MyntraplpDao mytraPlpDao;

	@Autowired
	@Qualifier("myntraplpDao")
	public void setMytraPlpDao(MyntraplpDao mytraPlpDao) {
		this.mytraPlpDao = mytraPlpDao;
	}

	@RequestMapping(value = "/requestplp/{category}")
	public ModelAndView displayMen(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String category) throws SerialException, SQLException, IOException {
		List<Product> products = mytraPlpDao.getProducts(category);
		System.out.println(products);
		ModelAndView modelAndView = new ModelAndView("list-page");
		modelAndView.addObject("listProducts", products);
		return modelAndView;
	}

	@RequestMapping("/detailpage/{productCode}")
	public ModelAndView productDetail(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String productCode) {
		Product product = mytraPlpDao.getProductDetails(productCode);
		ModelAndView mav = new ModelAndView("detail-page");
		mav.addObject("productDetails", product);
		return mav;

	}

	@RequestMapping("/cartpage/{productCode}")
	public ModelAndView cartDetails(HttpServletRequest request, HttpServletResponse response,
			@PathVariable String productCode) {
		Product product = mytraPlpDao.getProductDetails(productCode);
		ModelAndView mav = new ModelAndView("cart-page");
		mav.addObject("cartDetails", product);
		return mav;

	}
}
