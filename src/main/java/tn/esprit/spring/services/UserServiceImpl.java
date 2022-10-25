package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.model.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository ;

	@Override
	public void addUser(User user) {
        userRepository.save(user);	
	}

	@Override
	public User getUserById(long id) {
        return userRepository.findById(id).get();
	}

	@Override
	public List<User> getAllUser() {
		List<User> ListUser = new ArrayList<User>();
		ListUser.addAll(userRepository.findAll());
		return ListUser;
	}

	@Override
	public void DeleteUser(long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void DeleteAllUser() {
		userRepository.deleteAll();
	}

	@Override
	public void UpdateUser(User user) {
		userRepository.save(user);
	}


}
