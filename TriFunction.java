package proj02;


/*
 * 2. 위의 문제 1번과 동일한 결과를 출력하는 공학용 계산기 EngCal을 만들고자 한다. 
 * 공학용 계산기는 사칙연산 외에 삼각함수 값을 구하는 sin(), cos() 그리고 tan() 연산을 추가로 가진다. 
 * 단 아래 주어진 TriFunction이라는 인터페이스를 사용하여야 하며, 사칙연산은 앞의 과제 1-1의 SimpleCal 클래스를 상속받아 작성한다. 

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
