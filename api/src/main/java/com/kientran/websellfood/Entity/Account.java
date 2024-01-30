package com.kientran.websellfood.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="account")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "username")
	private String Username;
	
	@Column(name = "password")
	private String Password;
	
	@Column(name = "email")
	private String Email;
	
	@OneToOne(mappedBy = "account")
	private Customer customer;
	
	@OneToOne(mappedBy = "account")
	private Staff staff;
	
}
