package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.model.User;

public interface UserService {

    public String addUser(User user);
    public User getUserById(long id);
    public List<User> getAllUser();
    public void DeleteUser(long id);
    public void DeleteAllUser();
    public void UpdateUser(User user);
    public String sendSimpleMail(String email);
    public String EmailVerified(String email,double CodeValidation);
    
}
