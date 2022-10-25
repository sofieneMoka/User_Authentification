package tn.esprit.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

@Entity
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long IdUser ;
	
	@NotNull
	String FirstName ; 
	@NotNull
	String LastName ;
	@NotNull
	@Column(unique=true)
	String Email ;
	@NotNull
	String Password ;
	@NotNull
	Date Birthday ;
	@NotNull
	String Gender ;
	@NotNull
	Integer EmailVerified ;
	
}
