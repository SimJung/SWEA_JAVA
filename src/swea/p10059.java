package swea;

import java.util.Scanner;

public class p10059 {
	public static void main(String[] args) {
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			String str, ans = "NA";
			str = sc.next();
			
			int f = Integer.parseInt(str.substring(0, 2));
			int e = Integer.parseInt(str.substring(2, 4));
			
			if(f < 13 && e < 13 && f > 0 && e > 0)
				ans = "AMBIGUOUS";
			else if(f < 13 )
				ans = "MMYY";
			else if(e < 13)
				ans = "YYMM";
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
