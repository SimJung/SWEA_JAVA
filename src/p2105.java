import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p2105 {
	public static int N;
	public static boolean visit[] = new boolean[101];
	public static int arr[][];
	public static int delta1[][] = {
			{1, 1},
			{1, -1},
			{-1, -1},
			{-1, 1}
	};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			Arrays.fill(visit, false);
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			
			for(int i=0; i<N-2; i++) {
				for(int j=0; j<N; j++) {
					Arrays.fill(visit, false);
					boolean chk = true;
					int ans = 0;
					for(int d=0; d<4; d++) {
						int ni = i + delta1[d][0];
						int nj = j + delta1[d][1];
					
						if(ni < 0 || ni >= N || nj < 0 || nj >= 0 || visit[arr[ni][nj]]) {
							chk = false;
							break;
						}
						visit[arr[ni][nj]] = true;
						ans++;
					}
					
					if(chk) {
						answer = ans;
						while(true) {
							int ni = i + delta1[d][0];
							int nj = j + delta1[d][1];
						
							if(ni < 0 || ni >= N || nj < 0 || nj >= 0 || visit[arr[ni][nj]]) {
								chk = false;
								break;
							}
						}
					}
				}
			}
			
		}
	}

}
