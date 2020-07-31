package swea;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;
public class p1223 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(bf.readLine());
			
			Stack<Integer> numbers = new Stack<Integer>();
			boolean mul = false;
			String s = bf.readLine();
			
			for(int i=0; i<N; i++) {
				if(isNumber(s.charAt(i))) {
					if(mul) {
						int m = numbers.pop() * (s.charAt(i) - '0');
						numbers.push(m);
						mul = false;
					}else numbers.push(s.charAt(i) - '0');
				}else if(s.charAt(i) == '*') mul = true;
			}
			
			int sum = 0;
			while(!numbers.empty()) 
				sum += numbers.pop();
			
			System.out.println("#" + tc + " " + sum);
		}
	}
	
	static boolean isNumber(char c) {
		if(c >= '0' && c <= '9') return true;
		return false;
	}

}
