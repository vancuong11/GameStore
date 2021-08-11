package com.valne.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.valne.dao.Favorite_Dao;
import com.valne.dao.Product_Dao;
import com.valne.entity.Favorite;
import com.valne.entity.Product;
import com.valne.service.FavoriteService;
@Service
public class FavoriteServiceImpl implements FavoriteService{
	@Autowired
	Favorite_Dao dao;
	@Autowired
	Product_Dao proDao;
	@Override
	public Favorite create(JsonNode data) {
		ObjectMapper mapper = new ObjectMapper();
		
//		Favorite favorite = mapper.convertValue(data, Favorite.class);
//		System.out.println(favorite.getAccount());
//		dao.save(favorite);
		Favorite fa = new Favorite();
		Product pro = mapper.convertValue(data, Product.class);
//		Favorite favo = mapper.convertValue(data, Favorite.class);
//		dao.save(favo);
		System.out.println(pro.getFavorites());
		TypeReference<List<Favorite>> type = new TypeReference<List<Favorite>>() {};
		List<Favorite> list = mapper.convertValue(data.get("favorites"), type)
				.stream().peek(d-> d.setProduct(pro)).collect(Collectors.toList());
				dao.saveAllAndFlush(list);
				System.out.println(list);
		
		return fa;
	}

}
