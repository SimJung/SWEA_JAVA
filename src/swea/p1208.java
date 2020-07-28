package swea;

import java.util.Scanner;

public class p1208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int T;
		Scanner sc = new Scanner(System.in);
		T = 10;
		for(int tc=1; tc<=T; tc++) {
			
			int dump;
			int [] arr = new int[100];
			
			dump = sc.nextInt();
			
			for(int i=0; i<100; i++) {
				arr[i] = sc.nextInt();
			}
			
			int maxVal = 0, minVal = 101, maxIdx = 0, minIdx = 0;
			for(int i=0; i<dump; i++) {
				maxVal = 0;
				minVal = 101;
				maxIdx = 0;
				minIdx = 0;
				for(int j=0; j<100; j++) {
					if(arr[j] > maxVal) {
						maxVal = arr[j];
						maxIdx = j;
					}
					
					if(arr[j] < minVal) {
						minVal = arr[j];
						minIdx = j;
					}
				}
				
				arr[maxIdx]--;
				arr[minIdx]++;
			}
			
			maxVal = 0;
			minVal = 101;
			for(int j=0; j<100; j++) {
				
				if(arr[j] > maxVal) {
					maxVal = arr[j];
				}
				
				if(arr[j] < minVal) {
					minVal = arr[j];
				}
			}
			
			System.out.println("#" + tc + " " + (maxVal - minVal));
		}
	}

}
