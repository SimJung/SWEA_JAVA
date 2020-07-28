package swea;

import java.util.Scanner;

public class p1210 {

	public static void main(String[] args) {
		int T;
		Scanner sc = new Scanner(System.in);
		T = 10;
		for(int tc=1; tc<=T; tc++) {
			
			int n;
			n = sc.nextInt();
			int now_i = 99, now_j = 99;
			int ladder[][] = new int[100][100];
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					ladder[i][j] = sc.nextInt();
					if(ladder[i][j] == 2) {
						now_i = i;
						now_j = j;
					}
				}
			}
			
			//1 : 상, 2 : 좌, 3 : 우
			int dir = 1;
			while(now_i != 0) {
				switch(dir) {
				case 1:
					if(now_j-1 >= 0 && ladder[now_i][now_j-1] == 1) {
						dir = 2;
						now_j--;
					}else if(now_j+1 < 100 && ladder[now_i][now_j+1] == 1) {
						dir = 3;
						now_j++;
					}else
						now_i--;
					break;
					
				case 2:
					if(now_j-1 >= 0 && ladder[now_i][now_j-1] == 1) {
						now_j--;
					}else {
						dir = 1;
						now_i--;
					}
					break;
				
				case 3:
					if(now_j+1 < 100 && ladder[now_i][now_j+1] == 1) {
						now_j++;
					}else {
						dir = 1;
						now_i--;
					}
					break;
				}
			}
			
			
			System.out.println("#" + tc + " " + now_j);
		}
	}

}
