package spring;

import org.springframework.beans.factory.annotation.Autowired;



public class MemberinfoPrinter {
	private MemberDAO memberdao;
	private MemberPrinter memberprinter;
	
	
	public void printMemberInfo(String email) {
		Member member=memberdao.selectMemberbyEmail(email);
		if(member==null) {
			System.out.println("데이터 없음\n");
			return;
		}
		memberprinter.print(member);
		System.out.println();
	}
	@Autowired
	public void setMemberdao(MemberDAO memberdao) {
		this.memberdao=memberdao;
		
	}
	@Autowired
	public void setPrinter(MemberPrinter printer) {
		memberprinter=printer;
	}
	

}
