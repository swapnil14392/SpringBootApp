package com.app.Springbootjpademo.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Springbootjpademo.entity.MerchantDetails;


@Repository
public interface MerchantDetailsRepo extends JpaRepository<MerchantDetails, Long>{

	Optional<MerchantDetails> findByMerchantName(String name);
	Optional<MerchantDetails> findByMerchantNameIgnoreCaseAndAppNo(String name, Long id);
/*EntityGraphJpaSpecificationExecutor interface used for EntityGraph parameter but it giving findone method exception...*/
	@EntityGraph(value = "address.withAllDetails")
	Optional<MerchantDetails> findByAppNo(Long id); 

}
