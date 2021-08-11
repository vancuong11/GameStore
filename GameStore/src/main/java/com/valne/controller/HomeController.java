package com.valne.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valne.entity.Account;
import com.valne.service.AccountService;
import com.valne.service.ProductService;
import com.valne.service.SessionService;

@Controller
public class HomeController {
	@Autowired
	ProductService productService;
	@Autowired
	AccountService accountService;
	@Autowired
	SessionService session;
	@RequestMapping({"/","/home/index"})
	public String home(Model model) {
		model.addAttribute("items",productService.findAll());
		return "layout/home";
	}
	@RequestMapping("/admin/index")
	public String admin(Model model,HttpServletRequest request) {
		Account acc = accountService.findById(request.getRemoteUser());
		session.set("username", acc.getUsername());
		System.out.println(acc.getUsername());
		return "redirect:/admin/index.html";
	}
}
