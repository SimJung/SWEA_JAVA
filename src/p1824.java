

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1824 {
	public static boolean isContain = false;
	public static int R, C;
	public static char[][] arr;
	public static boolean[][][][] visit;
	public static int delta[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	public static boolean stop = false;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			isContain = false;
			stop = false;
			arr = new char[R][C];
			visit = new boolean[R][C][16][4];

			for (int i = 0; i < R; i++) {
				arr[i] = br.readLine().toCharArray();
				if (!isContain) {
					for (int j = 0; j < C; j++) {
						if (arr[i][j] == '@') {
							isContain = true;
							break;
						}
					}
				}
			}

			if (isContain) {
				dfs(0, 0, 0, 0);
			}
			System.out.println("#" + tc + " " + (stop ? "YES" : "NO"));
		}
	}

	public static void dfs(int i, int j, int m, int d) {
		
		if(stop) return;
		
		if(arr[i][j] == '@') {
            stop = true;
            return ;
        }
		
		if(visit[i][j][m][d]) return;
		visit[i][j][m][d] = true;
		
		int dir = d;
		int memo = m;
		
		char now = arr[i][j];
		switch (now) {
		case '<': dir = 2; break;
		case '>': dir = 0; break;
		case '^': dir = 3; break;
		case 'v': dir = 1; break;
		case '_': dir = (m == 0 ? 0 : 2); break;
		case '|': dir = (m == 0 ? 1 : 3); break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9': memo = now - '0'; break;
		case '+': memo = (m == 15 ? 0 : m+1); break;
		case '-': memo = (m == 0 ? 15 : m-1); break;
		}

		if (now == '?') {
			for (int k = 0; k < 4; k++) {
				int newI = i + delta[k][0];
				int newJ = j + delta[k][1];

				if (newI == -1) newI = R - 1;
				else if (newI == R) newI = 0;

				if (newJ == -1)	newJ = C - 1;
				else if (newJ == C)	newJ = 0;

				dfs(newI, newJ, memo, k);
			}
		} else {
			int ni = i + delta[dir][0];
			int nj = j + delta[dir][1];

			if (ni == -1) ni = R - 1;
			else if (ni == R) ni = 0;

			if (nj == -1) nj = C - 1;
			else if (nj == C) nj = 0;

			dfs(ni, nj, memo, dir);
		}
	}
}

/*

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dfs
// visit - r/c/4/16 : 좌표, 방향, 메모리 저장된 값
// @ 없는 경우 StackOverflowError !!
// ? 처리 
// 삼항 연산자  ( 식 ) ? A : B

public class p1824 {

    static int T;
    static int R, C;
    static char[][] map;
    static boolean[][][][] visit;
    static boolean stop;
    static boolean at;
    
    // 왼-오-위-아래
    static int[] dy = { 0, 0,-1, 1};
    static int[] dx = {-1, 1, 0, 0};     
    
    public static void main(String[] args) throws Exception {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            
            map = new char[R][C];
            visit = new boolean[R][C][4][16];
            stop = false;
            at = false;
            
            for (int i = 0; i < R; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < C; j++) {
                	if(map[i][j] == '@') at = true;
                }
            }
            // '@' 가 있는 테스트 케이스만 탐색한다.
            if(at) {
                dfs(0,0,1,0);
            }
            
            System.out.println("#" + t + " " + (stop ? "YES" : "NO"));
        }
    }
    
    // y좌표, x좌표, 방향, 메모리
    static void dfs(int y, int x, int d, int m) {
    	
    	// 이미 종료되었으면 중지
        if(stop) return ;
        
        // 종료 조건
        if(map[y][x] == '@') {
            stop = true;
            return ;
        }
        
        // visit 체크
        if( visit[y][x][d][m] ) return ;
        visit[y][x][d][m] = true;
        
        int dir = d;
        int mem = m;
        
        switch(map[y][x]) {
	        case '<': dir = 0; break; // 왼
	        case '>': dir = 1; break; // 오
	        case '^': dir = 2; break; // 위
	        case 'v': dir = 3; break; // 아래
	        case '_': dir = (m == 0 ? 1 : 0); break;
	        case '|': dir = (m == 0 ? 3 : 2); break;
	        case '+': mem = (m == 15 ? 0 : m + 1); break;
	        case '-': mem = (m == 0 ? 15 : m - 1); break;
	        case '0':
	        case '1':
	        case '2':
	        case '3':
	        case '4': 
	        case '5':
	        case '6':
	        case '7':
	        case '8':
	        case '9': mem = map[y][x] - '0'; break;
        }
        
        // ? 사방 탐색
        if (map[y][x] == '?') {
            for (int i = 0; i < 4; i++) {
            	
            	int ny = y + dy[i];
            	int nx = x + dx[i];
            	
            	// 경계 넘는 값 보정
            	if( ny < 0 ) ny = R - 1;
            	if( ny > R - 1 ) ny = 0;
            	
            	if( nx < 0 ) nx = C - 1;
            	if( nx > C - 1 ) nx = 0;
            	
            	dfs(ny, nx, i, mem);

            }
        }
        else {
        	
        	int ny = y + dy[dir];
        	int nx = x + dx[dir];
        	
        	// 경계 넘는 값 보정
        	if( ny < 0 ) ny = R - 1;
        	if( ny > R - 1 ) ny = 0;
        	
        	if( nx < 0 ) nx = C - 1;
        	if( nx > C - 1 ) nx = 0;
        	
        	dfs(ny, nx, dir, mem);

        }
    }
}
*/

