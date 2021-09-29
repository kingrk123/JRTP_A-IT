package in.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.CoBatchRunDetailsEntity;

@Repository("coBatchRunDetailRepo")
public interface CoBatchRunDetailsRepository extends JpaRepository<CoBatchRunDetailsEntity, Serializable> {

}// CoBatchRunDetailsRepositor
