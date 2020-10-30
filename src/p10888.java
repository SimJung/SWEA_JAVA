import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class p10888 {
	public static class Spot{
		public int i;
		public int j;
		public Spot(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
	}
	public static int N;
	public static int arr[][];
	public static ArrayList<Spot> houses = new ArrayList<>();
	public static ArrayList<Spot> stores = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			houses.clear();
			stores.clear();
			int ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] == 1) houses.add(new Spot(i, j));
					else if(arr[i][j] > 1) stores.add(new Spot(i, j));
				}
			}
			
			for(int flag=1; flag<(1<<stores.size()); flag++) {
				int tempAns = 0;
				for(int h=0; h<houses.size(); h++) {
					int dist = Integer.MAX_VALUE;
					for(int s=0; s<stores.size(); s++) {
						if((flag & (1 << s)) != 0 && dist > getDist(houses.get(h), stores.get(s))) {
							dist = getDist(houses.get(h), stores.get(s));
						}
					}
					tempAns += dist;
				}
				
				for(int s=0; s<stores.size(); s++) {
					if((flag & (1 << s)) != 0) {
						tempAns += arr[stores.get(s).i][stores.get(s).j];
					}
				}
				
				if(ans > tempAns) ans = tempAns;
			}
			
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static int getDist(Spot a, Spot b) {
		return Math.abs(a.i - b.i) + Math.abs(a.j - b.j);
	}
}
