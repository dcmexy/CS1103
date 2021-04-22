
/**
 * This is Benchmarking Sorting Algorithms task for Unit 1
 * @author Dean C.
 *
 */
public class BenchmarkAlgo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int ARRAY_SIZE = 100000; // Define array size
		
		// Define to arrays to sort
		int[] mainArray = new int[ARRAY_SIZE];
		int[] copyArray = new int[ARRAY_SIZE];
		
		// Fill out Array
		for(int i = 0; i < ARRAY_SIZE; i++) {
			// Generate random value
			int randomValue = (int)(Integer.MAX_VALUE * Math.random());
			
			// Assign same value to both arrays
			mainArray[i] = randomValue;
			copyArray[i] = randomValue;
		}
		
		// Perform Selection Sort
		System.out.println("Perfoming Selection Sort for " + ARRAY_SIZE + " items...");
		long startTime = System.currentTimeMillis();
		selectionSort(mainArray);
		long runTime = System.currentTimeMillis() - startTime;
		System.out.println("Selection Sort completed in " + runTime/1000.0 + " seconds");
		
		
		// Perform Sort using Array.Sort()
		System.out.println("Perfoming Array.sort() for " + ARRAY_SIZE + " items...");
		startTime = System.currentTimeMillis();
		selectionSort(mainArray);
		runTime = System.currentTimeMillis() - startTime;
		System.out.println("Array.sort() completed in " + runTime/1000.0 + " seconds");
		
		
	}
	
	/**
	 * Selection sort as adapted from Chapter 7.4 of Eck (2019).
	 *
	 **/
	static void selectionSort(int[] A) {
		// Sort A into increasing order, using selection sort
		for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
			// Find the largest item among A[0], A[1], ...,
			// A[lastPlace], and move it into position lastPlace
			// by swapping it with the number that is currently
			// in position lastPlace.
			int maxLoc = 0;  // Location of largest item seen so far.
			
			for (int j = 1; j <= lastPlace; j++) {
				if (A[j] > A[maxLoc]) {
					// Since A[j] is bigger than the maximum we’ve seen
					// so far, j is the new location of the maximum value
					// we’ve seen so far.
					maxLoc = j; 
				}
			}
			int temp = A[maxLoc];  // Swap largest item with A[lastPlace].
			A[maxLoc] = A[lastPlace];
			A[lastPlace] = temp;
		}  // end of for loop
	}
}