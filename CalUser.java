package proj01_1;
import java.io.*;
import java.util.Scanner;

public class CalUser {
	// static 
	// : ���α׷� �ε� �� ������ => new ���ص� �̹� ������ ==> Ŭ������.static�����
	//  CalUser.oprnd1
	private static double oprnd1, oprnd2;
	private static String operator;
	
	//���⸦ �ۼ��Ͻÿ�
	public static void main(String[] args) {
		System.out.print("������� �Է��ϼ��� : ");
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
			System.out.println("�߸��� �Է�");
			break;
		}
		System.out.println("��� : " + oprnd1 + ' ' + operator + ' ' + oprnd2 + ' ' + '=' + ' ' + result);
		sc.close();
	}
}
