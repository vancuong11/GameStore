package com.valne.controller;

import org.springframework.stereotype.Controller;
/**
 * ShoppingCartController 21/07/29
 * @author admin
 * @version 1.0
 */
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class ShoppingCartController {
	@RequestMapping("/cart/view")
	public String cart() {
		return "cart/cart";
	}
}
