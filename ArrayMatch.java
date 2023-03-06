/* 
 * CSC 225 - Assignment 3
 * Name: Brendon Waters
 * Student number: V00963713
 */

/* 
Algorithm analysis goes here.
For the base case the T(n) is constant because if the size of the int arrays are both 1.
This is not the worst case scenario and so does not affect
the worst case time complexity.
So, this algorithm divides 2 arrays each into a total of 4 sub-arrays
and does so recursively k times which results in a BigO of 2^k in the worst case
for k being the size of the arrays.
Therefore T(n) = c_1n + T(n/2) + T(n/2) + c_2n for
constant time divides, 2 recursive calls on each array and contant time comparisons respectively
which in the worst case means that n = 2^k for k => 1 which simplifies to T(n) = nlogn
when converted from open form to closed form.
*/

import java.io.*;
import java.util.*;

public class ArrayMatch {

	static boolean match(int[] a, int[] b) {
		/*
		 * Your recusive solution goes here.
		 */
		/* Base Case */
		if (a.length < 2 && b.length < 2) {
			return (a[0] == b[0] ? true : false);
		}
		/* Recursive Case */
		if (a.length % 2 == 0 && b.length % 2 == 0) {
			int n = a.length;
			int[] a1 = new int[n / 2];
			int[] a2 = new int[n / 2];
			int[] b1 = new int[n / 2];
			int[] b2 = new int[n / 2];
			int i, j;
			for (i = 0; i < n / 2; i++) {
				a1[i] = a[i];
				b1[i] = b[i];
			}
			for (j = 0; j < n / 2; j++) {
				a2[j] = a[i];
				b2[j] = b[i];
				i++;
			}
			return (match(a1, b1) && match(a2, b2) || match(a1, b1) && match(a1, b2) || match(a2, b1) && match(a2, b2));
		}
		if (a.length % 2 == 1 && b.length % 2 == 1) {
			int n = a.length;
			int[] a1 = new int[n / 2 + 1];
			int[] a2 = new int[n / 2];
			int[] b1 = new int[n / 2 + 1];
			int[] b2 = new int[n / 2];
			int i, j;
			for (i = 0; i < n / 2 + 1; i++) {
				a1[i] = a[i];
				b1[i] = b[i];
			}
			for (j = 0; j < n / 2; j++) {
				a2[j] = a[i];
				b2[j] = b[i];
				i++;
			}
			return (match(a1, b1) && match(a2, b2));
		}
		return false;
	}

	public static void main(String[] args) {
		/*
		 * Read input from STDIN. Print output to STDOUT. Your class should be named
		 * ArrayMatch.
		 * 
		 * You should be able to compile your program with the command:
		 * 
		 * javac ArrayMatch.java
		 * 
		 * To conveniently test your algorithm, you can run your solution with any of
		 * the tester input files using:
		 * 
		 * java ArrayMatch inputXX.txt
		 * 
		 * where XX is 00, 01, ..., 13.
		 */

		Scanner s;
		if (args.length > 0) {
			try {
				s = new Scanner(new File(args[0]));
			} catch (java.io.FileNotFoundException e) {
				System.out.printf("Unable to open %s\n", args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n", args[0]);
		} else {
			s = new Scanner(System.in);
			System.out.printf("Reading input values from stdin.\n");
		}

		int n = s.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];

		for (int j = 0; j < n; j++) {
			a[j] = s.nextInt();
		}

		for (int j = 0; j < n; j++) {
			b[j] = s.nextInt();
		}
		System.out.println((match(a, b) ? "YES" : "NO"));
	}
}
