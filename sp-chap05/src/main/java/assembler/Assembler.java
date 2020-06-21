package assembler;

import spring.ChangePasswordService;
import spring.MemberDAO;
import spring.MemberRegisterService;

public class Assembler {
	private MemberDAO memberDao;
	private MemberRegisterService regSvc;
	private ChangePasswordService pwdSvc;

	public Assembler() {
		memberDao = new MemberDAO();
		regSvc = new MemberRegisterService(memberDao);
		pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao);
	}

	public MemberDAO getMemberDao() {
		return memberDao;
	}

	public MemberRegisterService getMemberRegisterService() {
		return regSvc;
	}

	public ChangePasswordService getChangePasswordService() {
		return pwdSvc;
	}

}
