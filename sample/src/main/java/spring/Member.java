package spring;

import java.time.LocalDateTime;

public class Member {
	
	private Long id;
	private String email;
	private String password;
	private String name;
	private LocalDateTime registerDataTime;
	
	

	public Member(String email, String name, String password, LocalDateTime registerDataTime) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDataTime = registerDataTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public LocalDateTime getRegisterDataTime() {
		return registerDataTime;
	}
	
	public void changePassword(String oldpassword, String newpassword) {
		System.out.println("old"+ oldpassword);
		System.out.println("old"+ newpassword);
		System.out.println("this password=" + this.password);
		if(!(password.equals(oldpassword) )) {
			throw new WrongIdPasswordException();
		}
		
		this.password=newpassword;
		
	}
	

}
