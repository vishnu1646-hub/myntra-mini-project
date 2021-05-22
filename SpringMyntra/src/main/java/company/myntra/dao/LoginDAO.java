package company.myntra.dao;

import org.springframework.stereotype.Repository;

@Repository("loginDAO")
public interface LoginDAO {
	public boolean checkLogin(String name, String password);
}
