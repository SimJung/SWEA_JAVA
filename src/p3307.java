import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class p3307 {
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int size = 0;
		for(int i=0; i<N; i++) {
			// 찾으면 인덱스 반환, 못 찾으면 음수값으로 자신이 삽입될 위치(-1)
			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);
			temp = Math.abs(temp)-1;
			LIS[temp] = arr[i];
			
			if(temp == size) {
				size++;
			}
		}
		System.out.println(size);
	}
	/*
	public static int arr[], dp[], N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			dp = new int[N];
			
			int ans = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				for(int j=0; j<=i; j++) {
					if(dp[j] == 0) {
						ans++;
						dp[j] = arr[i];
						break;
					}else if(dp[j] > arr[i]) {
						dp[j] = arr[i];
						break;
					}
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	*/

}
