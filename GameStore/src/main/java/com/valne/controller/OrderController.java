package com.valne.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valne.dao.Account_Dao;
import com.valne.entity.Account;
import com.valne.service.AccountService;
import com.valne.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	AccountService accountService;
	@Autowired
	Account_Dao accountDao;
	@RequestMapping("/order/checkout")
	public String checkout() {
		return "order/checkOut";
	}
	
	@RequestMapping("/order/list")
	public String list(Model model, HttpServletRequest req) {
		String username = req.getRemoteUser();
		model.addAttribute("orders",orderService.findByUsername(username));
		Account acc = accountService.findById(username);
		model.addAttribute("account",acc);
		return "order/list";
	}
	
	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("order",orderService.findById(id));
		return "order/detail";
	}
	
	@RequestMapping("/order/detail")
	public String detail() {
		return "order/detail";
	}		

	@PostMapping("/order/change")
	public String register(Model model, @RequestParam("username") String user,
			@RequestParam("fullname") String fullname, @RequestParam("email") String email, @RequestParam("oldPass") String oldPass
			,@RequestParam("newPass") String newPass, @RequestParam("confirmPass") String confirmPass
			,@Validated @ModelAttribute("account") Account stu, Errors error) {
		if (error.hasErrors()) {
			model.addAttribute("message","Vui lòng sửa các lỗi sau!");
			return "order/list";
		}
		Account account = new Account();
		account.setUsername(user);
		account.setFullname(fullname);
		account.setEmail(email);
		if (!oldPass.equals(account.getPassword())) {
//			model.addAttribute("message","Mật khẩu cũ không đúng!");
			System.out.println("Mật khẩu cũ không đúng!");
			return "redirect:/order/list";
		}if(!newPass.equalsIgnoreCase(confirmPass)) {
//			model.addAttribute("message","nhập lại mật khẩu không đúng!");
			System.out.println("nhập lại mật khẩu không đúng!");
			return "redirect:/order/list";
		}
			account.setPassword(confirmPass);
		
		accountService.save(account);
		
		return "redirect:/order/list";
	}
	
	@RequestMapping("/order/delete/{id}")
	public String deleteOrder(@PathVariable("id") Integer id) {
		orderService.delete(id);
		return "redirect:/order/list";
	}
}

