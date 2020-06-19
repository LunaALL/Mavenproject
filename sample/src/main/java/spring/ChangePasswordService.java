package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class ChangePasswordService {
	
	@Autowired          //객체를 자동주입함. (찾아서) 
	private MemberDAO memberDao;

	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectMemberbyEmail(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}
			

		member.changePassword(oldPwd, newPwd);

		memberDao.update(member);
	}

	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

}
