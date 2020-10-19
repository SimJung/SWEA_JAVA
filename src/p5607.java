import java.util.Scanner;

public class p5607 {
	public static final int M = 1234567891; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc=1; tc<=T ;tc++) {
			int n = sc.nextInt();
			int r = sc.nextInt();
			
			System.out.println("#"+tc+" "+combination(n, r));
		}
	}
	
	
	public static long power(long n, long r) {
		if(r == 0) return 1;
		
		long answer = 1;
		if(r%2 == 1) answer *=n;
		
		return answer * power(n*n%M, r/2%M)%M;
	}
	
	public static long combination(int n, int r) {
		long a = 1;
		long b = 1;
		for(int i=1; i<=n; i++) {
			a *= i%M;
			a %= M;
			if(i <= n-r) {
				b *= i%M;
				b %= M;
			}
			if(i <= r) {
				b *= i%M;
				b %= M;
			}
		}
		long realB = power(b, M-2)%M;
		
		return ((a%M)*(realB%M)%M);
		
	}

}
