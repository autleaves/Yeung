package yeung.algorithms.sorting;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Quick3way {
	
	public static void sort(Comparable[] a)
	{
		sort(a, 0, a.length-1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if(hi <= lo) 
			return;
		int lt = lo, i = lo+1, gt = hi;
		Comparable v = a[lo];
		while(i <= gt)
		{
			int cmp = a[i].compareTo(v);
			if(cmp < 0)
				exch(a, lt++, i++);
			else if(cmp > 0)
				exch(a, i, gt--);
			else
				i++;
		}
		sort(a, lo, lt-1);
		sort(a, gt + 1, hi);
	}
	
	/***************************************************************************
     *  Helper sorting function.
     ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	// print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }
    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
     private static boolean isSorted(Comparable[] a) {
         return isSorted(a, 0, a.length - 1);
     }

     private static boolean isSorted(Comparable[] a, int lo, int hi) {
         for (int i = lo + 1; i <= hi; i++)
             if (less(a[i], a[i-1])) return false;
         return true;
     }

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		sort(a);
		show(a);
		assert isSorted(a);
	}

}
