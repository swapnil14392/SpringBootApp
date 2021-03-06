package com.app.Springbootjpademo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.app.Springbootjpademo.dto.MerchantDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MERCHANT_DETAILS")

@NamedEntityGraph(name = "address.withAllDetails",attributeNodes = {
		@NamedAttributeNode(value = "meAddress",subgraph = "withAddress")
		},
subgraphs = {@NamedSubgraph(name="withAddress", attributeNodes =  @NamedAttributeNode ("mid"))}
)

@NamedQuery(name = "MerchantDetails.merchantsByNamesQuery",query ="SELECT M FROM MerchantDetails M WHERE M.appNo=?1" )
public class MerchantDetails extends CommonColumn {
	@Id
	@GeneratedValue(generator = "tblGenerator",strategy = GenerationType.TABLE)
	@TableGenerator(name = "tblGenerator")
	@Column(name = "APP_NO", length = 10)
	private Long appNo;
	@Column(name = "ME_NAME", length = 30,unique = true)
	private String merchantName;
	@Column(name = "MOB_NO", length = 15)
	private String mobileNo;
	@Column(name = "EMAIL", length = 50)
	private String emailId;
	@Column(name = "PAN", length = 10)
	private String panNo;
	@JsonManagedReference
	@Exclude
	@OneToMany(mappedBy = "mid",cascade = CascadeType.ALL,orphanRemoval=true,fetch = FetchType.LAZY)
	private List<MeAddress> meAddress;

	public MerchantDetails convertToDto(MerchantDto dto) {
	MerchantDetails d=new MerchantDetails();
	d.setMerchantName(dto.getMerchantName());
	d.setMeAddress(dto.getMeAddress());
	d.setMobileNo(dto.getMobileNo());
	d.setEmailId(dto.getEmailId());
	return d;
	
	
	}
}
