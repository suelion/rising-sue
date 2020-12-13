package proj04;

public class Manage {

	// 외부에서 수정 불가. 단, 조회는 가능하도록 getter는 public
	private int totalIncome = 0; // 총 매출가 (들어온 돈)
	private int totalOutcome = 0; // 총 매입가 (나간 돈)

	public Manage() {
		initTotalOutcome(); // 초기 매입가 설정(최초 1회만 실행됨)
	}

	public int getTotalIncome() {
		return totalIncome;
	}

	public int getTotalOutcome() {
		return totalOutcome;
	}

	// 매입 기능 (상품 사오기)
	public boolean purchase(ProductEnum p) {
		p.setCount(p.getCount() + 1); // 상품 p의 재고 1 증가
		totalOutcome += p.getProduct().getPurchasePrice(); // 총 매입가 증가
		return true;
	}

	// 매입 기능 (오버로드)
	public boolean purchase(int num) { 

		// num에 해당하는 메뉴를 Enum 에서 찾는다.
		ProductEnum p = ProductEnum.getElementByNum(num);

		// 잘못된 번호라면
		if (p == null) {
			return false;
		}

		return purchase(p);
	}

	// 매출 기능 (상품 판매 하기)
	public boolean sales(int num) {

		// num에 해당하는 메뉴를 Enum 에서 찾는다.
		ProductEnum p = ProductEnum.getElementByNum(num);

		// 잘못된 번호라면
		if (p == null) {
			return false;
		}

		// 재고가 없다면
		if (p.getCount() == 0) {
			return false;
		}

		// 재고에서 1을 뺀다.
		p.setCount(p.getCount() - 1);

		// 매출액 증가
		totalIncome += p.getProduct().getSalePrice();

		return true;
	}

	// 반품 기능 (재고 반품)
	public boolean returnProduct(int num, int count) {
		ProductEnum p = ProductEnum.getElementByNum(num);
		// 잘못된 번호라면
		if (p == null) {
			return false;
		}

		// 반품할 수량이 재고보다 많으면
		if (p.getCount() < count) {
			return false;
		}

		// 재고에서 반품할 개수를 뺀다
		p.setCount(p.getCount() - count);

		// 매입액 감소 (재고를 반품했으니 나간 돈이 줄어들어야 한다.) 
		totalOutcome -= p.getProduct().getPurchasePrice() * count;

		return true;
	}

	// 순이익
	public int getNetProfit() {
		return totalIncome - totalOutcome;
	}

	// 초기 매입가 설정(최초 1회만 실행됨)
	private void initTotalOutcome() {
		// 초기 매입가 = 초기 상품 재고 * 매입가
		for (ProductEnum p : ProductEnum.values()) {
			totalOutcome += p.getCount() * p.getProduct().getPurchasePrice();
		}
	}

	// Object 로부터 상속 받은 toString() 오버라이드
	// (요소 정보가 출력되도록)
	//
	// 예)
	// Manage m = new Manage();
	// System.out.println(m)
	// 출력 결과)
	// =====================================================
	// [아메리카노] 매입가 1500 / 판매가 2500/ 재고 10개
	// [카페라떼] 매입가 2000 / 판매가 3000/ 재고 10개
	// [카페모카] 매입가 2500 / 판매가 3500/ 재고 10개
	// [쥬스] 매입가 1500 / 판매가 2000/ 재고 10개
	// [카푸치노] 매입가 3500 / 판매가 4000/ 재고 10개
	// =====================================================
	// StringBuilder를 사용하여 매 String 객체가 생성되는 것을 예방한다.
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("=====================================================");
		for (ProductEnum p : ProductEnum.values()) {
			sb.append(p);
		}
		sb.append("\n=====================================================");
		return sb.toString();
	}

}
