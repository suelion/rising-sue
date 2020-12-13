package proj04;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_manage {
	
	
	// 판매된 것만 배열로 만들어서 기록하기 
	private static Product[] salesArr = new Product[0]; // 빈 배열 생성
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menu = "판매관리 메뉴 (20191019 이수빈) : " 
				+ "\n1. 매출 " 
				+ "\n2. 매입 " 
				+ "\n3. 재고 " 
				+ "\n4. 재고 반품 "
				+ "\n5. 순이익 확인 " 
				+ "\n6. 판매 기록 보기" 
				+ "\n0. 종료 " 
				+ "\n입력 >>";
		int select; // 메뉴 선택용
		Manage manage = new Manage(); 
		StringBuilder message = null; // 메시지 출력용
		
		while (true) {
			try { // 사용자가 숫자 외의 문자를 입력하면 InputMismatchException 이 발생. 이를 처리해주기 위해 try-catch 사용

				// 프로그램 메뉴 출력
				System.out.println(manage.toString());
				System.out.print(menu);
				
				// 메뉴 선택
				select = sc.nextInt();

				switch (select) {
				case 0: // 0. 프로그램 종료
					System.out.println("프로그램 종료");
					System.exit(0);
					return;

				case 1: // 1. 매출
					message = new StringBuilder("\t판매할 메뉴를 고르세요.\n");
					for (ProductEnum pe : ProductEnum.values()) {
						Product p = pe.getProduct();
						message.append(String.format("\t%d. %s, 판매가 %d원\n", p.getNum(), p.getName(), p.getSalePrice()));
					}
					message.append("\t입력>>");
					System.out.print(message);
					select = sc.nextInt();
					if (manage.sales(select)) { // 판매 성공 시
						// 로그 기록을 위해 배열에 판매한 상품을 등록 
						salesArr = Arrays.copyOf(salesArr, salesArr.length + 1); // 기존 배열 보다 1칸을 키우고, 원소 복사
						salesArr[salesArr.length -1] = ProductEnum.getElementByNum(select).getProduct(); // 마지막 칸에 판매한 상품을 저장
						System.out.println("판매 완료!");
					} else {
						System.out.println("잘못된 메뉴입니다.");
					}
					
					break;
				case 2: // 2. 매입
					message = new StringBuilder("\t매입할 메뉴를 고르세요.\n");
					for (ProductEnum pe : ProductEnum.values()) {
						Product p = pe.getProduct();
						message.append(String.format("\t%d. %s, 매입가 %d원\n", p.getNum(), p.getName(), p.getPurchasePrice()));
					}
					message.append("\t입력>>");
					System.out.print(message);
					select = sc.nextInt();  
					if (manage.purchase(select)) { // 재고 보충 성공 시
						System.out.println("구매 완료!");
					} else {
						System.out.println("잘못된 메뉴입니다.");
					}
					
					break;
				case 3: // 3. 재고
					message = new StringBuilder("\t---- 재고 현황 ----\n");
					for (ProductEnum pe : ProductEnum.values()) {
						Product p = pe.getProduct();
						message.append(String.format("\t%d. %s, %d 개\n", p.getNum(), p.getName(), pe.getCount()));
					}
					System.out.println(message);
					break;	
				case 4: // 4. 반품
					message = new StringBuilder("\t구매처에 반품할 메뉴와 수량을 입력하세요.\n");
					for (ProductEnum pe : ProductEnum.values()) {
						Product p = pe.getProduct();
						message.append(String.format("\t%d. %s, 매입가 %d원\n", p.getNum(), p.getName(), p.getPurchasePrice()));
					}
					message.append("\t입력>>");
					System.out.print(message);
					select = sc.nextInt(); 
					int count = sc.nextInt(); 
					if (manage.returnProduct(select, count)) { // 반품 성공 시
						System.out.println("반품 완료!");
					} else {
						System.out.println("잘못된 메뉴 혹은 수량입니다.");
					}
					break;
				case 5: // 5. 순이익 확인
					System.out.println(String.format("매출액: %d원, 매입액: %d원, 순이익:%d원", manage.getTotalIncome(), manage.getTotalOutcome(), manage.getNetProfit()));
					break;
				case 6: // 6. 판매 기록 보기
					message = new StringBuilder("\t---- 판매 기록 ----");
					for(Product p : salesArr) {
						message.append("\n\t" + p.toString());
					}
					System.out.println(message);
					System.out.println("매출액 : " + manage.getTotalIncome());
					break;
				default:
					break;
				} // switch
				
			} catch (InputMismatchException e) {
				System.out.println("정수를 선택하세요. 메뉴로 돌아갑니다..");
				sc.nextLine(); // nextLine(): System.in 스트림의 첫문자 ~ \n까지의 문자열을 scan 하는 역할 ==> 입력스트림에 들어있는 입력값 제거
			} // try-catch
		} // loop
	} // main()
} // class
