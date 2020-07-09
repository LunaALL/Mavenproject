package spring;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;


public class MemberRegisterService {
	private MemberDao memberDAO;

	public MemberRegisterService(MemberDao memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public Long regist(RegisterRequest req) {
		//존재하는 이메일인지 확인한다
		Member member = memberDAO.selectByEmail(req.getEmail());
		if(member!=null) {
			throw new DuplicateMemberException("중복 이메일 발견"+req.getEmail());
		}
		
		Member newMember = new Member(
			req.getEmail(), req.getName(), req.getPassword(), LocalDateTime.now()
		);
		memberDAO.insert(newMember);
		return newMember.getId();
	}
	
	

}
