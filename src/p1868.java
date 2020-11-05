import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class p1868 {
	public static class Info implements Comparable<Info>{
		public int i;
		public int j;
		public Info(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
		public int compareTo(Info info) {
			return arr[i][j] - arr[info.i][info.j];
		}
	}
	public static int N;
	public static char[][] arr;
	public static boolean[][] visit;
	public static PriorityQueue<Info> pq = new PriorityQueue<>();
	public static Queue<Info> q = new LinkedList<>();
	public static int delta[][] = {
			{-1, -1},
			{-1, 0},
			{-1, 1},
			{0, -1},
			{0, 1},
			{1, -1},
			{1, 0},
			{1, 1}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int ans = 0;
			N = Integer.parseInt(br.readLine());
			arr = new char[N][];
			visit = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j] == '.') {
						int mine = 0;
						for(int d=0; d<8; d++) {
							int ni = i + delta[d][0];
							int nj = j + delta[d][1];
							
							if(ni < 0 || ni >= N || nj < 0 || nj >= N) continue;
							if(arr[ni][nj] == '*') mine++;
						}
						arr[i][j] = (char)(mine + '0');
						pq.offer(new Info(i, j));
					}
				}
			}
			
			
			while(!pq.isEmpty()) {
				Info pInfo = pq.poll();
				if(visit[pInfo.i][pInfo.j]) continue;
				
				ans++;
				q.clear();
				visit[pInfo.i][pInfo.j] = true;
				q.offer(pInfo);
				while(!q.isEmpty()) {
					Info info = q.poll();
					
					if(arr[info.i][info.j] == '0') {
						for(int d=0; d<8; d++) {
							int ni = info.i + delta[d][0];
							int nj = info.j + delta[d][1];
							
							if(ni < 0 || ni >= N || nj < 0 || nj >= N || visit[ni][nj] || arr[ni][nj] == '*') continue;
							
							visit[ni][nj] = true;
							if(arr[ni][nj] == '0') q.offer(new Info(ni, nj));
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
}
