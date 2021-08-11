package com.valne.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="Categories")
public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	 Integer id;
	 String name;
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	List<Product> products;
}
