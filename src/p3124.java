
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
public class p3124 {

	static int[] parents;
	static class Edge{
		public int from;
		public int to;
		public int weight;
		
		Edge(int f, int t, int w){
			from = f;
			to = t;
			weight = w;
		}
	}
	
	static class EdgeCompare implements Comparator<Edge>{
		public int compare(Edge e1, Edge e2) {
			return e1.weight - e2.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bf.readLine());
		
		for(int tc = 1; tc<=T; tc++) {
			int v, e;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			ArrayList<Edge> edgeList = new ArrayList<Edge>();
			
			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			parents = new int[v+1];
			
			for(int i=0; i<e; i++) {
				int f, t, w;
				st = new StringTokenizer(bf.readLine());
				f = Integer.parseInt(st.nextToken());
				t = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				edgeList.add(new Edge(f, t, w));
			}
			
			Collections.sort(edgeList, new EdgeCompare());
			make(v);
			
			int cnt = 0;
			long ans = 0;
			for(int i=0; i<edgeList.size(); i++) {
				if(union(edgeList.get(i).from, edgeList.get(i).to)) {
					cnt++;
					ans += edgeList.get(i).weight;
					if(cnt == v-1)
						break;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	
	static void make(int v) {
		for(int i=1; i<=v; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		
		if(rootX == rootY) return false;
		if(rootX > rootY) {
			parents[rootX] = rootY;
		}else {
			parents[rootY] = rootX;
		}
			
		
		return true;
	}

}
