package swea;
import java.util.Scanner;
public class p4301 {
	static boolean visit[][];
	static int N, M, ans;
	static int dir[][] = {
			{0, -2},
			{0, 2},
			{-2, 0},
			{2, 0}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			ans = N*M;
			visit = new boolean[M][N];
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(!visit[i][j]) {
						for(int k=0; k<4; k++) {
							int ni = i + dir[k][0];
							int nj = j + dir[k][1];
							if(ni >= M || ni < 0 || nj >= N || nj < 0 || visit[ni][nj])
								continue;
							
							visit[ni][nj] = true;
							ans--;
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
