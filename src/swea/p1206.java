package swea;

import java.util.Scanner;

public class p1206 {

	public static void main(String[] args) {
		int T;
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int width, ans = 0;
			width = sc.nextInt();
			int buildings[] = new int[width];
			for(int i=0; i<width; i++) {
				buildings[i] = sc.nextInt();
			}
			
			for(int i=0; i<width; i++) {
				int possible = buildings[i]+1;
				for(int j=i-1; j>=i-2 && j>=0; j--) {
					if(buildings[i] > buildings[j]) {
						possible = (possible > buildings[i] - buildings[j] ? buildings[i] - buildings[j] : possible );
					}else {
						possible = buildings[i]+1;
						break;
					}
				}
				
				if(possible != buildings[i]+1) {
					for(int j=i+1; j<=i+2 && j<width; j++) {
						if(buildings[i] > buildings[j]) {
							possible = (possible > buildings[i] - buildings[j] ? buildings[i] - buildings[j] : possible );
						}else {
							possible = buildings[i]+1;
							break;
						}
					}
				}
				
				if(possible != buildings[i]+1) {
					ans += possible;
				}
			}
			
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}
