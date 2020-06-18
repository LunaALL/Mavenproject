package spring;

import java.util.Collection;

public class MemberListPrinter {
	
	private MemberDAO memberdao;
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDAO memberdao, MemberPrinter printer) {
		
		this.memberdao = memberdao;
		this.printer = printer;
	}
	
	public void printAll () {
		Collection<Member> members = memberdao.selectAll();
		members.forEach(m -> printer.print(m));
		
		
	}
	
	

}
