package swea;

import java.util.StringTokenizer;
import java.util.Stack;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class p1218 {
	
	public static String left = "([{<";
	public static String right = ")]}>";
	public static void main(String[] args) throws IOException {
		int T;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		T = 10;
		for(int tc=1; tc<=T; tc++) {
			
			int N;
			N = Integer.parseInt(bf.readLine());
			String s;
			s = bf.readLine();
			
			Stack<Character> stack = new Stack<Character>();
			
			boolean ans = true;
			int idx;
			for(int i=0; i<N; i++) {
				if((idx = left.indexOf(s.charAt(i))) != -1) stack.push(s.charAt(i));
				else {
					idx = right.indexOf(s.charAt(i));
					if(stack.empty() || stack.pop() != left.charAt(idx)) {
						ans = false;
						break;
					}
				}
			}
			
			if(!stack.empty()) ans = false;
			System.out.println("#" + tc + " " + (ans ? 1 : 0));
		}
	}

}
