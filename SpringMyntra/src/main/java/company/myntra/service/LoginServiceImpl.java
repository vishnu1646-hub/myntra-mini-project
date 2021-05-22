package company.myntra.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import company.myntra.dao.*;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	private LoginDAO loginDAO;

	@Autowired
	@Qualifier("loginDAO")
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	@Override
	public boolean checkLogin(String name, String password) {
		return loginDAO.checkLogin(name, password);
	}

}
