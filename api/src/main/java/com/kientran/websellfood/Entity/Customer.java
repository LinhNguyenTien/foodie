package com.kientran.websellfood.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	

	@OneToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	
	@OneToOne(mappedBy = "customer")
	private Cart cart;
	
	
}
