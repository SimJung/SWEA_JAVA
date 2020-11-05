import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class p2115 {
	public static int N, M, C, h1, h2, ans;
	public static int arr[][];
	public static int b1[];
	public static int b2[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			h1 = 0;
			h2 = 0;
			ans = 0;
			
			arr = new int[N][N];
			b1 = new int[M];
			b2 = new int[M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int bi=0; bi<N; bi++) {
				for(int bj=0; bj<=N-M; bj++) {
					for(int bk=bj; bk<bj+M; bk++) {
						b1[bk-bj] = arr[bi][bk];
					}
					h1 = getMaxHoney(b1);
					
					for(int ci=bi; ci<N; ci++) {
						for(int cj=0; cj<=N-M; cj++) {
							if(ci == bi) cj += bj+M;
							if(ci == bi && cj > N-M) break;
							
							for(int ck=cj; ck<cj+M; ck++) {
								b2[ck-cj] = arr[ci][ck];
							}
							
							h2 = getMaxHoney(b2);
							
							if(h1 + h2 > ans) ans = h1+h2;
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static int getMaxHoney(int[] honey) {
		int flag = 1 << M;
		int sum=0, ans = 0, ret = 0;
		for(int i=1; i<flag; i++) {
			sum = 0;
			ans = 0;
			
			for(int j=0; j<M; j++) {
				if((i & (1<<j)) != 0) {
					sum += honey[j];
					ans += honey[j]*honey[j];
				}
			}
			
			if(sum > C) continue;
			if(ans > ret) ret = ans;
		}
		
		return ret;
	}
}
