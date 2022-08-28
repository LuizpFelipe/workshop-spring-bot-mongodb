package com.luiz.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.luiz.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET) //@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User Maria = new User("1", "Silva", "Gmail.com");
		User Jorge = new User("2", "Malvo", "Gmail.com");	
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(Maria, Jorge));
		return ResponseEntity.ok().body(list);
	}

}
