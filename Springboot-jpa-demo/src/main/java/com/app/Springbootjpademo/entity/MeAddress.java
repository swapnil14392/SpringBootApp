package com.app.Springbootjpademo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ME_ADDRESS_DETAILS")
public class MeAddress extends CommonColumn {
	@Id
	@GeneratedValue(generator = "tblGenerator",strategy = GenerationType.TABLE)
	@TableGenerator(name = "tblGenerator")
	@Column(name = "ADDRESS_ID", length = 10)
	private Long addressId;
	
	@Column(name = "ADDRESS1", length = 20)
	private String address1;
	
	@Column(name = "ADDRESS2", length = 30)
	private String address2;
	
	@Column(name = "ADDRESS3", length = 50)
	private String address3;
	
	@Column(name = "CITY", length = 20)
	private String city;
	
	@Column(name = "STATE", length = 20)
	private String state;
	
	@Column(name = "PINCODE", length = 6)
	private Integer pinCode;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "me_id")
	private MerchantDetails mid;
}
