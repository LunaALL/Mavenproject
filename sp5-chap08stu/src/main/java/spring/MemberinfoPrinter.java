package spring;

import org.springframework.beans.factory.annotation.Autowired;



public class MemberinfoPrinter {
	private MemberDao memberdao;
	private MemberPrinter memberprinter;
	
	
	public void printMemberInfo(String email) {
		Member member=memberdao.selectByEmail(email);
		if(member==null) {
			System.out.println("데이터 없음\n");
			return;
		}
		memberprinter.print(member);
		System.out.println();
	}
	@Autowired
	public void setMemberdao(MemberDao memberdao) {
		this.memberdao=memberdao;
		
	}
	@Autowired
	public void setPrinter(MemberPrinter printer) {
		memberprinter=printer;
	}
	

}
