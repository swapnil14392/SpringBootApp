package com.app.Springbootjpademo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.app.Springbootjpademo.common.ResponseObj;
import com.app.Springbootjpademo.dto.MerchantDto;
import com.app.Springbootjpademo.entity.MerchantDetails;
import com.app.Springbootjpademo.service.MerchantService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MerchantTestCtrl {
	@Autowired
	private MerchantService service;
	@Autowired
	ResponseObj responseObj;
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/store")
public ResponseObj saveMerchant(@Valid @RequestBody MerchantDetails dto) {
	
	MerchantDetails dt= service.saveMerchant(dto); 
	 responseObj.add("save",dt);
	 return responseObj;
}
	@PostMapping("/all")
	public Page<MerchantDetails> fetchAllMerchants(Pageable page){
		return service.fetchAllMerchants(page);
	}
	@GetMapping("byname/{name}")
	public ResponseEntity<MerchantDetails> fetchMerchantByName(@PathVariable String name){
	return	service.fetchMerchantByName(name);
	}
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping("byname/{name}/{id}")
	public Optional<MerchantDetails> fetchMerchantByNameAndAppNo(@PathVariable String name,@PathVariable Long id){
	return	service.fetchMerchantByNameAndAppNo(name,id);
	}
	@GetMapping("entity/{id}")
	public Optional<MerchantDetails> fetchByEntityGraph(@PathVariable Long id){
		return service.fetchByEntityGraph(id);
	}
	@GetMapping("id/{id}")
	public Optional<MerchantDetails> fetchById(@PathVariable Long id){
		return service.fetchById(id);
	}
	
	@PatchMapping("patch/{id}")
	public MerchantDetails modifyMerchantByPatch(@Valid @RequestBody MerchantDetails details,@PathVariable Long id) throws Exception {
		return service.modifyMerchantDetails(details,id);
	}
	@DeleteMapping("delete/{id}")
	public void deleteMerchantById(@PathVariable Long id) {
		service.deleteMerchantById(id);
		System.out.println("merchant details has been deleted for id: "+id);
	}
	
	@GetMapping("/aop/{name}")
	public void testAOP(@PathVariable String name) {
		service.testAOP(name);
	}
	@GetMapping("allbyQuery")
	public List<MerchantDetails>fetchAllMerchantsByQuery(){
		return service.fetchAllMerchantsByQuery();
	}
	@GetMapping("byQuery/{id}")
	public Optional<MerchantDetails>fetchMerchantsByQuery(@PathVariable Long id){
	log.info("initiate query request for id:{}", id);
		return service.fetchMerchantsByQuery(id);
	}
	@GetMapping("byQueryParam/{id}")
	public Optional<MerchantDetails>fetchMerchantsByQueryNamedParam(@PathVariable Long id){
	log.info("initiate query request for id:{}", id);
		return service.fetchMerchantsByQueryNamedParam(id);
	}
	@GetMapping("byNamedQuery/{id}")
	public Optional<MerchantDetails>fetchMerchantByNamedQuery(@PathVariable Long id){
	log.debug("initiate query request for id:{}", id);
		return service.fetchMerchantByNamedQuery(id);
	}
	
	@GetMapping("byNameCity/{name}/{city}")
	public Optional<MerchantDetails>fetchByNameAndCity(@PathVariable String name,@PathVariable String  city){
		return service.fetchByNameAndCity(name,city);
	}
	@GetMapping("byNativeQuery/{email}")
	public List<MerchantDetails>fetchByNativeQuery(@PathVariable String email){
		return service.fetchByNativeQuery(email);
	}
}
