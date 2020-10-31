import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p1249 {
	public static class Info{
		public int i;
		public int j;
		public int cnt;
		public Info(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
		
	}
	public static int arr[][] = new int[101][101];
	public static int visit[][] = new int[101][101];
	public static Queue<Info> q = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();
	public static int delta[][] = {
			{0, 1},
			{0, -1},
			{-1, 0},
			{1, 0}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			for(int i=0; i<N; i++) {
				sb.delete(0, sb.length());
				sb.append(br.readLine());
				
				for(int j=0; j<N; j++) {
					visit[i][j] = Integer.MAX_VALUE;
					arr[i][j] = sb.charAt(j) - '0';
				}
			}
			
			visit[0][0] = 0;
			q.offer(new Info(0, 0, 0));
			
			while(!q.isEmpty()) {
				Info now = q.poll();
				
				
				for(int d=0; d<4; d++) {
					int ni = now.i + delta[d][0];
					int nj = now.j + delta[d][1];
					if(ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
					
					int nc = now.cnt + arr[ni][nj];
					if(nc >= visit[ni][nj]) continue;
					
					visit[ni][nj] = nc;
					q.offer(new Info(ni, nj, nc));
				}
			}
			
			System.out.println("#"+tc+" "+visit[N-1][N-1]);
			
		}
	}

}
