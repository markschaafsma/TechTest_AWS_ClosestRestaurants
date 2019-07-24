package closestrestaurants;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Problem 
 * -------
 * A diner wants to know the closest restaurants to his current location. A set of coordinates for each restaurant 
 * relative to the diner's current position is provided. This function should determine the closest restaurants to 
 * diner and return those coordinates.
 * 
 * Function Description
 * --------------------
 * This function will be supplied the total number of restaurants in the area, the coordinates of those restaurants 
 * relative to the diner, and the number of restaurants to be returned.
 * 
 * Input
 * -----
 *  n    - the number of input coordinate pairs
 *  list - the list of coordinate pairs
 *  x -    the number of coordinate pairs to return
 * 
 * Output
 * ------
 *  list - the list of closest coordinate pairs
 * 
 * Testcases
 * ---------
 *  Testcase 0
 *   Input(stdin)
 *    2
 *    [2,3],[3,1]
 *    1
 *   Expected Output
 *    [3,1]
 * 
 *  Testcase 1
 *   Input(stdin)
 *    3
 *    [2,3],[3,1],[-1,5]
 *    2
 *   Expected Output
 *    [2,3],[3,1]
 */

public class Solution {
	
	public static List<List<Integer>> findClosestStores(int noOfInputCoords, List<List<Integer>> coordsList, int noOfOutputCoords) {
		// Write your code here
		
		// Print input to stdout
		System.out.println("Input Data");
		System.out.println(noOfInputCoords);
		printPairs(noOfInputCoords, coordsList);
		System.out.print(noOfOutputCoords + "\n");
		
		// Sort distances in ascending order
		// Sort uses Comparator (two objects passed in). This can be its own class or a class defined within the sort statement.
//		Collections.sort(coordsList, new SortByDistance() {
		Collections.sort(coordsList, new Comparator<List<Integer>>() {
			public int compare(List<Integer> a, List<Integer> b) { 
				// Calculate absolute distance for each pair
				int aDistance = 0;
				for (int i = 0; i < 2; i++) {
					aDistance += Math.abs(a.get(i));
				}
				int bDistance = 0;
				for (int i = 0; i < 2; i++) {
					bDistance += Math.abs(b.get(i));
				}
				// Return is ascending order
				return aDistance - bDistance; 
				// Return in descending order
//				return bDistance - aDistance; 
			}
		});

		// Print sorted collection to stdout
		System.out.println("Sorted Input Coordinates");
		printPairs(noOfInputCoords, coordsList);

		// Add closest coordinates to the recommended list
		List<List<Integer>> recommended = new ArrayList<>();  // Ok and best practice - type argument is inferred. 
// 		List<List<Integer>> recommended2 = new ArrayList<List<Integer>>(); // Ok - type argument explicitly stated.
//		List<List<Integer>> recommended3 = new ArrayList<<>>();  // Not ok - Multiple syntax errors!
		for (int i = 0; i < noOfOutputCoords; i++) {
			recommended.add(coordsList.get(i));
		}

		// Print recommended coordinates to stdout
		System.out.println("Recommended Coordinates");
		printPairs(recommended.size(), recommended);
   		
		return recommended;
	}

	private static void printPairs(int noOfCoords, List<List<Integer>> coordsList) {
		for (int i = 0; i < noOfCoords; i++) {
			System.out.print("[");
			for (int j = 0; j < 2; j++) {
				System.out.print(coordsList.get(i).get(j));
				if (j==0) {System.out.print(",");}
			}
			System.out.print("]");
			if (i < noOfCoords-1) {System.out.print(",");}
		}
		System.out.print("\n");
	}
	
	private static final Scanner scan = new Scanner(System.in);

    /**
     * Testcases
     * ---------
     * 
     *  Testcase 0
     *   Input(stdin)
     *    2
     *    [2,3],[3,1]
     *    1
     *   Expected Output
     *    [3,1]
     *    
     *  Testcase 1
     *   Input(stdin)
     *    3
     *    [2,3],[3,1],[-1,5]
     *    2
     *   Expected Output
     *    [2,3],[3,1]
     */        
	public static void main(String[] args) throws IOException {

		BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"));

		// Read the number of input coordinate pairs
		String s = scan.nextLine();
		int n = Integer.parseInt(s);

		// Read the list of coordinate pairs
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < n; i++) {
			List<Integer> coords = new ArrayList<>();
			for (int j = 0; j < 2; j++) {
				s = scan.nextLine();
				int c = Integer.parseInt(s);
				coords.add(c);
			}
			list.add(coords);
		}
    	
		// Read the number of coordinate pairs to return    	
		s = scan.nextLine();
		int x = Integer.parseInt(s);
        
		List<List<Integer>> results = findClosestStores(n,list,x);

		// Write results
		for (int i = 0; i < results.size(); i++) {
			bw.write("[");
			for (int j = 0; j < 2; j++) {
				bw.write(results.get(i).get(j).toString());
				if (j==0) {bw.write(",");}
			}
			bw.write("]");
			if (i < results.size()-1) {bw.write(",");}
		}
		bw.newLine();
		bw.close();
	}	
	
}


class SortByDistance implements Comparator<List<Integer>> {
	
    // Used for sorting in ascending distance order 
	@Override
	public int compare(List<Integer> a, List<Integer> b) { 
    	
		// Calculate absolute distance for each pair
		int aDistance = 0;
       	for (int i = 0; i < 2; i++) {
       		aDistance += Math.abs(a.get(i));
       	}
		int bDistance = 0;
       	for (int i = 0; i < 2; i++) {
       		bDistance += Math.abs(b.get(i));
       	}
       	
       	// ascending order
        return aDistance - bDistance; 
    }

} 
	
	
class SortByDistance2 implements Comparable<List<Integer>> {
	
	@Override
	public int compareTo(List<Integer> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
