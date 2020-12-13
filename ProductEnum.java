package proj04;

/*
 * 고정된 커피 메뉴를 레퍼런스 배열 대신 Enum으로 구현해보았다.
 * Enum을 쓰니 인덱스로 접근할 필요가 없었고,
 * Enum의 요소를 객체화 할 수 있어서 조회가 편했다. 
 */
public enum ProductEnum {
	// 메뉴명(메뉴번호, 출력용 메뉴이름, 살 때 가격(매입가), 팔 때 가격(출고가) )
	AMERICANO(0, "아메리카노", 1500, 2500), 
	LATTE(1, "카페라떼", 2000, 3000), 
	CAFE_MOCHA(2, "카페모카", 2500, 3500),
	JUICE(3, "쥬스", 1500, 2000),
	CAPPUCHINO(4, "카푸치노", 3500, 4000);

	// Product p1 = ProductEnum.LATTE.getProduct()
	// Product p2 = ProductEnum.LATTE.getProduct()
	// p1 == p2 ? (O) 
	private Product product; // 상품 정보 객체
	private int count = 10;  // 각 상품별 재고

	private ProductEnum(int num, String name, int purchase_price, int sale_price) {
		product = new Product(num, name, purchase_price, sale_price);
		this.count = 10; // 재고는 무조건 10개로 시작

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

	// Object 로부터 상속 받은 toString() 오버라이드
	// (요소 정보가 출력되도록)
	// 예) System.out.println(ProductEnum.AMERICANO) 
	// 		출력 결과) "\n아메리카노/재고10개"
	public String toString() {
		return "\n" + product.toString() + "/ 재고 " + count + "개";
	}
	
	// 상품 번호를 통해 Enum 원소를 찾는다. (미등록 상품의 경우 null을 리턴한다.)
	// 배열을 사용했다면 이 메서드는 필요없다. 
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
