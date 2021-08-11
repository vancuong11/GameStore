package com.valne.controller;

import java.util.Optional;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valne.dao.Favorite_Dao;
import com.valne.dao.Product_Dao;
import com.valne.entity.Account;
import com.valne.entity.Favorite;
import com.valne.entity.Product;
import com.valne.service.AccountService;
import com.valne.service.FavoriteService;
import com.valne.service.ProductService;
import com.valne.service.SessionService;

/**
 * FavoriteController 21/07/29
 * @author admin
 * @version 1.0
 */
@Controller
public class FavoriteController {
	@Autowired
	Favorite_Dao dao;
	@Autowired
	ProductService productService;
	@Autowired
	AccountService accountService;
	@Autowired
	SessionService session;
	@Autowired
	HttpServletRequest request;
	@RequestMapping("/favorites")
	public String cart() {
		return "order/wishlist";
	}
	@RequestMapping("/favorites/like/{id}")
	public String like(Model model,@PathVariable("id") Integer id) {
		Product item = productService.findById(id);
		Account acc = accountService.findById(request.getUserPrincipal().getName());
		Favorite favo = new Favorite();
		favo.setProduct(item);
		favo.setAccount(acc);
		dao.save(favo);

		return "redirect:/home/index";
	}
	
}
