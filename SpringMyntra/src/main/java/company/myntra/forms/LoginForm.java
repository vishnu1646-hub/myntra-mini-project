package company.myntra.forms;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {
	@NotEmpty
	private String userName;
	@NotEmpty
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
