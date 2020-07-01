package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.Appctx;
import spring.ChangePasswordService;
import spring.MemberNotFoundException;
import spring.WrongIdPasswordException;

public class MainForCPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Appctx.class);
		
		ChangePasswordService cps = ctx.getBean(ChangePasswordService.class);
		try {
			cps.changePassword("wooju407@naver.com", "test123", "test321");
			System.out.println("암호변경 성공!");
		}catch(MemberNotFoundException e) {
			System.out.println("회원 데이터가 존재하지 않습니다.");
		}catch(WrongIdPasswordException e) {
			System.out.println("암호가 올바르지 않음. ");
		}
		
		ctx.close();
		

	}

}
