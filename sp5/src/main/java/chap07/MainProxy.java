package chap07;

public class MainProxy {
	
	//중요한 기능을 가진 클래스를 바로 객체를 생성하여 쓰는게 아니라, AOP적 사고로 프록시 역할을 하는 클레스를 만든다!
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExeTimeCalculator ca = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println(ca.factorial(5));

	}

}
