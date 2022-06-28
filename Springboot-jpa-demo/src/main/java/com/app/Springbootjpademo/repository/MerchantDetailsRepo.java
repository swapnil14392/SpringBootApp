package com.app.Springbootjpademo.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import com.app.Springbootjpademo.entity.MerchantDetails;


@Repository
public interface MerchantDetailsRepo extends JpaRepository<MerchantDetails, Long>{
	/*Query Method-> Using Data Jpa*/
	Optional<MerchantDetails> findByMerchantName(String name);
	Optional<MerchantDetails> findByMerchantNameIgnoreCaseAndAppNo(String name, Long id);
	Optional<MerchantDetails>findByMerchantNameAndMeAddressCity(String name,String City);
	List<MerchantDetails>findByMerchantNameOrMeAddressPinCode(String name,String pincode);
	Optional<MerchantDetails>findByMerchantNameNot(String name); 
	Slice<MerchantDetails> findTop2ByEmailId(String email, Pageable pageable);
	MerchantDetails findTopByOrderByAppNoDesc();
	Streamable<MerchantDetails> findByMerchantNameContaining(String name);
	
	/*Entity Graph*/
	/*EntityGraphJpaSpecificationExecutor interface used for EntityGraph parameter but it giving findone method exception...*/
	@EntityGraph(value = "address.withAllDetails")
	Optional<MerchantDetails> findByAppNo(Long id); 
	
	/*@Query at repo method level*/
	@Query("SELECT M FROM MerchantDetails M" )
	List<MerchantDetails> fetchAllMerchantsByQuery();
	 
	@Query(value = "SELECT M FROM MerchantDetails M WHERE M.appNo=?1" )
	Optional<MerchantDetails>fetchMerchantsByQuery(Long app);
	
	/*@Query with name Param*/
	@Query(value = "SELECT M FROM MerchantDetails M WHERE M.appNo = :app" )
	Optional<MerchantDetails>fetchMerchantsByQueryNamedParam(@Param("app") Long app);
	
	/*@Named Query-> define at entity class level*/
	Optional<MerchantDetails>merchantsByNamesQuery(Long app);
	
	/*Native Query*/
	@Query(name = "SELECT * FROM merchant_details M WHERE M.EMAIL=:email",
			 nativeQuery = true )
	List<MerchantDetails> findByEmailId(String email); 
	
	
}
