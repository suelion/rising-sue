package proj03;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class tes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		try {
 		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a/b);
		} catch (InputMismatchException e) {
			// TODO: handle exception
			System.out.println("잘못된 입력 ");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (ArithmeticException e) {
			// TODO: handle exception
			System.out.println("0으로 ");
		} 
		// java.util.InputMismatchException
		// java.lang.ArithmeticException
		
		
		
	}
}
