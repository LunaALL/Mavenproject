package spring;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;


public class MemberRegisterService {
	private MemberDAO memberDAO;

	public MemberRegisterService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	public Long regist(RegisterRequest req) {
		//존재하는 이메일인지 확인한다
		Member member = memberDAO.selectMemberbyEmail(req.getEmail());
		if(member!=null) {
			throw new MemberException("중복 이메일 발견"+req.getEmail());
		}
		
		Member newMember = new Member(
			req.getEmail(), req.getName(), req.getPassword(), LocalDateTime.now()
		);
		memberDAO.insert(newMember);
		return newMember.getId();
	}
	
	

}
