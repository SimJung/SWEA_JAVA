package swea;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class p1233 {
	static String[] arr;
	static int N;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String tok;
		for(int tc = 1; tc <= 10; tc++) {
			int ans = 1;
			N = Integer.parseInt(bf.readLine());
			arr = new String[N+1];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(bf.readLine());
				int idx = Integer.parseInt(st.nextToken());
				arr[idx] = st.nextToken();
			}
			
			ans = (inOrder(1) ? 1 : 0);
			
			System.out.println("#"+tc+" "+ans);
		}
	/*
	// 배열 안 만들고 해결
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n;
		String tok;
		for(int tc = 1; tc <= 10; tc++) {
			int ans = 1;
			n = Integer.parseInt(bf.readLine());
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(bf.readLine());
				tok = st.nextToken();
				tok = st.nextToken();
				if(st.countTokens() > 0) {
					if(!isOp(tok.charAt(0))) {
						ans = 0;
					}
				}else {
					if(isOp(tok.charAt(0))) {
						ans = 0;
					}
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
		*/
	}
	
	public static boolean isOp(char c) {
		switch(c) {
		case '+':
		case '-':
		case '*':
		case '/':
			return true;
			
		default:
			break;
		}
		return false;
	}
	
	public static boolean inOrder(int idx) {
		boolean ret = true;
		if(idx * 2 > N) {
			if(isOp(arr[idx].charAt(0)))
				ret = false;
			return ret;
		}else {
			if(!isOp(arr[idx].charAt(0)))
				ret = false;
			
			boolean ret1 = inOrder(idx*2);
			boolean ret2 = (idx*2+1 > N ? true : inOrder(idx*2+1));
			return ret & ret1 & ret2;
		}
	}
}
