package com.valne.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valne.SecurityConfig;
import com.valne.entity.Account;
import com.valne.service.AccountService;
import com.valne.service.SessionService;
/**
 * SecurityController 21/07/30
 * @author admin
 * @version 1.0
 */
@Controller
public class SecurityController {
//	Form login
	@Autowired
	SessionService session;
	@Autowired
	HttpServletRequest request;
	@Autowired
	AccountService accountService;
	@RequestMapping("/security/login/form")
	public String login(Model model) {
		Account stu = new Account();
		model.addAttribute("sv",stu);

		model.addAttribute("message","Vui lòng đăng nhập");
		return "security/login";
	}
//	dang nhap thanh cong
	@RequestMapping("/security/login/success")
	public String success(Model model) {
//		session.set("user", request.getRemoteUser());
		model.addAttribute("message","Đăng nhập thành công!");
//		System.out.println(request.getRemoteUser());
		return "redirect:/";
	}
//	dang nhap that bai
	@RequestMapping("/security/login/error")
	public String error(Model model) {
		
		model.addAttribute("message","Sai thông tin đăng nhập!");
		return "security/login";
	}
//	phan quyen dang nhap
	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message","Không có quyền truy xuất!");
		return "security/login";
	}
//	dang xuat thanh cong
	@RequestMapping("/security/logoff/success")
	public String logoff(Model model) {
		model.addAttribute("message","Bạn đã đăng xuất!");
		return "security/login";
	}
	
	@PostMapping("/security/register")
		public String register(@RequestParam("username") String user,@RequestParam("fullname") String fullname,
				@RequestParam("email") String email, @RequestParam("password") String pass) {
		Account acc = new Account();
		acc.setUsername(user);
		acc.setFullname(fullname);
		acc.setEmail(email);
		acc.setPassword(pass);
		acc.setImage("");
		accountService.save(acc);
			return "redirect:/security/login/form";
		}
	
//	OAUTH2
	@Autowired
	SecurityConfig userService;
	
	@RequestMapping("/oauth2/login/success")
	public String success(OAuth2AuthenticationToken oauth2) {
		userService.loginFormOAuth2(oauth2);
		return "forward:/security/login/success";
	}
}
