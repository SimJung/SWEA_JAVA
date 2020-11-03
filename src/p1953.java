import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1953 {
	public static class Info{
		public int i;
		public int j;
		public Info(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
	public static int N, M, R, C, L, ans;
	public static int arr[][];
	public static boolean visit[][];
	public static Queue<Info> q = new LinkedList<>();
	public static int delta[][][] = {
			{{0, 0}},
			{{-1, 0}, {1, 0}, {0, -1}, {0, 1}},
			{{-1, 0}, {1, 0}},
			{{0, -1}, {0, 1}},
			{{-1, 0}, {0, 1}},
			{{0, 1}, {1, 0}},
			{{1, 0}, {0, -1}},
			{{-1, 0}, {0, -1}}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			ans = 0;
			q.clear();
			
			arr = new int[N][M];
			visit = new boolean[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visit[R][C] = true;
			q.offer(new Info(R, C));
			
			for(int i=0; i<L; i++) {
				int sz = q.size();
				for(int j=0; j<sz; j++) {
					Info info = q.poll();
					ans++;
					for(int d = 0; d<delta[arr[info.i][info.j]].length; d++) {
						int ni = info.i + delta[arr[info.i][info.j]][d][0];
						int nj = info.j + delta[arr[info.i][info.j]][d][1];
						
						if(ni < 0 || ni >= N || nj < 0 || nj >= M || arr[ni][nj] == 0 || visit[ni][nj]) continue;
						
						boolean next = false;
						switch(arr[info.i][info.j]) {
						case 1:
							if(ni != info.i) {
								if(arr[ni][nj] == 3) {
									next = true;
								}
							}
							
							if(nj != info.j) {
								if(arr[ni][nj] == 2) {
									next = true;
								}
							}
							
							if(ni > info.i) {
								if(arr[ni][nj] == 5 || arr[ni][nj] == 6) next = true;
							}
							
							if(ni < info.i) {
								if(arr[ni][nj] == 4 || arr[ni][nj] == 7) next = true;
							}
							
							if(nj > info.j) {
								if(arr[ni][nj] == 4 || arr[ni][nj] == 5) next = true;
							}
							
							if(nj < info.j) {
								if(arr[ni][nj] == 6 || arr[ni][nj] == 7) next = true;
							}
							
							break;
							
						case 2:
							if(arr[ni][nj] == 3) {
								next = true;
							}
							
							if(ni > info.i) {
								if(arr[ni][nj] == 5 || arr[ni][nj] == 6) next = true;
							}
							
							if(ni < info.i) {
								if(arr[ni][nj] == 4 || arr[ni][nj] == 7) next = true;
							}
							
							break;
							
						case 3:
							if(arr[ni][nj] == 2) {
								next = true;
							}
							
							if(nj > info.j) {
								if(arr[ni][nj] == 4 || arr[ni][nj] == 5) next = true;
							}
							
							if(nj < info.j) {
								if(arr[ni][nj] == 6 || arr[ni][nj] == 7) next = true;
							}
							
							break;
							
						case 4:
							if(ni < info.i) {
								if(arr[ni][nj] == 3 || arr[ni][nj] == 4 || arr[ni][nj] == 7) next = true;
							}
							
							if(nj > info.j) {
								if(arr[ni][nj] == 2 || arr[ni][nj] == 4 || arr[ni][nj] == 5) next = true;
							}
							
							break;
						
						case 5:
							if(ni > info.i) {
								if(arr[ni][nj] == 3 || arr[ni][nj] == 5 || arr[ni][nj] == 6) next = true;
							}
							
							if(nj > info.j) {
								if(arr[ni][nj] == 2 || arr[ni][nj] == 4 || arr[ni][nj] == 5) next = true;
							}
							
							break;
						
						case 6:
							if(ni > info.i) {
								if(arr[ni][nj] == 3 || arr[ni][nj] == 5 || arr[ni][nj] == 6) next = true;
							}
							
							if(nj < info.j) {
								if(arr[ni][nj] == 2 || arr[ni][nj] == 6 || arr[ni][nj] == 7) next = true;
							}
							
							break;
						case 7:
							if(ni < info.i) {
								if(arr[ni][nj] == 3 || arr[ni][nj] == 4 || arr[ni][nj] == 7) next = true;
							}
							
							if(nj < info.j) {
								if(arr[ni][nj] == 2 || arr[ni][nj] == 6 || arr[ni][nj] == 7) next = true;
							}
							
							break;
						}
						if(next) continue;
						
						visit[ni][nj] = true;
						q.offer(new Info(ni, nj));
						
					}
				}
			}
			
				
			System.out.println("#"+tc+" "+ans);
		}
	
	}

}
