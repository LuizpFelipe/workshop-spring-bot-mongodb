package com.luiz.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luiz.workshopmongo.domain.User;
import com.luiz.workshopmongo.dto.UserDTO;
import com.luiz.workshopmongo.repository.UserRepository;
import com.luiz.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fronDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		}
	
	public void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
		
	}
}

