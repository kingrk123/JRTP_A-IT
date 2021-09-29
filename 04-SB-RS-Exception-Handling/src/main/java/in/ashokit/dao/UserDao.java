package in.ashokit.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import in.ashokit.exception.NoDataFoundException;

@Repository
public class UserDao {

	// In-Memory Database
	private Map<Integer, String> usersData = new HashMap<>();

	public UserDao() {
		usersData.put(101, "Raju");
		usersData.put(102, "Rani");
	}

	public String findNameById(Integer userId) throws Exception {
		if (usersData.containsKey(userId)) {
			String name = usersData.get(userId);
			return name;
		} else {
			throw new NoDataFoundException("Invalid User ID");
		}
	}
}
