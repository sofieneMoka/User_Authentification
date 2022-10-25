package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.model.User;
import tn.esprit.spring.services.UserServiceImpl;

@RestController
@RequestMapping("api/User")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	public UserController(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}
	
	@GetMapping("/AllUser")
	@ResponseBody
	public List <User> getAllUser(){
		return userServiceImpl.getAllUser();	
		}
	@GetMapping("/{id}")
	@ResponseBody
	public User getUserById(@PathVariable long id) {
		return userServiceImpl.getUserById(id);
	}
	@PostMapping("/AddUser")
	@ResponseBody
		public String AddUser(User user) {
			userServiceImpl.addUser(user);
			return "User add successfully !!";
		}
	@DeleteMapping("/DeleteAllUser")
	@ResponseBody
		public String DeleteAllUser() {
		userServiceImpl.DeleteAllUser();
		return "All users are deleted successfully !!";
	}
	@DeleteMapping("/DeleteUserById/{id}")
	@ResponseBody
	public String DeleteUserById(@PathVariable long id) {
		userServiceImpl.DeleteUser(id);
		return "User deleted successfully !!";
	}
	@PutMapping("UpdateUser")
	@ResponseBody
	public String UpdateRayon(User user) {
		userServiceImpl.UpdateUser(user);
		return"User updated successfully !!";
	}
}
