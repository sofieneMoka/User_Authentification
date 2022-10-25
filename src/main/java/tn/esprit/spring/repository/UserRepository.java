package tn.esprit.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	@Query("SELECT u FROM User u WHERE u.Email=?1")
	User findByEmail(String email);
}
