package com.app.Springbootjpademo.entity;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Immutable
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY )
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USER_MASTER")
public class UserMaster {
	@Id
	@GeneratedValue
	@Column(name = "SR_NO")
	private Long srNo;
	
	@Column(name = "USER_ID")
	private String userId;
	@Column(name = "USER_NAME")
	private String userName;
	
	
}
