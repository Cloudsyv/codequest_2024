import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankruptOnFuel {
	// gcd() method, returns the GCD of a and b
	static int calculateGcd(int n1, int n2) {
		// initially set to gcd
		int gcd = 1;
		for (int i = 1; i <= n1 && i <= n2; ++i) {
			// check if i perfectly divides both n1 and n2
			if (n1 % i == 0 && n2 % i == 0)
				gcd = i;
		}
		return gcd;
	}

	/**
	 * Reads standard in to get the values
	 */
	public static void main(String[] args) {
		// First, connect to the standard input channel
		// This "try-with-resources" block will automatically close
		// the Scanner when we're done using it (even if your program
		// throws an Exception).
		try (Scanner testCases = new Scanner(System.in)) {
			// Next, read the number of test cases
			int numOfTestCases = Integer.parseInt(testCases.nextLine());

			// Now perform each test case. This for loop is the last part
			// common to all problems; the contents of this for loop will
			// change depending on what problem you're solving.
			for (int testCase = 0; testCase < numOfTestCases; testCase++) {
				int fuelAvailable = testCases.nextInt();
				int numOfTanks = testCases.nextInt();
				List<Integer> tankCapacities = new ArrayList<Integer>();
				List<Integer> tankContents = new ArrayList<Integer>();
				for (int tank = 0; tank < numOfTanks; tank++) {
					tankCapacities.add(tank, testCases.nextInt());
					tankContents.add(tank, 0);
				}

				// Fill the tanks as far as they will go.
				// Keep track of how many are filled.
				int fuelLeft = fuelAvailable;
				int unfilledTanks = numOfTanks;
				int highestLevel = 0;
				while (fuelLeft >= unfilledTanks) {
					for (int tank = 0; tank < numOfTanks; tank++) {
						int currentContents = tankContents.get(tank);
						if (currentContents < tankCapacities.get(tank)) {
							int newContents = currentContents + 1;
							// tankCapacities.set(tank, newCapacity);
							tankContents.set(tank, newContents);
							fuelLeft--;
							if (tankCapacities.get(tank) == newContents) {
								unfilledTanks--;
							}
						}
					}
					highestLevel++;
				}
				if (fuelLeft == 0) {
					// If there is no fuel left then all the tanks are full. So just print their capacities.
					for (int tank = 0; tank < numOfTanks - 1; tank++) {
						System.out.print(tankContents.get(tank) + " ");
					}
					System.out.println(tankContents.get(numOfTanks - 1));

				} else {
					// If there is remaining fuel evenly distribute it across the unfilled tanks.
					int gcd = calculateGcd(fuelLeft, unfilledTanks);
					int denominator = unfilledTanks / gcd;
					int numerator = (highestLevel * denominator) + (fuelLeft / gcd);
					for (int tank = 0; tank < numOfTanks - 1; tank++) {
						if (tankCapacities.get(tank) <= highestLevel) {
							System.out.print(tankContents.get(tank) + " ");
						} else {
							System.out.print(numerator + "/" + denominator + " ");
						}
					}
					if (tankCapacities.get(numOfTanks - 1) <= highestLevel) {
						System.out.println(tankContents.get(numOfTanks - 1));
					} else {
						System.out.println(numerator + "/" + denominator);
					}
				}
			}
		}
	}
}
