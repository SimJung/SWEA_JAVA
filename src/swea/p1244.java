package swea;

import java.util.Scanner;

public class p1244 {

	public static void main(String[] args) {
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			String numstr = sc.next();
			int change = sc.nextInt();
			
			int idx = 0;
			for(int i=0; i<change; i++) {
				char biggest = '0';
				while(true) {
					for(int j=idx; j<numstr.length(); j++) {
						if(biggest < numstr.charAt(j)) {
							biggest = numstr.charAt(j);
						}
					}
					
					if(biggest == numstr.charAt(idx))
						idx++;
					else
						break;
					
					if(idx >= numstr.length())
						break;
				}
				
				if(idx >= numstr.length()) {
					//남은 횟수 짝수, 홀수, 숫자 같을 때
				}else {
					char temp = numstr.charAt(idx);
					numstr.charAt(idx) = biggest;
					
				}
				
			}
			
			
			
			
			
			System.out.println("#" + tc + " ");
		}
	}

}
