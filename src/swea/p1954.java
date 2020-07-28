package swea;
import java.util.Scanner;
public class p1954 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			int N;
			N = sc.nextInt();
			int arr[][] = new int[N][N];
			
			int now_i = 0, now_j = 0, dir = 0, val = 1;
			boolean end = false;
			while(!end) {
				arr[now_i][now_j] = val++;
				switch(dir) {
				case 0:	// 오른쪽
					if(now_j+1 < N && arr[now_i][now_j+1] == 0) {
						now_j++;
					}else if(now_i+1 < N && arr[now_i+1][now_j] == 0){
						dir = 1; 
						now_i++;
					}else {
						end = true;
						break;
					}
					break;
					
					
				case 1:	// 아래
					if(now_i+1 < N && arr[now_i+1][now_j] == 0) {
						now_i++;
					}else if(now_j-1 >= 0 && arr[now_i][now_j-1] == 0){
						dir = 2; 
						now_j--;
					}else {
						end = true;
						break;
					}
					break;
					
					
				case 2: // 왼쪽
					if(now_j-1 >= 0 && arr[now_i][now_j-1] == 0) {
						now_j--;
					}else if(now_i-1 >= 0 && arr[now_i-1][now_j] == 0){
						dir = 3; 
						now_i--;
					}else {
						end = true;
						break;
					}
					break;
					
					
				case 3: // 위
					if(now_i-1 >= 0 && arr[now_i-1][now_j] == 0) {
						now_i--;
					}else if(now_j+1 < N && arr[now_i][now_j+1] == 0){
						dir = 0; 
						now_j++;
					}else {
						end = true;
						break;
					}
					break;
				}
			}
			System.out.println("#" + tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
