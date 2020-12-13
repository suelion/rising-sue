package proj01_1;
import java.io.*;
import java.util.Scanner;

public class CalUser {
	// static 
	// : 프로그램 로딩 시 생성됨 => new 안해도 이미 존재함 ==> 클래스명.static멤버명
	//  CalUser.oprnd1
	private static double oprnd1, oprnd2;
	private static String operator;
	
	//여기를 작성하시오
	public static void main(String[] args) {
		System.out.print("연산식을 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		oprnd1 = sc.nextDouble();
		operator = sc.next();
		oprnd2 = sc.nextDouble();
		
		SimpleCal cal = new SimpleCal();
		double result = 0.0;
		switch (operator) {
		case "+":
			result = cal.add(oprnd1, oprnd2);
			break;
		case "-":
			result = cal.sub(oprnd1, oprnd2);
			break;
		case "*":
			result = cal.multi(oprnd1, oprnd2);
			break;
		case "/":
			result = cal.div(oprnd1, oprnd2);
			break;
		default:
			System.out.println("잘못된 입력");
			break;
		}
		System.out.println("결과 : " + oprnd1 + ' ' + operator + ' ' + oprnd2 + ' ' + '=' + ' ' + result);
		sc.close();
	}
}
