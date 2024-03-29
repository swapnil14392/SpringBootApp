package com.app.Springbootjpademo.dto;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import com.app.Springbootjpademo.entity.MeAddress;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MerchantDto {
	@NotBlank(message = "merchant name is required")
	private String merchantName;
	@Size(max = 10,min = 10,message = "mobile no should be 10 digit")
	private String mobileNo;
	private String emailId;
	private String panNo;
	private List<MeAddress> meAddress;
	private LocalDate updatedOn;
	private String updatedBy;
}
