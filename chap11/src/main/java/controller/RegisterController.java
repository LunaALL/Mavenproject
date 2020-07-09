package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.RegisterRequest;

@Controller
public class RegisterController {

	@RequestMapping(value="/register/step1", method = RequestMethod.GET)
	public String handleStep1() {
		return "register/step1";
	}
	@PostMapping(value="/register/step2 ")
	public String handleStep(@RequestParam(value = "agree", defaultValue="false") Boolean agree,Model model) {
		if(!agree) {
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
		
	}
}
