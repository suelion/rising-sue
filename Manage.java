package proj04;

public class Manage {

	// �ܺο��� ���� �Ұ�. ��, ��ȸ�� �����ϵ��� getter�� public
	private int totalIncome = 0; // �� ���Ⱑ (���� ��)
	private int totalOutcome = 0; // �� ���԰� (���� ��)

	public Manage() {
		initTotalOutcome(); // �ʱ� ���԰� ����(���� 1ȸ�� �����)
	}

	public int getTotalIncome() {
		return totalIncome;
	}

	public int getTotalOutcome() {
		return totalOutcome;
	}

	// ���� ��� (��ǰ �����)
	public boolean purchase(ProductEnum p) {
		p.setCount(p.getCount() + 1); // ��ǰ p�� ��� 1 ����
		totalOutcome += p.getProduct().getPurchasePrice(); // �� ���԰� ����
		return true;
	}

	// ���� ��� (�����ε�)
	public boolean purchase(int num) { 

		// num�� �ش��ϴ� �޴��� Enum ���� ã�´�.
		ProductEnum p = ProductEnum.getElementByNum(num);

		// �߸��� ��ȣ���
		if (p == null) {
			return false;
		}

		return purchase(p);
	}

	// ���� ��� (��ǰ �Ǹ� �ϱ�)
	public boolean sales(int num) {

		// num�� �ش��ϴ� �޴��� Enum ���� ã�´�.
		ProductEnum p = ProductEnum.getElementByNum(num);

		// �߸��� ��ȣ���
		if (p == null) {
			return false;
		}

		// ��� ���ٸ�
		if (p.getCount() == 0) {
			return false;
		}

		// ����� 1�� ����.
		p.setCount(p.getCount() - 1);

		// ����� ����
		totalIncome += p.getProduct().getSalePrice();

		return true;
	}

	// ��ǰ ��� (��� ��ǰ)
	public boolean returnProduct(int num, int count) {
		ProductEnum p = ProductEnum.getElementByNum(num);
		// �߸��� ��ȣ���
		if (p == null) {
			return false;
		}

		// ��ǰ�� ������ ����� ������
		if (p.getCount() < count) {
			return false;
		}

		// ����� ��ǰ�� ������ ����
		p.setCount(p.getCount() - count);

		// ���Ծ� ���� (��� ��ǰ������ ���� ���� �پ���� �Ѵ�.) 
		totalOutcome -= p.getProduct().getPurchasePrice() * count;

		return true;
	}

	// ������
	public int getNetProfit() {
		return totalIncome - totalOutcome;
	}

	// �ʱ� ���԰� ����(���� 1ȸ�� �����)
	private void initTotalOutcome() {
		// �ʱ� ���԰� = �ʱ� ��ǰ ��� * ���԰�
		for (ProductEnum p : ProductEnum.values()) {
			totalOutcome += p.getCount() * p.getProduct().getPurchasePrice();
		}
	}

	// Object �κ��� ��� ���� toString() �������̵�
	// (��� ������ ��µǵ���)
	//
	// ��)
	// Manage m = new Manage();
	// System.out.println(m)
	// ��� ���)
	// =====================================================
	// [�Ƹ޸�ī��] ���԰� 1500 / �ǸŰ� 2500/ ��� 10��
	// [ī���] ���԰� 2000 / �ǸŰ� 3000/ ��� 10��
	// [ī���ī] ���԰� 2500 / �ǸŰ� 3500/ ��� 10��
	// [�꽺] ���԰� 1500 / �ǸŰ� 2000/ ��� 10��
	// [īǪġ��] ���԰� 3500 / �ǸŰ� 4000/ ��� 10��
	// =====================================================
	// StringBuilder�� ����Ͽ� �� String ��ü�� �����Ǵ� ���� �����Ѵ�.
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
