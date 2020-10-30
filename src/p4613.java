import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p4613 {
	public static int arr[][], N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder("");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int ans = Integer.MAX_VALUE, sum = 0;
			arr = new int[N][3];
			for (int i = 0; i < N; i++) {
				sb.append(br.readLine());

				for (int j = 0; j < M; j++) {
					switch (sb.charAt(j)) {
					case 'W':
						arr[i][1]++;
						arr[i][2]++;
						break;

					case 'B':
						arr[i][0]++;
						arr[i][2]++;
						break;

					case 'R':
						arr[i][0]++;
						arr[i][1]++;
						break;
					}
				}

				sb.delete(0, sb.length());
			}
			
			
			for(int b=1; b<N-1; b++) {
				for(int r=b+1; r<N; r++) {
					sum = 0;
					for(int i=0; i<b; i++) {
						sum += arr[i][0];
					}
					
					for(int i=b; i<r; i++) {
						sum += arr[i][1];
					}
					
					for(int i=r; i<N; i++) {
						sum += arr[i][2];
					}
					
					if(ans > sum) ans = sum;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}

}
