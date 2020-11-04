import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p5643 {
	public static final int MAX = 10000000;
	public static int N, M, nowVal;
	public static int dist[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			dist = new int[N+1][N+1];
			
			for(int i=1; i<=N; i++) {
				dist[i] = new int[N+1];
				Arrays.fill(dist[i], MAX);
				dist[i][i] = 0;
			}
			
			for(int i=0; i<M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				dist[from][to] = 1;
				dist[to][from] = 1;
			}
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					for(int k=1; k<=N; k++) {
						if(dist[j][k] > dist[j][i] + dist[i][k]) {
							dist[j][k] = dist[j][i] + dist[i][k];
						}
					}
				}
			}
			
			int answer = 0;
			for(int i=1; i<=N; i++) {
				boolean isOk = true;
				for(int j=1; j<=N ;j++) {
					if(i == j) continue;
					if(dist[i][j] == MAX) {
						isOk = false;
						break;
					}
				}
				if(isOk) answer++;
			}
			
			System.out.println("#"+tc+" "+answer);
		}
	}

}
