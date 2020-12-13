package proj02;

import java.util.Scanner;

import proj01_1.SimpleCal;

public class EngCal extends SimpleCal implements TriFunction {
	@Override
	public double cos(double degree) {
		return Math.cos(degree);
	}
	
	@Override
	public double sin(double degree) {
		return Math.sin(degree);
	}
	
	@Override
	public double tan(double degree) {
		return Math.tan(degree);
	}
	
	
	public static void main(String[] args) {
		
		
		System.out.println("1. 기본연산, 2. 삼각함수연산");
		Scanner alpha = new Scanner(System.in);
		int a = alpha.nextInt();
		
		if (a == 1) {
			System.out.print("연산식을 입력하세요 : ");
			Scanner sc = new Scanner(System.in);
			double oprnd1 = sc.nextDouble(); 
			String operator = sc.next(); 
			double oprnd2 = sc.nextDouble(); 
			
			EngCal cal = new EngCal(); 
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
			System.out.println("결과 : " + result);
		} 
		
		else if (a == 2) {
			System.out.print("연산식을 입력하세요 : ");
			Scanner sc = new Scanner(System.in);
			String tri = sc.next();
			double deg = sc.nextDouble(); 
			
			EngCal cal = new EngCal(); 
			double result = 0.0;
			switch (tri) {
			case "sin":
				result = Math.round(cal.sin(Math.PI * deg / 180)*100)/100.0;//
				break;
			case "cos":
				result = Math.round(cal.cos(Math.PI * deg / 180)*100)/100.0;
				break;
			case "tan":
				result = Math.round(cal.tan(Math.PI * deg / 180)*100)/100.0;
				break;
			
			default:
				System.out.println("잘못된 입력");
				break;
			}
			System.out.println("결과 : " + result);
		}
		
		alpha.close();
	}
}
