import java.util.Scanner;

public class p1247 {
	static class Spot{
		public int x;
		public int y;
		public Spot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int n;
	public static int ans = 0, temp = 0;
	public static boolean visit[];
	public static Spot[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			visit = new boolean[n+2];
			ans = Integer.MAX_VALUE;
			
			arr = new Spot[n+2];
			for(int i=0; i<n+2; i++) {
				arr[i] = new Spot(sc.nextInt(), sc.nextInt());
			}
			
			for(int i=2; i<n+2; i++) {
				temp = getDist(arr[0], arr[i]);
				visit[i] = true;
				getAns(0, i, 0);
				visit[i] = false;
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static int getDist(Spot x, Spot y) {
		return Math.abs(x.x - y.x) + Math.abs(x.y - y.y);
	}
	
	public static void getAns(int from, int to, int cnt) {
		
		if(cnt == n-1) {
			temp += getDist(arr[to], arr[1]);
			if(ans > temp) {
				ans = temp;
			}
			temp -= getDist(arr[to], arr[1]);
			return ;
		}else {
			for(int i=2; i<n+2; i++) {
				if(!visit[i]) {
					visit[i] = true;
					temp += getDist(arr[to], arr[i]);
					getAns(to, i, cnt+1);
					temp -= getDist(arr[to], arr[i]);
					visit[i] = false;
				}
			}
		}
	}
}
