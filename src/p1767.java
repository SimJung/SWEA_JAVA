import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p1767 {
	static int N, connect, ans;
	static boolean[][] visit;
	static ArrayList<int[]> coreList = new ArrayList<>();
	static int[][] delta = {
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			visit = new boolean[N][N];
			coreList.clear();
			connect = 0;
			ans = 0;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					if(st.nextToken().equals("1")){
						visit[i][j] = true;
						if(i > 0 && i < N-1 && j > 0 && j < N-1) coreList.add(new int[] {i, j});
							
					}
				}
			}
			
			dfs(0, 0, 0);
			//System.out.println("코어 수 : "+connect);
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	
	public static void dfs(int idx, int currentCore, int cable) {
		if(idx == coreList.size()) {
			if(currentCore > connect) {
				//System.out.println("코어 수 : "+currentCore);
				//System.out.println("전선 길이 : "+cable);
				connect = currentCore;
				ans = cable;
			}else if(currentCore == connect && ans > cable) {
				//System.out.println("코어 수 : "+currentCore);
				//System.out.println("전선 길이 : "+cable);
				ans = cable;
			}
			return;
		}else {
			if(currentCore + (coreList.size()-idx) < connect) return;
			dfs(idx+1, currentCore, cable);
			for(int d=0; d<4; d++) {
				int ni = coreList.get(idx)[0] + delta[d][0];
				int nj = coreList.get(idx)[1] + delta[d][1];
				int wire = 0;
				
				while(ni >= 0 && ni < N && nj >= 0 && nj < N && !visit[ni][nj]) {
					visit[ni][nj] = true;
					wire++;
					ni += delta[d][0];
					nj += delta[d][1];
				}
				
				if(ni < 0 || ni >= N || nj < 0 || nj >= N) {
					dfs(idx+1, currentCore+1, cable+wire);
					while(wire-- > 0) {
						ni -= delta[d][0];
						nj -= delta[d][1];
						visit[ni][nj] = false;
					}
				}
				else {
					while(wire-- > 0) {
						ni -= delta[d][0];
						nj -= delta[d][1];
						visit[ni][nj] = false;
					}
				}
			}
		}
	}
}