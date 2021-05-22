package company.myntra.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("loginService")
public interface LoginService {
	public boolean checkLogin(String name, String password);
}
