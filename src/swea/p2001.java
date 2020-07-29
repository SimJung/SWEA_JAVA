package swea;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class p2001 {

	public static void main(String[] args) throws IOException{
		int T;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		String s;
		for(int tc=1; tc<=T; tc++) {
			int ans = 0, N, M, temp = 0;
			s = bf.readLine();
			st = new StringTokenizer(s);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int arr[][] = new int[N][N];
			for(int i=0; i<N; i++) {
				s = bf.readLine();
				st = new StringTokenizer(s);
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N-M+1; i++) {
				for(int j=0; j<N-M+1; j++) {
					temp = 0;
					for(int k=i; k<i+M; k++) {
						for(int l=j; l<j+M; l++) {
							temp += arr[k][l];
						}
					}
					if(temp > ans)
						ans = temp;
				}
			}
			
			bw.write("#" + tc + " "+ans+"\n");
			bw.flush();
		}
		bw.close();
	}

}
