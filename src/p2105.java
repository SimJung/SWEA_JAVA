import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2105 {
	public static int N, answer;
	public static int arr[][];
	public static boolean visit[] = new boolean[101];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			answer = -1;
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N-2; i++) {
				for(int j=1; j<N-1; j++) {
					visit[arr[i][j]] = true;
					dfs(i+1, j+1, 0, 1, 0, 1);
					visit[arr[i][j]] = false;
				}
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}
	
	
	public static void dfs(int i, int j, int d, int rd, int ld, int cnt) {
		if(d == 3 && ld == 0) {
			answer = (answer < cnt ? cnt : answer);
			return;
		}
		if(i < 0 || i >= N || j < 0 || j >= N || visit[arr[i][j]]) return;
		
		visit[arr[i][j]] = true;
		switch(d) {
		case 0:
			dfs(i+1, j-1, d+1, rd, ld+1, cnt+1);
			dfs(i+1, j+1, d, rd+1, ld, cnt+1);
			break;
			
		case 1:
			dfs(i-1, j-1, d+1, rd-1, ld, cnt+1);
			dfs(i+1, j-1, d, rd, ld+1, cnt+1);
			break;
			
		case 2:
			if(rd == 0) dfs(i-1, j+1, d+1, rd, ld-1, cnt+1);
			else dfs(i-1, j-1, d, rd-1, ld, cnt+1);
			break;
			
		case 3:
			dfs(i-1, j+1, d, rd, ld-1, cnt+1);
			break;
		}
		visit[arr[i][j]] = false;
	}

}
