package company.myntra.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import company.myntra.forms.LoginForm;
import company.myntra.service.LoginService;

@Controller
@RequestMapping("/loginForm")
public class LoginController {

	public LoginService loginService;

	@Autowired
	@Qualifier("loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("command", new LoginForm());
		return "login-page";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "login-page";
		}

		boolean userExists = loginService.checkLogin(loginForm.getUserName(), loginForm.getPassword());
		if (userExists) {
			model.addAttribute("command", loginForm);
			return "login-success";
		} else {
			model.addAttribute("command", loginForm);
			return "login-page";
		}

	}

}
