package swea;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class p3289 {
	static int parent[];
	static String ans = "";
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			ans = "";
			parent = new int[n+1];
			for(int i=1; i<=n; i++) {
				parent[i] = i;
			}
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(bf.readLine());
				int cmd = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(cmd == 0) union(a, b);
				else isSameSet(a, b);
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static int find(int n) {
		if(parent[n] == n)	return n;
		return parent[n] = find(parent[n]);
	}
	
	public static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
		
		if(aRoot > bRoot)
			parent[aRoot] = bRoot;
		else
			parent[bRoot] = aRoot;
	}
	
	public static void isSameSet(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) ans += "1";
		else ans += "0";
	}

}
