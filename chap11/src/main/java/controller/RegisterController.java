package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.DuplicateMemberException;
import spring.MemberRegisterService;
import spring.RegisterRequest;



@Controller
public class RegisterController {
	
	
	private MemberRegisterService memberRegisterService;

	@RequestMapping(value="/register/step1",method = RequestMethod.GET)
	public String handleStep1() {
		return "register/step1";
	}
	
	@GetMapping("/register/step2")
	public String handleStep2get() {
		return "redirect:/register/step1";
	}
	
	
	@RequestMapping(value="/register/step2", method = RequestMethod.POST)
	public String handleStep2(@RequestParam(value = "agree", defaultValue="false") Boolean agree) {
		if(!agree) {
			return "register/step1";
		}
	
		return "register/step2";	
	}
	
	@PostMapping("/register/step3")
	public String handleStep3(RegisterRequest regReq) {
		//커맨드 객체
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		}catch(DuplicateMemberException ex) {
			return "register/step2";
		}
	}

	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
	}
	
	
}
