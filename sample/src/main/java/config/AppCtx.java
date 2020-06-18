 package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.ChangePasswordService;
import spring.MemberDAO;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;

@Configuration
public class AppCtx {
	
	@Bean
	public MemberDAO memberdao()  // 메서드 이름인데 인자로 사용이 가능하다!?
	{
	return new MemberDAO();
	}
	
	@Bean
	public MemberRegisterService memberRegSvc() 
	{
		return new MemberRegisterService(memberdao());
	}
	@Bean
	public ChangePasswordService changePwdSvc() 
	{
		ChangePasswordService pwdsvc = new ChangePasswordService();
		pwdsvc.setMemberDao(memberdao());
		return pwdsvc;	
	}
	
	@Bean
	public MemberPrinter memberprinter() {
	    return new MemberPrinter();
	}
	@Bean
	public MemberListPrinter listprinter() {
		return new MemberListPrinter(memberdao(),memberprinter());
		
	}
}
