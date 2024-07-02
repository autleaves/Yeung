package yeung.algorithms.fundamental;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<T> implements Iterable<T>{

	private Node first;
	private int N;
	
	private class Node {
		T item;
		Node next;
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	public int size()
	{
		return N;
	}
	public void push(T item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public T pop()
	{
		T item = first.item;
		first = first.next;
		N--;
		return item;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new PushdownStackIterator();
	}
	
	private class PushdownStackIterator implements Iterator<T> {

		private int i = N;
		
		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public T next() {
			return first.item;
		}
		
	}
	
	public static void main(String[] args)
	{
		Stack<String> s = new Stack<String>();
		
		while(!StdIn.isEmpty())
		{
			String item = StdIn.readString();
			if(!item.equals("-"))
				s.push(item);
			else if(!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}
