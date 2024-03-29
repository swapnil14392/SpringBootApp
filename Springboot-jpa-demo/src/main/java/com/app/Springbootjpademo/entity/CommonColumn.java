package com.app.Springbootjpademo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@MappedSuperclass
public class CommonColumn {
	@UpdateTimestamp
	@Column(name = "UPDATED_ON")
	private LocalDate updatedOn;
	@Column(name = "UPDATED_BY")
	private String updatedBy;
	
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = "SwapnilR";
	}

	
	
	
}
