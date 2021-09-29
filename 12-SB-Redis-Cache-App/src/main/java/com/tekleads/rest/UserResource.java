package com.tekleads.rest;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tekleads.model.User;
import com.tekleads.repository.UserRepository;

@RestController
@RequestMapping("/rest/user")
public class UserResource {

	private UserRepository userRepository;

	public UserResource(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@PostMapping(value = "/add", consumes = "application/json")
	public User add(@RequestBody User user) {
		userRepository.save(user);
		return userRepository.findById(user.getId());
	}

	@PutMapping("/update/{id}/{name}")
	public User update(@PathVariable("id") final String id, @PathVariable("name") final String name) {
		userRepository.update(new User(id, name, 1000L));
		return userRepository.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public Map<String, User> delete(@PathVariable("id") final String id) {
		userRepository.delete(id);
		return all();
	}

	@GetMapping("/all")
	public Map<String, User> all() {
		Map<String, User> findAll = userRepository.findAll();
		return findAll;
	}
}
