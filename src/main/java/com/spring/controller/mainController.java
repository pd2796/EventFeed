package com.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.spring.dao.ProductDao;
import com.spring.model.Product;

@Controller
public class mainController {

	@Autowired
	ProductDao productDao;

	@RequestMapping("/")
	public String name(Model m) {
		List<Product> products = productDao.getProducts();
		m.addAttribute("products", products);
		return "index";

	}

	@RequestMapping("/add")
	public String addProduct(Model m) {

		m.addAttribute("title", "Add product");

		return "add_form";

	}

	@RequestMapping(value = "/handle-product", method=RequestMethod.GET)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request) {
		System.out.println(product);
		productDao.createProduct(product);
		RedirectView r = new RedirectView();
		r.setUrl(request.getContextPath() + "/");
		return r;

	}

	@RequestMapping(value = "/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int produtId, HttpServletRequest request) {
		productDao.deleteProduct(produtId);
		RedirectView r = new RedirectView();
		r.setUrl(request.getContextPath() + "/");
		return r;

	}

	@RequestMapping(value = "/update/{productId}")
	public String updateForm(@PathVariable("productId") int produtId, Model m) {
		Product product = this.productDao.getProduct(produtId);
		m.addAttribute("product", product);
		return "update-from";
	}

}
