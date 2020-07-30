package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class p1225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int n, temp, val = 1;
			n = sc.nextInt();
			Queue<Integer> q = new LinkedList<Integer>();
			
			for(int i=0; i<8; i++) {
				temp = sc.nextInt();
				q.offer(temp);
			}
			while(true) {
				int front = q.poll();
				//System.out.println(front);
				if(front > val) {
					front -= val;
					if(++val > 5)
						val = 1;
				}
				else
					front = 0;
				
				q.offer(front);
				if(front == 0)
					break;
			}
			
			System.out.print("#" + tc + " ");
			for(int i=0; i<8; i++)
				System.out.print(q.poll()+" ");
			System.out.println();
		}
	}

}
