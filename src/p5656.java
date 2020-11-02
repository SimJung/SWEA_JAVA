import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p5656 {
	public static class Info{
		public int i;
		public int j;
		public int cnt;
		public Info(int i, int j, int cnt) {
			super();
			this.i = i;
			this.j = j;
			this.cnt = cnt;
		}
	}
	public static int ans;
	public static int N, W, H;
	public static int blocks[][];
	public static int tempBlocks[][];
	public static int balls[];
	public static Queue<Info> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			ans = Integer.MAX_VALUE;
			blocks = new int[H][W];
			tempBlocks = new int[H][];
			balls = new int[N];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					blocks[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			perm(0);
			
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static void perm(int cnt) {
		if(cnt == N) {
			for(int i=0; i<H; i++) {
				tempBlocks[i] = Arrays.copyOf(blocks[i], W);
			}
			
			q.clear();
			for(int i=0; i<N; i++) {
				for(int j=0; j<H; j++) {
					if(tempBlocks[j][balls[i]] != 0) {
						q.offer(new Info(j, balls[i], tempBlocks[j][balls[i]]));
						tempBlocks[j][balls[i]] = 0;
						break;
					}
				}
				
				while(!q.isEmpty()) {
					Info now = q.poll();
					for(int j=now.i - now.cnt+1; j<now.i+now.cnt; j++) {
						if((j < 0 || j >= H) || tempBlocks[j][now.j] == 0) continue;
						q.offer(new Info(j, now.j, tempBlocks[j][now.j]));
						tempBlocks[j][now.j] = 0;
					}
					
					for(int j=now.j - now.cnt+1; j<now.j+now.cnt; j++) {
						if((j < 0 || j >= W) || tempBlocks[now.i][j] == 0) continue;
						q.offer(new Info(now.i, j, tempBlocks[now.i][j]));
						tempBlocks[now.i][j] = 0;
					}
				}
				
				for(int j=0; j<W; j++) {
					int zeroPos = -1;
					for(int k=H-1; k>=0; k--) {
						if(zeroPos == -1 && tempBlocks[k][j] == 0) {
							zeroPos = k;
						}else if(zeroPos != -1 && zeroPos < H && tempBlocks[k][j] != 0) {
							tempBlocks[zeroPos][j] = tempBlocks[k][j];
							tempBlocks[k][j] = 0;
							zeroPos--;
						}
					}
				}
			}
			
			int sum = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(tempBlocks[i][j] != 0) sum++;
				}
			}
			
			ans = Math.min(ans, sum);
			
		}else {
			for(int i=0; i<W; i++) {
				balls[cnt] = i;
				perm(cnt+1);
			}
		}
	}

}
