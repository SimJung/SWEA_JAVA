import java.util.Scanner;

public class p1952 {
	public static int dp[] = new int[12];
	public static int fc[] = new int[4];
	public static int cost[][] = new int[3][12];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc <=T; tc++) {
			for(int i=0; i<4 ; i++) {
				fc[i] = sc.nextInt();
			}
			
			for(int i=0; i<12; i++) {
				cost[0][i] = sc.nextInt() * fc[0];
			}
			for(int i=1; i<3; i++) {
				for(int j=0; j<12; j++) {
					cost[i][j] = fc[i];
				}
			}
			
			for(int i=0; i<12; i++) {
				int min = Integer.MAX_VALUE;
				for(int j=0; j<3; j++) {
					if(i == 0) {
						min = (min > cost[j][i] ? cost[j][i] : min);
					}else if(i < 3) {
						if(j == 2) {
							min = (min > cost[j][i] ? cost[j][i] : min);
						}else {
							min = (min > dp[i-1]+cost[j][i] ? dp[i-1] + cost[j][i] : min);
 						}
					}else {
						if(j == 2) {
							min = (min > dp[i-3]+cost[j][i] ? dp[i-3] + cost[j][i] : min);
						}else {
							min = (min > dp[i-1]+cost[j][i] ? dp[i-1] + cost[j][i] : min);
 						}
					}
				}
				dp[i] = min;
			}
			
			
			dp[11] = (dp[11] > fc[3] ? fc[3] : dp[11]);
			System.out.println("#"+tc+" "+dp[11]);
		}
		
	}
	
	public static void show() {
		for(int i=0; i<12; i++) {
			System.out.print(dp[i]+" ");
		}
		System.out.println();
	}
}
