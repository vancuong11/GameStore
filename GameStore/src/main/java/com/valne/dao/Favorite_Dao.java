package com.valne.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valne.entity.Favorite;

public interface Favorite_Dao extends JpaRepository<Favorite, Integer> {

}
