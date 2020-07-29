package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Scanner;

public class p1873 {
	
	static int dir[][] = {
			{-1, 0},	//상
			{1, 0},		//하
			{0, -1},	//좌
			{0, 1}		//우
	};
	
	static String tank = "^v<>";
	static String direction = "UDLR";
	
	public static void main(String[] args) throws IOException {
		int T;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String temp;
		StringTokenizer st;
		
		T = Integer.parseInt(bf.readLine());
		for(int tc=1; tc<=T; tc++) {
			
			int H, W, now_i=0, now_j=0, now_d=0;
			temp = bf.readLine();
			st = new StringTokenizer(temp);
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			char maps[][] = new char[H][W];
			
			for(int i=0; i<H; i++) {
				String s;
				s = bf.readLine();
				maps[i] = s.toCharArray();
				for(int j=0; j<W; j++) {
					for(int k=0; k<4; k++) {
						if(maps[i][j] == tank.charAt(k)) {
							now_d = k;
							now_i = i;
							now_j = j;
							break;
						}
					}
				}
			}
			
			int clen;
			clen = Integer.parseInt(bf.readLine());
			String command;
			command = bf.readLine();
			
			for(int i=0; i<command.length(); i++) {
				if(command.charAt(i) == 'S') {
					int bi = now_i;
					int bj = now_j;
					while(true) {
						bi += dir[now_d][0];
						bj += dir[now_d][1];
						
						if(bi < 0 || bi >= H || bj < 0 || bj >= W || maps[bi][bj] == '#')
							break;
						
						if(maps[bi][bj] == '.')
							continue;
						
						if(maps[bi][bj] == '*') {
							maps[bi][bj] = '.';
							break;
						}
					}
				}else {
					for(int j=0; j<4; j++) {
						if(command.charAt(i) == direction.charAt(j))
						{
							now_d = j;
							break;
						}
					}
					int ni = now_i + dir[now_d][0];
					int nj = now_j + dir[now_d][1];
					maps[now_i][now_j] = tank.charAt(now_d);
					
					if(ni >= 0 && ni < H && nj >= 0 && nj < W && maps[ni][nj] == '.') {
						maps[now_i][now_j] = '.';
						maps[ni][nj] = tank.charAt(now_d);
						
						now_i += dir[now_d][0];
						now_j += dir[now_d][1];
					}
				}
			}
			
			
			bw.write("#" + tc + " ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					bw.write(maps[i][j]);
				}
				bw.write("\n");
			}
			bw.flush();
		}
		bw.close();
	}
}
