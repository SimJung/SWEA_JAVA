
import java.util.Scanner;
public class p1954 {
	
	//Loop
	
	static int N;
	static int arr[][];
	static int now_i = 0, now_j = 0;
	static int dir[][] = {
			{0, 1},
			{1, 0},
			{0, -1},
			{-1, 0}
	};
	public static void main(String[] args) {
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			N = sc.nextInt();
			arr = new int[N][N];
			
			int d = 0, val = 1;
			now_i = 0;
			now_j = 0;
			while(true) {
				arr[now_i][now_j] = val++;
				
				int dx = dir[d][0];
				int dy = dir[d][1];
				
				int ndx = dir[(d+1)%4][0];
				int ndy = dir[(d+1)%4][1];
				
				if(canGo(now_i + dx, now_j + dy)) {
					now_i += dx;
					now_j += dy;
				}
				else if(canGo(now_i + ndx, now_j + ndy)) {
					now_i += ndx;
					now_j += ndy;
					d = (d+1)%4;
				}else
					break;
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
	
	
	public static boolean canGo(int i, int j) {
		if(i >= 0 && i < N && j>=0 && j<N && arr[i][j] == 0)
			return true;
		return false;
	}
	
	
	
	
	/*
	//Recursive
	static int N;
	static int arr[][];
	static int now_i = 0, now_j = 0;
	static int[][] dir = {
			{0, 1},
			{1, 0},
			{0, -1},
			{-1, 0}
	};
	public static void main(String[] args) {
		int T;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			
			N = sc.nextInt();
			arr = new int[N][N];
			
			recur(0, 0, 0, 1);
			
			System.out.println("#" + tc);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	
	public static void recur(int i, int j, int d, int val) {
		if(i >= 0 && i<N && j >= 0 && j<N)
			arr[i][j] = val;
		
		if(canGo(i+dir[d][0], j+dir[d][1])) {
			recur(i+dir[d][0], j+dir[d][1], d, val+1);
		}else if(canGo(i+dir[(d+1)%4][0], j+dir[(d+1)%4][1])) {
			recur(i+dir[(d+1)%4][0], j+dir[(d+1)%4][1], (d+1)%4, val+1);
		}else
			return;
	}
	
	public static boolean canGo(int i, int j) {
		if(i<N && i>=0 && j>=0 && j < N && arr[i][j] == 0)
			return true;
		return false;
	}
	*/
	
}
