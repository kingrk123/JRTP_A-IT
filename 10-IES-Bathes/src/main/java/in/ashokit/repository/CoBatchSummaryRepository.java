package in.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.CoBatchSummaryEntity;

@Repository("coBatchSummaryRepo")
public interface CoBatchSummaryRepository extends JpaRepository<CoBatchSummaryEntity, Serializable> {

}// CoBatchSummaryRepository
