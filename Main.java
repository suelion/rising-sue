package proj03;

// 멀티 스레드 방법
// 방법1. Thread 상속클래스를 만들어서   				=> Thread.run()
// 방법2. Runnable 구현클래스를 만들어서 Thread로 포장	=> Thread.run()
class SumRunnable implements Runnable {
	
	// 각 스레드가 가져야 할 시작 수와 끝 수
	private long n1, n2;

	
	// 생성자
	public SumRunnable(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}

	@Override 
	public void run() { // Runnable이 물려준 run() 오버라이드

		// 앞 수가 클 경우 두 수를 뒤바꾼다. 
		if (n1 > n2) {
			long tmp = n1;
			n1 = n2;
			n2 = tmp;
		}

		// 총합을 구한다. 
		long sum = 0;
		for (long i = n1; i <= n2; ++i) {
			sum += i;
		}
		
		// Main 클래스의 static 메서드 updateTotal()을 호출하여 결과값을 전달한다.
		// 이때 updateTotal()은 동기 메서드이므로 5개의 쓰레드가 동시에 이를 호출하더라도
		// 한 쓰레드씩 순차적으로 해당 메서드를 사용하게 된다.
		Main.updateTotal(sum);
	}
}

public class Main {
	
	// total 은 private (외부에서 접근불가, 단 updateTotal()을 통해서 누적은 가능하다.)
	// 큰 정수도 테스트하기 위해 long으로 선언해보았다.
	private static long total;

	// updateTotal() 는 1개의 쓰레드만 접근 가능하다. (synchronized, 동기화 적용)
	// ==> 다른 쓰레드는 대기, 앞선 쓰레드의 사용이 완료되어야 사용 가능
	synchronized public static void updateTotal(long num) {
		Main.total += num;
	}

	public static void main(String[] args) {

		// 시작 시간과 종료 시간을 재보았다.
		// 1 ~ 10000 까지는 싱글스레드가 수행시간이 더 짧았지만
		// 1 ~ 1000000000 의 경우에는 멀티스레드의 수행시간이 더 짧았다.
		long startTime = System.currentTimeMillis();
		long endTime;
		
		// 싱글 스레드 : 305 밀리초
//		for(int i = 0; i <= 1000000000; ++i) {
//			total += i;
//		}
		
		
		// 멀티 스레드 : 167 밀리초
//		Thread t1 = new Thread(new SumRunnable(1, 200000000));
//		Thread t2 = new Thread(new SumRunnable(200000001, 400000000));
//		Thread t3 = new Thread(new SumRunnable(400000001, 600000000));
//		Thread t4 = new Thread(new SumRunnable(600000001, 800000000));
//		Thread t5 = new Thread(new SumRunnable(800000001, 1000000000));

		// 배열로도 구현 가능하지만 가독성을 높이기 위해 변수를 사용
		// 스레드 객체 생성
		Thread t1 = new Thread(new SumRunnable(1, 2000));
		Thread t2 = new Thread(new SumRunnable(2001, 4000));
		Thread t3 = new Thread(new SumRunnable(4001, 6000));
		Thread t4 = new Thread(new SumRunnable(6001, 8000));
		Thread t5 = new Thread(new SumRunnable(8001, 10000));
	
		// 스레드 우선순위를 최상위로 설정 (생략해도 되지만 해보았다.)
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t3.setPriority(Thread.MAX_PRIORITY);
		t4.setPriority(Thread.MAX_PRIORITY);
		t5.setPriority(Thread.MAX_PRIORITY);

		// 스레드 실행
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		
			// 다섯개의 스레드가 모두 완료될 때까지 메인쓰레드는 기다려야 하므로
			// t1 ~ t5 의 스레드가 종료될 때까지 메인쓰레드를 blocking 한다.
			
			// join() : 현재쓰레드를 대상 쓰레드가 일을 모두 끝낼때까지 대기시킴
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
		System.out.println("총 합 : " + total);
		System.out.println((endTime - startTime) + " 밀리초 소요");
			
	}

}
