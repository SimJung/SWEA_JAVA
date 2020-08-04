package swea;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
public class p1238 {
	static boolean[][] arr;
	static boolean[] visit;
	static int[] cnt;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int maxVal = 0, ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc<=10; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int N = Integer.parseInt(st.nextToken()), start = Integer.parseInt(st.nextToken());
			maxVal = 0;
			ans = 0;
			st = new StringTokenizer(bf.readLine());
			
			arr = new boolean[101][101];
			visit = new boolean[101];
			cnt = new int[101];
			q.clear();
			
			for(int i=0; i<N/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				arr[from][to] = true;
			}
			
			bfs(start);
			
			System.out.println("#"+tc+" "+ans);
		}
	}

	public static void bfs(int start) {
		q.offer(start);
		visit[start] = true;
		cnt[start]++;
		
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int i=0; i<101; i++) {
				if(arr[num][i]&& !visit[i]) {
					cnt[i] = cnt[num]+1;
					if(maxVal < cnt[i]) {
						maxVal = cnt[i];
						ans = i;
					}else if(maxVal == cnt[i] && ans < i)
						ans = i;
						
					q.offer(i);
					visit[i] = true;
				}
			}
		}
	}
}
