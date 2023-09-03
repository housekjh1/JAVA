package myLinkedList;

import java.util.Scanner;

class Return {
	private String boo;
	
	public void ReTest(String boo) {
		this.boo = "참";
		
		if (this.boo.compareTo(boo) == 0) {
			System.out.println("참1");
			System.out.println("참2");
			System.out.println("참3");
			return; //메서드 종료 후 메인 생성자 호출문으로 돌아감
		} else {
			System.out.println("거짓1");
			System.out.println("거짓2");
			System.out.println("거짓3");
//			return; //두 경우 모두 return 사용 시 이후 명령문이 존재하면 에러 
		}
		
		System.out.println("종료1");
		System.out.println("종료2");
		System.out.println("종료3");
	}
}

public class ReturnTest {
	
	public static void main(String[] args) {
		
		Return re = new Return();
		Scanner sc = new Scanner(System.in);
		System.out.print("입력: ");
		re.ReTest(sc.next());
		System.out.println("프로그램 끝");
	
	}
}
