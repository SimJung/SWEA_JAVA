
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class p3499 {

	public static void main(String[] args) throws IOException{
		int T;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(bf.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(bf.readLine());
			String[] strs = bf.readLine().split(" ");
			
			bw.write("#" + tc + " ");
			
			int left = 0, right = (N%2 ==0) ? N/2 : N/2+1;
			while(true) {
				if(left == N/2 || right == N)
					break;
				
				bw.write(strs[left++]+" "+strs[right++]+" ");
			}
			if(N % 2 == 1)
				bw.write(strs[left]);
			bw.write("\n");
			
			bw.flush();
		}
		bw.close();
	}

}
