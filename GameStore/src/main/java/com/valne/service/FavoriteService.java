package com.valne.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.valne.entity.Favorite;

public interface FavoriteService {

	Favorite create(JsonNode data);


}
