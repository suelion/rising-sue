package proj04;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_manage {
	
	
	// �Ǹŵ� �͸� �迭�� ���� ����ϱ� 
	private static Product[] salesArr = new Product[0]; // �� �迭 ����
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menu = "�ǸŰ��� �޴� (20191019 �̼���) : " 
				+ "\n1. ���� " 
				+ "\n2. ���� " 
				+ "\n3. ��� " 
				+ "\n4. ��� ��ǰ "
				+ "\n5. ������ Ȯ�� " 
				+ "\n6. �Ǹ� ��� ����" 
				+ "\n0. ���� " 
				+ "\n�Է� >>";
		int select; // �޴� ���ÿ�
		Manage manage = new Manage(); 
		StringBuilder message = null; // �޽��� ��¿�
		
		while (true) {
			try { // ����ڰ� ���� ���� ���ڸ� �Է��ϸ� InputMismatchException �� �߻�. �̸� ó�����ֱ� ���� try-catch ���

				// ���α׷� �޴� ���
				System.out.println(manage.toString());
				System.out.print(menu);
				
				// �޴� ����
				select = sc.nextInt();

				switch (select) {
				case 0: // 0. ���α׷� ����
					System.out.println("���α׷� ����");
					System.exit(0);
					return;

				case 1: // 1. ����
					message = new StringBuilder("\t�Ǹ��� �޴��� ������.\n");
					for (ProductEnum pe : ProductEnum.values()) {
						Product p = pe.getProduct();
						message.append(String.format("\t%d. %s, �ǸŰ� %d��\n", p.getNum(), p.getName(), p.getSalePrice()));
					}
					message.append("\t�Է�>>");
					System.out.print(message);
					select = sc.nextInt();
					if (manage.sales(select)) { // �Ǹ� ���� ��
						// �α� ����� ���� �迭�� �Ǹ��� ��ǰ�� ��� 
						salesArr = Arrays.copyOf(salesArr, salesArr.length + 1); // ���� �迭 ���� 1ĭ�� Ű���, ���� ����
						salesArr[salesArr.length -1] = ProductEnum.getElementByNum(select).getProduct(); // ������ ĭ�� �Ǹ��� ��ǰ�� ����
						System.out.println("�Ǹ� �Ϸ�!");
					} else {
						System.out.println("�߸��� �޴��Դϴ�.");
					}
					
					break;
				case 2: // 2. ����
					message = new StringBuilder("\t������ �޴��� ������.\n");
					for (ProductEnum pe : ProductEnum.values()) {
						Product p = pe.getProduct();
						message.append(String.format("\t%d. %s, ���԰� %d��\n", p.getNum(), p.getName(), p.getPurchasePrice()));
					}
					message.append("\t�Է�>>");
					System.out.print(message);
					select = sc.nextInt();  
					if (manage.purchase(select)) { // ��� ���� ���� ��
						System.out.println("���� �Ϸ�!");
					} else {
						System.out.println("�߸��� �޴��Դϴ�.");
					}
					
					break;
				case 3: // 3. ���
					message = new StringBuilder("\t---- ��� ��Ȳ ----\n");
					for (ProductEnum pe : ProductEnum.values()) {
						Product p = pe.getProduct();
						message.append(String.format("\t%d. %s, %d ��\n", p.getNum(), p.getName(), pe.getCount()));
					}
					System.out.println(message);
					break;	
				case 4: // 4. ��ǰ
					message = new StringBuilder("\t����ó�� ��ǰ�� �޴��� ������ �Է��ϼ���.\n");
					for (ProductEnum pe : ProductEnum.values()) {
						Product p = pe.getProduct();
						message.append(String.format("\t%d. %s, ���԰� %d��\n", p.getNum(), p.getName(), p.getPurchasePrice()));
					}
					message.append("\t�Է�>>");
					System.out.print(message);
					select = sc.nextInt(); 
					int count = sc.nextInt(); 
					if (manage.returnProduct(select, count)) { // ��ǰ ���� ��
						System.out.println("��ǰ �Ϸ�!");
					} else {
						System.out.println("�߸��� �޴� Ȥ�� �����Դϴ�.");
					}
					break;
				case 5: // 5. ������ Ȯ��
					System.out.println(String.format("�����: %d��, ���Ծ�: %d��, ������:%d��", manage.getTotalIncome(), manage.getTotalOutcome(), manage.getNetProfit()));
					break;
				case 6: // 6. �Ǹ� ��� ����
					message = new StringBuilder("\t---- �Ǹ� ��� ----");
					for(Product p : salesArr) {
						message.append("\n\t" + p.toString());
					}
					System.out.println(message);
					System.out.println("����� : " + manage.getTotalIncome());
					break;
				default:
					break;
				} // switch
				
			} catch (InputMismatchException e) {
				System.out.println("������ �����ϼ���. �޴��� ���ư��ϴ�..");
				sc.nextLine(); // nextLine(): System.in ��Ʈ���� ù���� ~ \n������ ���ڿ��� scan �ϴ� ���� ==> �Է½�Ʈ���� ����ִ� �Է°� ����
			} // try-catch
		} // loop
	} // main()
} // class
