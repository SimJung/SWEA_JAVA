import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4012 {
	static boolean[] use;
	static int N, ans, arr[][];
	static int comb[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr= new int[N][N];
			comb = new int[N/2];
			use = new boolean[N];
			ans = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			getComb(0, 0);
			System.out.println("#"+tc+" "+ans);
		}
	}

	public static void getComb(int cnt, int idx) {
		if(cnt == N/2) {
			int[] foodA = new int[N/2];
			int[] foodB = new int[N/2];
			for(int i=0; i<N/2; i++) {
				use[comb[i]] = true;
			}
			
			int aIdx = 0;
			int bIdx = 0;
			for(int i=0; i<N; i++) {
				if(use[i]) foodA[aIdx++] = i;
				else foodB[bIdx++] = i;
			}
			
			int tasteA = 0, tasteB = 0;
			for(int i=0; i<N/2; i++) {
				for(int j=i+1; j<N/2; j++) {
					tasteA += arr[foodA[i]][foodA[j]] + arr[foodA[j]][foodA[i]];
					tasteB += arr[foodB[i]][foodB[j]] + arr[foodB[j]][foodB[i]];
				}
			}
			int res = Math.abs(tasteA - tasteB);
			if(ans > res) ans = res;
			
			for(int i=0; i<N/2; i++) {
				use[comb[i]] = false;
			}
		}else {
			for(int i=idx; i<N; i++) {
				comb[cnt] = i;
				getComb(cnt+1, i+1);
			}
		}
	}
}
