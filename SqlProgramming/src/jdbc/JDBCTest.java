package jdbc;

import java.util.List;
import java.util.Scanner;

public class JDBCTest {
	public static void main(String[] args) {
		
		MyJDBC mj = new MyJDBC("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/world", "scott", "tiger");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("쿼리문을 입력하세요.: ");
		String sql = sc.nextLine();
		
		try {
			List<List<String>> list = mj.queryWithStatement(sql);
			mj.printList(list);
		} catch (Exception e) {
			System.out.println("연결 실패: " + e.getMessage());
		}
	}
}
