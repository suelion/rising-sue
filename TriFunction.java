package proj02;


/*
 * 2. ���� ���� 1���� ������ ����� ����ϴ� ���п� ���� EngCal�� ������� �Ѵ�. 
 * ���п� ����� ��Ģ���� �ܿ� �ﰢ�Լ� ���� ���ϴ� sin(), cos() �׸��� tan() ������ �߰��� ������. 
 * �� �Ʒ� �־��� TriFunction�̶�� �������̽��� ����Ͽ��� �ϸ�, ��Ģ������ ���� ���� 1-1�� SimpleCal Ŭ������ ��ӹ޾� �ۼ��Ѵ�. 

	interface TriFunction {
		public sin(double degree);
		public cos(double degree);
		public tan(double degree);
	}
 * 
 */
public interface TriFunction {
	public double sin(double degree);
	public double cos(double degree);
	public double tan(double degree);
}
