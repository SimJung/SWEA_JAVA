package swea;
import java.util.Scanner;
public class p9229 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int ans = -1;
			int N = sc.nextInt(), M = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0; i<N; i++)
				arr[i] = sc.nextInt();
			
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					if(arr[i]+arr[j] > M)
						continue;
					
					if(arr[i]+arr[j] > ans)
						ans = arr[i]+arr[j];
				}
			}
			
			
			
			
			
			
			System.out.println("#" + tc + " "+ans);
		}
	}

}
