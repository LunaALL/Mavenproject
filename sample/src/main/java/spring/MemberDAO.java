package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemberDAO {
	
	private static long nextId=0;
	
	private Map<String, Member> map = new HashMap<String, Member>();
	
	public Member selectMemberbyEmail(String email) {
		return map.get(email);
	}
	
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
		
	}
	
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	
	
	public Collection<Member> selectAll(){
		return map.values();
		
		//인터페이스 반환을 통해서 해당 자료구조를 전부 반환함. 
	}

}
