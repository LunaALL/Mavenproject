package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//import java.sql.Connection
		
	       Connection conn = null;
	       
	       try {
	    	   //드라이버 로딩
	    	   //com.mysql.jdbc.driver , driver라는 클래스가 있음.
	    	  Class.forName("com.mysql.jdbc.driver");
	    	  
	    	  //연결
	    	  //드라이버 매니저에게 Connection 객체 요청
	    	  //커넥션을 얻기 위한 url 역시, db종류마다 다름
	    	  //mysql : jdbc:mysql://localhost:포트번호/사용할db이름"
	    	  String url = "jdbc:mysql://localhost:3306/newpoint";
	    	  conn= DriverManager.getConnection(url, "root", "woo123456789");
	    	  System.out.println("연결 완료");
	       }catch(ClassNotFoundException e) {
	    	   System.out.println("드라이버 로딩 실패");
	       }
	       catch(SQLException e) {
	    	   System.out.println("에러: "+e);
	       }finally {
			try {
				if(conn !=null && !conn.isClosed()) {
					conn.close();
				}
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
