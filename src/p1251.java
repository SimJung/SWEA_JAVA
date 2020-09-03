import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p1251 {
	static class Edge implements Comparable<Edge>{
		public int to;
		public double dist;
		public Edge(int to, double dist) {
			this.to = to;
			this.dist = dist;
		}
		public int compareTo(Edge e) {
			if(dist>e.dist) return 1;
			if(dist==e.dist) return 0;
			else return -1;
		}
	}
	static int N;
	static int[][] arr;
	static boolean[] visit;
	static double E, ans;
	static ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
	static PriorityQueue<Edge> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][2];
			visit = new boolean[N];
			ans = 0;
			edges.clear();
			pq.clear();
			for(int j=0; j<2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int i=0; i<N; i++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(j == 0) edges.add(new ArrayList<>());
				}
			}
			E = Double.parseDouble(br.readLine());
			
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					edges.get(i).add(new Edge(j, getDist(i, j)));
					edges.get(j).add(new Edge(i, getDist(i, j)));
				}
			}
			
			int cnt = 1;
			visit[0] = true;
			pq.addAll(edges.get(0));
			
			while(!pq.isEmpty()) {
				Edge temp = pq.poll();
				if(visit[temp.to]) continue;
				visit[temp.to] = true;
				cnt++;
				ans += E * Math.pow(temp.dist, 2);
				if(cnt == N) break;
				
				for(int i=0; i<edges.get(temp.to).size(); i++) {
					if(!visit[edges.get(temp.to).get(i).to]) {
						pq.offer(edges.get(temp.to).get(i));
					}
				}
			}
			
			
			System.out.println("#"+tc+" "+(long)Math.round(ans));
		}

	}
	
	public static double getDist(int a, int b) {
		return Math.sqrt(Math.pow(arr[a][0] - arr[b][0], 2) + Math.pow(arr[a][1] - arr[b][1], 2));
	}
	/*
	static class Edge implements Comparable<Edge>{
		public int from;
		public int to;
		public double distance;
		public Edge(int from, int to, double distance) {
			this.from = from;
			this.to = to;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Edge e) {
			if(distance > e.distance) return 1;
			else if(distance == e.distance) return 0;
			else return -1;
		}
	}
	static int N;
	static int[][] arr;
	static int[] parent;
	static double E, ans;
	static ArrayList<Edge> edges = new ArrayList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][2];
			ans = 0;
			parent = new int[N];
			edges.clear();
			for(int j=0; j<2; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int i=0; i<N; i++) {
					arr[i][j] = Integer.parseInt(st.nextToken()); 
				}
			}
			E = Double.parseDouble(br.readLine());
			
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					edges.add(new Edge(i, j, getDist(i, j)));
				}
			}
			
			Collections.sort(edges);
			
			make();
			int cnt = 0;
			for(int i=0; i<edges.size(); i++) {
				if(union(edges.get(i).from, edges.get(i).to)) {
					cnt++;
					ans += E * Math.pow(edges.get(i).distance, 2);
					if(cnt == N-1) break;
				}
			}
			System.out.println("#"+tc+" "+(long)Math.round(ans));
		}

	}
	
	public static void make() {
		for(int i=0; i<N; i++) parent[i] = i;
	}
	public static int find(int p) {
		if(parent[p] == p) return p;
		else return parent[p] = find(parent[p]);
	}
	
	public static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) return false;
		if(pa > pb) parent[pa] = pb;
		else parent[pb] = pa;
		return true;
	}
	
	public static double getDist(int a, int b) {
		return Math.sqrt(Math.pow(arr[a][0] - arr[b][0], 2) + Math.pow(arr[a][1] - arr[b][1], 2));
	}
	*/
}
