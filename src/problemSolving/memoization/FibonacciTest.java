package problemSolving.memoization;

public class FibonacciTest {
	public static void main(String[] args){
		Fibonacci fibo = new Fibonacci();
		System.out.println("Fibonacii series without memoization...10 terms");
		for(int i=1;i<=10;i++){
			System.out.println(fibo.fiboWithoutMemo(i));
		}
		
		System.out.println("Fibonacii series with memoization...10 terms");
		for(int i=1;i<=10;i++){
			System.out.println(fibo.fiboWithMemoization(i));
		}
	}
}
