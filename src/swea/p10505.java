package swea;

import java.util.Scanner;

public class p10505 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int N, sum = 0, ans = 0;
			N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			
			for(int i=0; i<N; i++) {
				if(arr[i] <= (double)sum / N) {
					ans++;
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

}
