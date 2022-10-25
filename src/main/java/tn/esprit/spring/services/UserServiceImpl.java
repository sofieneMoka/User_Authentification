package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.model.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository ;
	
	@Autowired private JavaMailSender javaMailSender;
	
	PasswordEncoder passwordEncoder;
	double CodeValidation = (int)(Math.random()*((999999-000000)+1));

	@Override
	public String addUser(User user) {
    	User u = userRepository.findByEmail(user.getEmail());
    	if(u == null) {
    		this.passwordEncoder = new BCryptPasswordEncoder();
    		user.setEmailVerified(0);
    		user.setPassword((this.passwordEncoder.encode(user.getPassword())));
            userRepository.save(user);
            this.sendSimpleMail(user.getEmail());
    		return "User added successfully";
    	}
    	else {
    		return "Email does not exist";
    	}
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
	
	 @Value("${spring.mail.username}") private String sender;
	 
	    public String sendSimpleMail(String email)
	    {
	        // Try block to check for exceptions
	        try {
	 
	            // Creating a simple mail message
	            SimpleMailMessage mailMessage = new SimpleMailMessage();
	 
	            // Setting up necessary details
	            mailMessage.setFrom(sender);
	            mailMessage.setTo(email);
	            mailMessage.setText("This is your code validation : " + this.CodeValidation);
	            mailMessage.setSubject("CODE CONFIRMATION");
	 
	            // Sending the mail
	            javaMailSender.send(mailMessage);
	            return "Mail Sent Successfully...";
	        }
	 
	        // Catch block to handle the exceptions
	        catch (Exception e) {
	            return "Error while Sending Mail";
	        }
	    }
	    
	    public String EmailVerified(String email,double codebalidation) {
	    	
	    	User u = userRepository.findByEmail(email);
	    	if(u == null) {
	    		return "Email does not exist";
	    	}
	    	else if (codebalidation == this.CodeValidation) {
		    	u.setEmailVerified(1);
		    	userRepository.save(u);
		    	return "Email verified successfully ";
			} 
	    	else {
	    		return "Code invalid";
			}
	    }
	 


}
