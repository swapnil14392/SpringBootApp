package com.app.Springbootjpademo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.app.Springbootjpademo.dto.MerchantDto;
import com.app.Springbootjpademo.entity.MerchantDetails;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface MerchantMapper {
	MerchantDetails convertToDetails (MerchantDto dto);
	MerchantDto convertToDto(MerchantDetails dto);
	List<MerchantDto> convertToDtoList(List<MerchantDetails> entity);
	
}
