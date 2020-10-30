import java.util.Scanner;

public class p4796 {
	static int N, start;
	static int arr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int ans = 0, upper_num=0, lower_num=0;
			boolean end = false;
			start = 0;
			
			while(!end) {
				for(int i=start; i<N; i++) {
					if(i == N-1) {
						end = true;
						break;
					}else {
						if(arr[i] > arr[i+1]) {
							upper_num = i - start;
							start = i;
							break;
						}
					}
				}
				
				if(end) break;
				
				for(int i=start; i<N; i++) {
					if(i == N-1) {
						if(arr[i] < arr[i-1]) {
							lower_num = i - start;
						}else {
							lower_num = i - start - 1;
						}
						end = true;
						break;
					}else {
						if(arr[i] < arr[i+1]) {
							lower_num = i - start;
							start = i;
							break;
						}
					}
				}
				
				ans += upper_num * lower_num;
				upper_num = 0;
				lower_num = 0;
			}
			
			
			System.out.println("#"+tc+" "+ans);
		}
	}

}
