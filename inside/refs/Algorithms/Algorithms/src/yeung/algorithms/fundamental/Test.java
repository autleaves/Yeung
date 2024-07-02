package yeung.algorithms.fundamental;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Test {

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N = 100;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N*N);
		StdDraw.setPenRadius(.01);
		for(int i = 1; i <= N; i++)
		{
			StdDraw.point(i, i);
			StdDraw.point(i, i*i);
			StdDraw.point(i, i*Math.log(i));
		}
	}*/
	
	  public static void main(String[] args) { // TODO Auto-generated method stub
	  
		  int T = Integer.parseInt(args[0]);
		  Accumulator a = new Accumulator();
		  for(int t = 0; t < T; t++)
		  {
			  a.addDataValue(StdRandom.random());
		  }
		  StdOut.println(a);
	  }
	 

}
