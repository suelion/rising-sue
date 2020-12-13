package proj04;

public class Product{
	// 상품 번호, 상품명, 매입가, 판매가
	private int num;
	private String name;
	private int purchasePrice;
	private int salePrice;

	// 생성자
	public Product(int num, String name, int purchase_price, int sale_price) {
		this.num = num;
		this.name = name;
		this.purchasePrice = purchase_price;
		this.salePrice = sale_price;
	}
	
	
	// getters & setters
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchase_price) {
		this.purchasePrice = purchase_price;
	}

	public int getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(int sale_price) {
		this.salePrice = sale_price;
	}
	
	@Override
	public String toString() {
		return "[" + name + "] 매입가 "+purchasePrice + " / 판매가 "+salePrice;
	}
	

}



