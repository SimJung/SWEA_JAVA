

import java.util.Scanner;

public class p1289 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int ans = 0;
			boolean now_bit = false;
			String str;
			str = sc.next();
			
			
			for(int i=0; i<str.length(); i++) {
				boolean chk = (str.charAt(i) == '0' ? false : true);
				if(now_bit != chk) {
					ans++;
					now_bit = !now_bit;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}

}
