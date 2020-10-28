import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p4014 {
	public static int arr[][] = new int[21][21];
	public static boolean used[] = new boolean[21];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int ans=0, N, X;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//가로에 대해서 케이스 구하기
			for(int i=0; i<N; i++) {
				boolean canMake = true;
				int h = arr[i][0];
				Arrays.fill(used, false);
				for(int j=0; j<N; j++) {
					if(h != arr[i][j]) {
						if(h>arr[i][j]) {
							if(h > arr[i][j]+1) {
								canMake = false;
								break;
							}else {
								h--;
								for(int k=j; k<j+X; k++) {
									if(k >= N || arr[i][k] != h || used[k]) {
										canMake = false;
										break;
									}else {
										used[k] = true;
									}
								}
							}
						}else {
							if(h < arr[i][j]-1) {
								canMake = false;
								break;
							}else {
								h++;
								for(int k=j-1; k>=j-X; k--) {
									if(k < 0 || arr[i][k] != h-1 || used[k]) {
										canMake = false;
										break;
									}else {
										used[k] = true;
									}
								}
							}
						}
					}
					if(!canMake) break;
				}
				if(canMake) ans++;
			}
			
			//세로에 대해서 케이스 구하기
			for(int i=0; i<N; i++) {
				boolean canMake = true;
				int h = arr[0][i];
				Arrays.fill(used, false);
				for(int j=0; j<N; j++) {
					if(h != arr[j][i]) {
						if(h>arr[j][i]) {
							if(h > arr[j][i]+1) {
								canMake = false;
								break;
							}else {
								h--;
								for(int k=j; k<j+X; k++) {
									if(k >= N || arr[k][i] != h || used[k]) {
										canMake = false;
										break;
									}else {
										used[k] = true;
									}
								}
							}
						}else {
							if(h < arr[j][i]-1) {
								canMake = false;
								break;
							}else {
								h++;
								for(int k=j-1; k>=j-X; k--) {
									if(k < 0 || arr[k][i] != h-1 || used[k]) {
										canMake = false;
										break;
									}else {
										used[k] = true;
									}
								}
							}
						}
					}
					if(!canMake) break;
				}
				if(canMake) ans++;
			}
			
			
			System.out.println("#"+tc+" " + ans);
		}
	}

}
