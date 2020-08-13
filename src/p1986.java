
import java.util.Scanner;
public class p1986 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {1, -1, 2, -2, 3, -3, 4, -4, 5, -5};
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int n = sc.nextInt();
			System.out.println("#"+tc+" "+arr[n-1]);
		}
	}

}
