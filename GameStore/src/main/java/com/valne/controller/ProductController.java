package com.valne.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.valne.entity.Product;
import com.valne.service.ProductService;

/**
 * class ProductController 2021/07/29
 * @author admin
 * @version 1.0
 */
@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@RequestMapping("/products/list")
	public String list(Model model, @RequestParam("cid") Optional<Integer> cid) {
		if (cid.isPresent()) {
			List<Product> list = productService.findByCategoryId(cid.get());
			model.addAttribute("items",list);
		}else {
			List<Product> list = productService.findAll();
			model.addAttribute("items",list);
		}
		return "product/list";
	}
	
	@RequestMapping("/products/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Product item = productService.findById(id);
		model.addAttribute("item",item);
		return "product/detail";
	}
	
	@RequestMapping("/products/quickView/{id}")
	public String quickView(Model model, @PathVariable("id") Integer id) {
		Product item = productService.findById(id);
		model.addAttribute("item",item);
		return "product/quickView";
	}

}
