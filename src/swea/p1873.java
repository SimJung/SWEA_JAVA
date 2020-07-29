package swea;

import java.util.Scanner;

public class p1873 {
	
	static int dir[][] = {
			{-1, 0},	//상
			{1, 0},		//하
			{0, -1},	//좌
			{0, 1}		//우
	};
	
	static String tank = "^v<>";
	
	public static void main(String[] args) {
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int H, W, now_i=0, now_j=0, now_d=0;
			H = sc.nextInt();
			W = sc.nextInt();
			char maps[][] = new char[H][W];
			
			for(int i=0; i<H; i++) {
				String s;
				s = sc.next();
				for(int j=0; j<W; j++) {
					maps[i][j] = s.charAt(j);
					switch(maps[i][j]) {
					case '<':
						now_d = 2;
						now_i = i;
						now_j = j;
						break;
						
					case '>':
						now_d = 3;
						now_i = i;
						now_j = j;
						break;
						
					case '^':
						now_d = 0;
						now_i = i;
						now_j = j;
						break;
						
					case 'v':
						now_d = 1;
						now_i = i;
						now_j = j;
						break;
						
					}
				}
			}
			
			int clen;
			clen = sc.nextInt();
			String command;
			command = sc.next();
			
			for(int i=0; i<command.length(); i++) {
				if(command.charAt(i) == 'S') {
					int bi = now_i;
					int bj = now_j;
					while(true) {
						bi += dir[now_d][0];
						bj += dir[now_d][1];
						
						if(bi < 0 || bi >= H || bj < 0 || bj >= W || maps[bi][bj] == '#')
							break;
						
						if(maps[bi][bj] == '.')
							continue;
						
						if(maps[bi][bj] == '*') {
							maps[bi][bj] = '.';
							break;
						}
					}
				}else {
					switch(command.charAt(i)) {
					case 'U':
						now_d = 0;
						break;
						
					case 'D':
						now_d = 1;
						break;
						
					case 'L':
						now_d = 2;
						break;
						
					case 'R':
						now_d = 3;
						break;
					}
					
					int ni = now_i + dir[now_d][0];
					int nj = now_j + dir[now_d][1];
					maps[now_i][now_j] = tank.charAt(now_d);
					
					if(ni >= 0 && ni < H && nj >= 0 && nj < W && maps[ni][nj] == '.') {
						maps[now_i][now_j] = '.';
						maps[ni][nj] = tank.charAt(now_d);
						
						now_i += dir[now_d][0];
						now_j += dir[now_d][1];
					}
				}
				
				/*
				System.out.println(command.charAt(i));
				for(int k=0; k<H; k++) {
					for(int j=0; j<W; j++) {
						System.out.print(maps[k][j]);
					}
					System.out.println();
				}
				System.out.println();
				*/
			}
			
			
			System.out.print("#" + tc + " ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					System.out.print(maps[i][j]);
				}
				System.out.println();
			}
		}
	}
}
