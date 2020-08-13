

import java.util.Scanner;

public class p10200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tc, n, a, b;
		Scanner sc = new Scanner(System.in);
		tc = sc.nextInt();
		for(int i=1; i<=tc; i++) {
			n = sc.nextInt();
			a = sc.nextInt();
			b = sc.nextInt();
			
			System.out.println("#" + i + " "+(a > b ? b : a) + " " + (a+b-n > 0 ? a+b-n : 0));
		}
	}
}
