package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.RegisterController;
import spring.MemberRegisterService;
import survey.SurveyController;

@Configuration
public class ControllerConfig {
	
	@Autowired
	private MemberRegisterService memberRegisterService;
	
	@Bean
	public RegisterController registerController() {
		RegisterController conf = new RegisterController();
		conf.setMemberRegisterService(memberRegisterService);
		return conf;
	}
	
	@Bean
	public SurveyController surveyController() {
		return new SurveyController();
		
	}
	
	
}
