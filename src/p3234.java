import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p3234 {
	static int N, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			int[] arr = new int[N];
			ans = 0;
			boolean[] use = new boolean[N];
			//visit = new boolean[N];
			//perm = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			do {
				getCnt(arr, 1, 0, arr[0]);
			}while(np(arr));
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	public static void getCnt(int[] arr, int cnt, int right, int left) {
		if(cnt == N) {
			ans++;
			
			/*
			System.out.print("Right : ");
			for(int i=0; i<N; i++) {
				System.out.print((use[i] ? arr[i] : "") + " ");
			}
			System.out.println();
			
			System.out.print("Left : ");
			for(int i=0; i<N; i++) {
				System.out.print((!use[i] ? arr[i] : "") + " ");
			}
			System.out.println();
			*/
		}else {
			getCnt(arr, cnt+1, right, left+arr[cnt]);
			
			if(right+arr[cnt] > left) return;
			getCnt(arr, cnt+1, right+arr[cnt], left);
		}
	}
	
	/*
	public static void getPerm(int cnt) {
		if(cnt == N) {
			perms.offer(Arrays.copyOf(perm, N));
		}else {
			for(int i=0; i<N; i++) {
				if(!visit[i]) {
					visit[i] = true;
					perm[cnt] = arr[i];
					getPerm(cnt+1);
					visit[i] = false;
				}
			}
		}
	}
	*/
	
	public static boolean np(int[] arr) {
		int i = arr.length-1;
		while(i>0 && arr[i-1] >= arr[i]) i--;
		
		if(i == 0) return false;
		
		int j = arr.length-1;
		while(j>0 && arr[i-1] >= arr[j]) j--;
		
		swap(arr, i-1, j);
		
		int k = arr.length-1;
		while(i < k) swap(arr, i++, k--);
		
		return true;
	}
	
	public static void swap(int arr[], int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}
