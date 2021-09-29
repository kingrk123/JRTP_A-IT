package in.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.EligibilityDetailEntity;

public interface EligibilityDetailsRepository extends JpaRepository<EligibilityDetailEntity, Serializable> {

	public EligibilityDetailEntity findByCaseNum(Long caseNum);
}
