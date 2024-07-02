package yeung.algorithms.sorting;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick {

	public static void sort(Comparable[] a)
	{
		StdRandom.shuffle(a);
		sort(a, 0, a.length -1);
	}
	private static void sort(Comparable[] a, int lo, int hi)
	{
		if(hi <= lo) 
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo, j = hi+1;
		Comparable v = a[lo];
		while(true)
		{
			while(less(a[++i], v))
				if(i == hi)
					break;
			while(less(v, a[--j]))
				if(j == lo)
					break;
			if(i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
	/**
     * Rearranges the array so that {@code a[k]} contains the kth smallest key;
     * {@code a[0]} through {@code a[k-1]} are less than (or equal to) {@code a[k]}; and
     * {@code a[k+1]} through {@code a[n-1]} are greater than (or equal to) {@code a[k]}.
     *
     * @param  a the array
     * @param  k the rank of the key
     * @return the key of rank {@code k}
     * @throws IllegalArgumentException unless {@code 0 <= k < a.length}
     */
    public static Comparable select(Comparable[] a, int k) {
        if (k < 0 || k >= a.length) {
            throw new IllegalArgumentException("index is not between 0 and " + a.length + ": " + k);
        }
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int i = partition(a, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return a[i];
        }
        return a[lo];
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
