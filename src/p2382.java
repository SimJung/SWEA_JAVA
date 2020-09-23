import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class p2382 {
	static class Cluster{
		public int i;
		public int j;
		public int num;
		public int d;
		public Cluster(int i, int j, int num, int d) {
			this.i = i;
			this.j = j;
			this.num = num;
			this.d = d;
		}
	}
	static int N, M, K, ans;
	static ArrayList<Cluster> clusters = new ArrayList<>();
	static int[][] delta = {
			{-1, 0},
			{1, 0},
			{0, -1},
			{0, 1}
	};
	
	static ArrayList<Cluster>[][] cArr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			clusters.clear();
				cArr = new ArrayList[N][N];
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						cArr[i][j] = new ArrayList<>();
					}
				}
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int ni = Integer.parseInt(st.nextToken());
				int nj = Integer.parseInt(st.nextToken());
				int nNum = Integer.parseInt(st.nextToken());
				int nd = Integer.parseInt(st.nextToken())-1;
				Cluster c = new Cluster(ni, nj, nNum, nd);
				
				clusters.add(c);
				cArr[ni][nj].add(c);
			}
			
			while(M-- > 0) {
				//show();
				play();
			}
			//show();
			ans = 0;
			for(int i=0; i<clusters.size(); i++) ans+=clusters.get(i).num;
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static void play() {
		for(Cluster c : clusters) {
			int before_i = c.i;
			int before_j = c.j;
			cArr[before_i][before_j].remove(c);
			
			int ni = c.i + delta[c.d][0];
			int nj = c.j + delta[c.d][1];
			
			if(ni == 0 || ni == N-1 || nj == 0 || nj == N-1) {
				c.num /= 2;
				c.d = (c.d == 0 || c.d == 2 ? c.d+1 : c.d-1);
			}
			
			if(c.num > 0) {
				c.i = ni;
				c.j = nj;
				cArr[ni][nj].add(c);
			}
			else
				clusters.remove(c);
		}
		
		for(int i=1; i<N-1; i++) {
			for(int j=1; j<N-1; j++) {
				if(cArr[i][j].size() > 1) {
					int maxNum = 0;
					int sum = 0;
					
					for(int k=0; k<cArr[i][j].size(); k++) {
						sum += cArr[i][j].get(k).num;
						if(maxNum < cArr[i][j].get(k).num) maxNum = cArr[i][j].get(k).num;
					}
					
					for(int k=0; k<cArr[i][j].size(); k++) {
						if(cArr[i][j].get(k).num == maxNum) cArr[i][j].get(k).num = sum;
						else {
							clusters.remove(cArr[i][j].get(k));
							cArr[i][j].remove(k);
							k--;
						}
					}
				}
			}
		}
	}
	
	public static void clearcArr() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				cArr[i][j].clear();
			}
		}
	}
	
	public static void show() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(cArr[i][j].size() > 0) {
					int sum = 0;
					for(int k=0; k<cArr[i][j].size(); k++) {
						sum += cArr[i][j].get(k).num;
					}
					System.out.print(sum+" ");
				}else System.out.print("0 ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
