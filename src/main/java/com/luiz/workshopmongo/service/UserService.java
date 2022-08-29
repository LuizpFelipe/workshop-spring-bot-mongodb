package com.luiz.workshopmongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.workshopmongo.domain.User;
import com.luiz.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
}
