package com.app.Springbootjpademo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.Springbootjpademo.dto.MerchantDto;
import com.app.Springbootjpademo.entity.MerchantDetails;
import com.app.Springbootjpademo.exception.DataNotFoundException;
import com.app.Springbootjpademo.repository.MerchantDetailsRepo;
import com.cosium.spring.data.jpa.entity.graph.domain.EntityGraphs;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class MerchantService {
	@Autowired
	private MerchantDetailsRepo detailsRepo;
	
	@Transactional
	public MerchantDetails saveMerchant(MerchantDetails merchantDetails) {
		
	//	MerchantDetails dt=new MerchantDetails();
		
		return detailsRepo.save(merchantDetails);
		
		
	}
	
	public Page<MerchantDetails> fetchAllMerchants(Pageable page){
		return detailsRepo.findAll(page);
	}
	@Transactional(readOnly = true)
	public Optional<MerchantDetails> fetchMerchantByName(String name) {
		Optional<MerchantDetails> merch=detailsRepo.findByMerchantName(name);
		if(!merch.isPresent()) {
			System.out.println("data not found");
		}
		return merch;
	}
	@Transactional(readOnly = true)
	public Optional<MerchantDetails> fetchMerchantByNameAndAppNo(String name, Long id) {
		// TODO Auto-generated method stub
		return detailsRepo.findByMerchantNameIgnoreCaseAndAppNo(name,id);
	}
	@Transactional
	public MerchantDetails modifyMerchantDetails(MerchantDetails details,Long id) throws Exception{
		MerchantDetails mer=detailsRepo.findById(id).orElseThrow(()->new Exception("id not found"));
		log.info("merchant details:{}", mer);
		mer.setMerchantName(details.getMerchantName());
			
		return detailsRepo.save(mer);
		}
	@Transactional	
	public void deleteMerchantById(Long id) {
	Optional<?> o= detailsRepo.findById(id);
	
	if(o.isPresent()) {
		detailsRepo.deleteById(id);
	}else {
	o.orElseThrow(()->new DataNotFoundException("Data Not found for id: "+id));	
	}
		
	}
	@Transactional(readOnly = true)
	public Optional<MerchantDetails> fetchByEntityGraph(Long id){
		return detailsRepo.findByAppNo(id);
	}
	@Transactional(readOnly = true)
	public Optional<MerchantDetails> fetchById(Long id){
		return detailsRepo.findById(id);
	}
	public void testAOP(String name) {
		System.out.println(" call service aop.."+name);
	}

	
	
	
}
