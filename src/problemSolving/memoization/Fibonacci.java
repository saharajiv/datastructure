package problemSolving.memoization;

public class Fibonacci {
	
	int memo[] = new int[100];
	
	public int fiboWithoutMemo(int n){
		if(n==1 || n==2){
			return 1;
		}
		return fiboWithoutMemo(n-1)+fiboWithoutMemo(n-2);
		
	}
	
	public int fiboWithMemoization(int n){
		int result = 0;
		if(memo[n-1] != 0){
			return memo[n-1];
		}else if(n==1 || n==2){
			result =1;
		}else{
			result= fiboWithMemoization(n-1)+fiboWithMemoization(n-2);
		}
		memo[n-1]=result;
		return memo[n-1];
	}
	
	public int[] fibonacciSeriesWithMemo(int n){
		int memo[] = new int[n+1];
		for(int i = 1;i<=n;i++){
			calculateFiboNumber(n,memo);
		}
		return memo;
		
	}
	
	
	
	
	private int calculateFiboNumber(int n,int[]memo){
		int fibo =0;
		if(memo[n]!=0){
			return memo[n];
		}else{
			if(n==1 || n==2)
				return 1;
		}
		fibo = calculateFiboNumber(n-1, memo)+calculateFiboNumber(n-2, memo);
		return fibo;
	}

}
