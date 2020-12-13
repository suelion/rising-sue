package proj03;

// ��Ƽ ������ ���
// ���1. Thread ���Ŭ������ ����   				=> Thread.run()
// ���2. Runnable ����Ŭ������ ���� Thread�� ����	=> Thread.run()
class SumRunnable implements Runnable {
	
	// �� �����尡 ������ �� ���� ���� �� ��
	private long n1, n2;

	
	// ������
	public SumRunnable(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}

	@Override 
	public void run() { // Runnable�� ������ run() �������̵�

		// �� ���� Ŭ ��� �� ���� �ڹٲ۴�. 
		if (n1 > n2) {
			long tmp = n1;
			n1 = n2;
			n2 = tmp;
		}

		// ������ ���Ѵ�. 
		long sum = 0;
		for (long i = n1; i <= n2; ++i) {
			sum += i;
		}
		
		// Main Ŭ������ static �޼��� updateTotal()�� ȣ���Ͽ� ������� �����Ѵ�.
		// �̶� updateTotal()�� ���� �޼����̹Ƿ� 5���� �����尡 ���ÿ� �̸� ȣ���ϴ���
		// �� �����徿 ���������� �ش� �޼��带 ����ϰ� �ȴ�.
		Main.updateTotal(sum);
	}
}

public class Main {
	
	// total �� private (�ܺο��� ���ٺҰ�, �� updateTotal()�� ���ؼ� ������ �����ϴ�.)
	// ū ������ �׽�Ʈ�ϱ� ���� long���� �����غ��Ҵ�.
	private static long total;

	// updateTotal() �� 1���� �����常 ���� �����ϴ�. (synchronized, ����ȭ ����)
	// ==> �ٸ� ������� ���, �ռ� �������� ����� �Ϸ�Ǿ�� ��� ����
	synchronized public static void updateTotal(long num) {
		Main.total += num;
	}

	public static void main(String[] args) {

		// ���� �ð��� ���� �ð��� �纸�Ҵ�.
		// 1 ~ 10000 ������ �̱۽����尡 ����ð��� �� ª������
		// 1 ~ 1000000000 �� ��쿡�� ��Ƽ�������� ����ð��� �� ª�Ҵ�.
		long startTime = System.currentTimeMillis();
		long endTime;
		
		// �̱� ������ : 305 �и���
//		for(int i = 0; i <= 1000000000; ++i) {
//			total += i;
//		}
		
		
		// ��Ƽ ������ : 167 �и���
//		Thread t1 = new Thread(new SumRunnable(1, 200000000));
//		Thread t2 = new Thread(new SumRunnable(200000001, 400000000));
//		Thread t3 = new Thread(new SumRunnable(400000001, 600000000));
//		Thread t4 = new Thread(new SumRunnable(600000001, 800000000));
//		Thread t5 = new Thread(new SumRunnable(800000001, 1000000000));

		// �迭�ε� ���� ���������� �������� ���̱� ���� ������ ���
		// ������ ��ü ����
		Thread t1 = new Thread(new SumRunnable(1, 2000));
		Thread t2 = new Thread(new SumRunnable(2001, 4000));
		Thread t3 = new Thread(new SumRunnable(4001, 6000));
		Thread t4 = new Thread(new SumRunnable(6001, 8000));
		Thread t5 = new Thread(new SumRunnable(8001, 10000));
	
		// ������ �켱������ �ֻ����� ���� (�����ص� ������ �غ��Ҵ�.)
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MAX_PRIORITY);
		t5.setPriority(Thread.MAX_PRIORITY);

		// ������ ����
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		
			// �ټ����� �����尡 ��� �Ϸ�� ������ ���ξ������ ��ٷ��� �ϹǷ�
			// t1 ~ t5 �� �����尡 ����� ������ ���ξ����带 blocking �Ѵ�.
			
			// join() : ���羲���带 ��� �����尡 ���� ��� ���������� ����Ŵ
			try {
				t1.join();
				t2.join();
				t3.join();
				t4.join();
				t5.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		endTime = System.currentTimeMillis();
		System.out.println("�� �� : " + total);
		System.out.println((endTime - startTime) + " �и��� �ҿ�");
			
	}

}
