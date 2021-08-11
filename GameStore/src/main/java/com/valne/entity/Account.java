package com.valne.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "Accounts")
public class Account implements Serializable{
	@Id
	 String username;
	 String password;
	 String fullname;
	 String email;
	 String image;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;
	@JsonIgnore
	@OneToMany(mappedBy= "account",fetch = FetchType.EAGER)
	List<Authority> authorities;
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Favorite> favorities;
}
