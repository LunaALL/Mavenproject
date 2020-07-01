package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class ChangePasswordService {
	
	@Autowired          //객체를 자동주입함. (찾아서) 
	private MemberDao memberDao;

	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}
			

		member.changePassword(oldPwd, newPwd);

		memberDao.update(member);
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
