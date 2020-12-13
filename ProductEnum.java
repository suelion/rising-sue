package proj04;

/*
 * ������ Ŀ�� �޴��� ���۷��� �迭 ��� Enum���� �����غ��Ҵ�.
 * Enum�� ���� �ε����� ������ �ʿ䰡 ������,
 * Enum�� ��Ҹ� ��üȭ �� �� �־ ��ȸ�� ���ߴ�. 
 */
public enum ProductEnum {
	// �޴���(�޴���ȣ, ��¿� �޴��̸�, �� �� ����(���԰�), �� �� ����(���) )
	AMERICANO(0, "�Ƹ޸�ī��", 1500, 2500), 
	LATTE(1, "ī���", 2000, 3000), 
	CAFE_MOCHA(2, "ī���ī", 2500, 3500),
	JUICE(3, "�꽺", 1500, 2000),
	CAPPUCHINO(4, "īǪġ��", 3500, 4000);

	// Product p1 = ProductEnum.LATTE.getProduct()
	// Product p2 = ProductEnum.LATTE.getProduct()
	// p1 == p2 ? (O) 
	private Product product; // ��ǰ ���� ��ü
	private int count = 10;  // �� ��ǰ�� ���

	private ProductEnum(int num, String name, int purchase_price, int sale_price) {
		product = new Product(num, name, purchase_price, sale_price);
		this.count = 10; // ���� ������ 10���� ����

	}
	
	// getters and setters
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	// Object �κ��� ��� ���� toString() �������̵�
	// (��� ������ ��µǵ���)
	// ��) System.out.println(ProductEnum.AMERICANO) 
	// 		��� ���) "\n�Ƹ޸�ī��/���10��"
	public String toString() {
		return "\n" + product.toString() + "/ ��� " + count + "��";
	}
	
	// ��ǰ ��ȣ�� ���� Enum ���Ҹ� ã�´�. (�̵�� ��ǰ�� ��� null�� �����Ѵ�.)
	// �迭�� ����ߴٸ� �� �޼���� �ʿ����. 
	public static ProductEnum getElementByNum(int num) {
		
//		double[] arr = {1,2,3,4,5};
//		for(double tmp:arr) {
//			System.out.println(tmp);
//		}
		
		for (ProductEnum pe : ProductEnum.values()) {
			if (pe.getProduct().getNum() == num) {
				return pe;
			}
		}
		return null;
	}
	
}
