package in.ashokit.repository;

import java.util.List;

import in.ashokit.entity.CoTriggersEntity;

public interface CoTriggersDao {

	public List<CoTriggersEntity> findPendTrgrsWithOraHash(String status, Integer tb, Integer ci);

	public List<CoTriggersEntity> findPendTrgrs(String status);

}
