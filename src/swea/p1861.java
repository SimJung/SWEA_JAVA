package swea;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class p1861 {
	
	static int[][] arr;
	static int[][] dir= {
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}
	};
	static int N, temp = 0, ans = 0, ansRoom;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(bf.readLine());
			arr = new int[N][N];
			ans = 0;
			ansRoom = N*N*N+1;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(bf.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					temp = 0;
					recur(i, j);
					if(temp > ans) {
						ans = temp;
						ansRoom = arr[i][j];
					}else if(temp == ans && ansRoom > arr[i][j]) {
						ansRoom = arr[i][j];
					}
				}
			}
			System.out.println("#" + tc + " " + ansRoom + " " + ans);
		}
	}
	
	static void recur(int i, int j) {
		int ni, nj;
		temp++;
		for(int k=0; k<4; k++) {
			ni = i + dir[k][0];
			nj = j + dir[k][1];
			if(canGo(ni, nj, arr[i][j])) {
				recur(ni, nj);
			}
		}
		return;
	}
	
	static boolean canGo(int i, int j, int k) {
		if(i >= 0 && i< N && j >= 0 && j<N && arr[i][j] == k+1)
			return true;
		return false;
	}

}
