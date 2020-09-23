import java.util.Scanner;

public class p7393 {
	static int arr[] = new int[101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		arr[10] = 1;
		for(int i=11; i<=100; i++) {
			arr[i] = arr[i-1]*2 + 1;
			arr[i] %= 1000000000;
			System.out.println(i+"번째 수 : "+arr[i]);
		}
		for(int tc=1; tc<=T; tc++) {
			System.out.println("#"+tc+" "+arr[sc.nextInt()]);
		}
	}

}
