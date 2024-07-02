/*
Towers of Hanoi
diskNum = 3;
startPost = 1;
midPost = 2;
endPost = 3;
Move all disks from 1 to 3;*/
package yeung.algorithms.fundamental;




import edu.princeton.cs.algs4.StdOut;

public class Hanoi {
	
	/*
	 * private int diskNum; private int startPost; private int midPost; private int
	 * endPost;
	 * 
	 * public Hanoi(int n, int s, int e, int m) { diskNum = n; startPost = s;
	 * endPost = e; midPost = m; }
	 */
	public static void MoveDisk(int diskNum, int startPost, int endPost, int midPost)
	{
		if(diskNum > 1) 
		{
			MoveDisk(diskNum-1, startPost, midPost, endPost);
			StdOut.printf("Move disk %d from post %d to post %d.\n", 
					diskNum, startPost, endPost);
			MoveDisk(diskNum-1, midPost, endPost, startPost);
		}
		else
			StdOut.printf("Move disk 1 from post %d to post %d.\n", 
					startPost, endPost);
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int diskNum = 3;
		int startPost = 1;
		int midPost = 2;
		int endPost = 3;
		MoveDisk(diskNum, startPost, endPost, midPost);
	}

}
