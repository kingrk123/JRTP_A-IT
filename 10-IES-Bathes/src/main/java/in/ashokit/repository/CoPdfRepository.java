package in.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.CoPdfEntity;

@Repository("coPdfRepository")
public interface CoPdfRepository extends JpaRepository<CoPdfEntity, Serializable> {

}
