package com.valne.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.valne.entity.Favorite;
import com.valne.service.FavoriteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/favorites")
public class FavoriteRestController {
	@Autowired
	FavoriteService favoriteService;
	
	@PostMapping()
	public Favorite create(@RequestBody JsonNode data) {
		return favoriteService.create(data);
	}
}
