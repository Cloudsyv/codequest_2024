import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// 55 minutes
public class A_Matter_Of_0_And_1 {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int testcases = Integer.parseInt(in.nextLine());

			for (int testcase = 0; testcase < testcases; testcase++) {
				int size = Integer.parseInt(in.nextLine());

				char[][] puzzle = new char[size][size];

				for (int i = 0; i < size; i++) {
					puzzle[i] = in.nextLine().toCharArray();
				}

				boolean advancedLogic = false;

				while (!isSolved(puzzle)) {
					// attempt to apply each step in turn
					// if a step is applied, start over again at step 1
					if (steps1and2(puzzle)) {
						continue;
					}
					if (step3(puzzle)) {
						continue;
					}
					if (step4(puzzle)) {
						advancedLogic = true;
						continue;
					}
					if (step5(puzzle)) {
						advancedLogic = true;
						continue;
					}
					// unsolvable
					break;
				}

				if (isSolved(puzzle)) {
					for (int row = 0; row < puzzle.length; row++) {
						System.out.println(new String(puzzle[row]));
					}

					System.out.println("Solved with " + (advancedLogic ? "complex" : "simple") + " logic");
				} else {
					System.out.println("Unable to solve with the provided logic");
				}
			}
		}

	}

	public static boolean isSolved(char[][] puzzle) {
		int[] oneColumnCounts = new int[puzzle.length];

		for (int i = 0; i < puzzle.length; i++) {
			oneColumnCounts[i] = 0;
		}

		for (int row = 0; row < puzzle.length; row++) {
			int oneRowCount = 0;
			for (int col = 0; col < puzzle.length; col++) {
				if (puzzle[row][col] == '.') {
					return false;
				} else if (puzzle[row][col] == '1') {
					oneColumnCounts[col]++;
					oneRowCount++;
				}
			}
			if (oneRowCount != puzzle.length / 2) {
				return false;
			}
		}

		for (int i = 0; i < puzzle.length; i++) {
			if (oneColumnCounts[i] != puzzle.length / 2) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Apply steps 1 and 2: A pair of identical numbers must be surrounded by the
	 * opposite number. A blank cell surrounded by identical numbers must contain
	 * the opposite number.
	 * 
	 * @param puzzle
	 * @return true if applied
	 */
	public static boolean steps1and2(char[][] puzzle) {
		// check rows first
		for (int row = 0; row < puzzle.length; row++) {
			String rowText = new String(puzzle[row]);

			if (rowText.contains(".11")) {
				int col = rowText.indexOf(".11");
				puzzle[row][col] = '0';
				return true;
			} else if (rowText.contains(".00")) {
				int col = rowText.indexOf(".00");
				puzzle[row][col] = '1';
				return true;
			} else if (rowText.contains("11.")) {
				int col = rowText.indexOf("11.") + 2;
				puzzle[row][col] = '0';
				return true;
			} else if (rowText.contains("00.")) {
				int col = rowText.indexOf("00.") + 2;
				puzzle[row][col] = '1';
				return true;
			} else if (rowText.contains("1.1")) {
				int col = rowText.indexOf("1.1") + 1;
				puzzle[row][col] = '0';
				return true;
			} else if (rowText.contains("0.0")) {
				int col = rowText.indexOf("0.0") + 1;
				puzzle[row][col] = '1';
				return true;
			}
		}

		// then columns
		for (int col = 0; col < puzzle.length; col++) {
			StringBuilder columnSB = new StringBuilder();
			for (int row = 0; row < puzzle.length; row++) {
				columnSB.append(puzzle[row][col]);
			}
			String colText = columnSB.toString();

			if (colText.contains(".11")) {
				int row = colText.indexOf(".11");
				puzzle[row][col] = '0';
				return true;
			} else if (colText.contains(".00")) {
				int row = colText.indexOf(".00");
				puzzle[row][col] = '1';
				return true;
			} else if (colText.contains("11.")) {
				int row = colText.indexOf("11.") + 2;
				puzzle[row][col] = '0';
				return true;
			} else if (colText.contains("00.")) {
				int row = colText.indexOf("00.") + 2;
				puzzle[row][col] = '1';
				return true;
			} else if (colText.contains("1.1")) {
				int row = colText.indexOf("1.1") + 1;
				puzzle[row][col] = '0';
				return true;
			} else if (colText.contains("0.0")) {
				int row = colText.indexOf("0.0") + 1;
				puzzle[row][col] = '1';
				return true;
			}
		}

		return false;
	}

	/**
	 * Apply step 3: The number of 0's and 1's in any row or column must be half the
	 * dimensions of the puzzle. If a row or column has met that quota for one
	 * number, all remaining blank cells must be filled with the opposite number.
	 * 
	 * @param puzzle
	 * @return true if applied
	 */
	public static boolean step3(char[][] puzzle) {
		int[] columnOnes = new int[puzzle.length];
		int[] columnZeroes = new int[puzzle.length];

		for (int i = 0; i < puzzle.length; i++) {
			columnOnes[i] = 0;
			columnZeroes[i] = 0;
		}

		// check rows first; count for columns while doing so
		for (int row = 0; row < puzzle.length; row++) {
			int ones = 0;
			int zeroes = 0;

			for (int col = 0; col < puzzle.length; col++) {
				if (puzzle[row][col] == '1') {
					ones++;
					columnOnes[col]++;
				} else if (puzzle[row][col] == '0') {
					zeroes++;
					columnZeroes[col]++;
				}
			}

			if (ones != zeroes) {
				if (ones == (puzzle.length / 2)) {
					for (int col = 0; col < puzzle.length; col++) {
						if (puzzle[row][col] == '.') {
							puzzle[row][col] = '0';
						}
					}
					return true;
				}
				if (zeroes == (puzzle.length / 2)) {
					for (int col = 0; col < puzzle.length; col++) {
						if (puzzle[row][col] == '.') {
							puzzle[row][col] = '1';
						}
					}
					return true;
				}
			}
		}

		// check column quotas
		for (int col = 0; col < puzzle.length; col++) {
			if (columnOnes[col] != columnZeroes[col]) {
				if (columnOnes[col] == (puzzle.length / 2)) {
					for (int row = 0; row < puzzle.length; row++) {
						if (puzzle[row][col] == '.') {
							puzzle[row][col] = '0';
						}
					}
					return true;
				}
				if (columnZeroes[col] == (puzzle.length / 2)) {
					for (int row = 0; row < puzzle.length; row++) {
						if (puzzle[row][col] == '.') {
							puzzle[row][col] = '1';
						}
					}
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Apply step 4: A row or column with two blank cells that is otherwise
	 * identical to another, already-complete row or column must have opposite
	 * values in the two blank cells.
	 * 
	 * @param puzzle
	 * @return true if applied
	 */
	public static boolean step4(char[][] puzzle) {
		List<String> completeRows = new ArrayList<>();
		Map<Integer, String> candidateRows = new HashMap<>();

		for (int row = 0; row < puzzle.length; row++) {
			String rowText = new String(puzzle[row]);

			if (!rowText.contains(".")) {
				completeRows.add(rowText);
			} else if (rowText.length() - rowText.replace(".", "").length() == 2) {
				candidateRows.put(row, rowText);
			}
		}

		if (!completeRows.isEmpty() && !candidateRows.isEmpty()) {
			for (Integer row : candidateRows.keySet()) {
				String rowText = candidateRows.get(row);

				for (String complete : completeRows) {
					boolean match = true;

					for (int i = 0; i < rowText.length() && match; i++) {
						if (rowText.charAt(i) != complete.charAt(i) && rowText.charAt(i) != '.') {
							match = false;
						}
					}

					if (match) {
						int col1 = rowText.indexOf(".");
						int col2 = rowText.lastIndexOf(".");

						if (complete.charAt(col1) == '1') {
							puzzle[row.intValue()][col1] = '0';
							puzzle[row.intValue()][col2] = '1';
						} else {
							puzzle[row.intValue()][col1] = '1';
							puzzle[row.intValue()][col2] = '0';
						}

						return true;
					}
				}
			}
		}

		List<String> completeColumns = new ArrayList<>();
		Map<Integer, String> candidateColumns = new HashMap<>();

		for (int col = 0; col < puzzle.length; col++) {
			StringBuilder columnSB = new StringBuilder();
			int blankCount = 0;
			for (int row = 0; row < puzzle.length; row++) {
				columnSB.append(puzzle[row][col]);
				if (puzzle[row][col] == '.') {
					blankCount++;
				}
			}
			String columnText = columnSB.toString();
			if (blankCount == 0) {
				completeColumns.add(columnText);
			} else if (blankCount == 2) {
				candidateColumns.put(col, columnText);
			}
		}

		if (!completeColumns.isEmpty() && !candidateColumns.isEmpty()) {
			for (Integer col : candidateColumns.keySet()) {
				String colText = candidateColumns.get(col);

				for (String complete : completeColumns) {
					boolean match = true;

					for (int i = 0; i < colText.length() && match; i++) {
						if (colText.charAt(i) != complete.charAt(i) && colText.charAt(i) != '.') {
							match = false;
						}
					}

					if (match) {
						int row1 = colText.indexOf(".");
						int row2 = colText.lastIndexOf(".");

						if (complete.charAt(row1) == '1') {
							puzzle[row1][col.intValue()] = '0';
							puzzle[row2][col.intValue()] = '1';
						} else {
							puzzle[row1][col.intValue()] = '1';
							puzzle[row2][col.intValue()] = '0';
						}

						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * Apply step 5: A cell that cannot legally contain one value must contain its
	 * opposite.
	 * 
	 * @param puzzle
	 * @return true if applied
	 */
	public static boolean step5(char[][] puzzle) {
		int[] columnOnes = new int[puzzle.length];
		int[] columnZeroes = new int[puzzle.length];

		for (int i = 0; i < puzzle.length; i++) {
			columnOnes[i] = 0;
			columnZeroes[i] = 0;
		}

		// check rows first; count for columns while doing so
		for (int row = 0; row < puzzle.length; row++) {
			int ones = 0;
			int zeroes = 0;

			for (int col = 0; col < puzzle.length; col++) {
				if (puzzle[row][col] == '1') {
					ones++;
					columnOnes[col]++;
				} else if (puzzle[row][col] == '0') {
					zeroes++;
					columnZeroes[col]++;
				}
			}

			// attempt to apply rule when one short of the quota
			if (ones == (puzzle.length / 2) - 1) {
				// for each dot, set a 1, then a 0 to all other dots
				for (int col = 0; col < puzzle.length; col++) {
					// make a copy to avoid corrupting the real puzzle
					char[][] puzzleCopy = copy(puzzle);
					
					if(puzzleCopy[row][col] == '.') {
						puzzleCopy[row][col] = '1';
						for (int col2 = 0; col2 < puzzle.length; col2++) {
							if(puzzleCopy[row][col2] == '.') {
								puzzleCopy[row][col2] = '0';
							}
						}
						
						if(!isLegal(puzzleCopy)) {
							// rule violation found; that cell cannot contain a 1
							puzzle[row][col] = '0';
							return true;
						}
					}
				}
			}
			if (zeroes == (puzzle.length / 2) - 1) {
				// for each dot, set a 0, then a 1 to all other dots
				for (int col = 0; col < puzzle.length; col++) {
					// make a copy to avoid corrupting the real puzzle
					char[][] puzzleCopy = copy(puzzle);
					
					if(puzzleCopy[row][col] == '.') {
						puzzleCopy[row][col] = '0';
						for (int col2 = 0; col2 < puzzle.length; col2++) {
							if(puzzleCopy[row][col2] == '.') {
								puzzleCopy[row][col2] = '1';
							}
						}
						
						if(!isLegal(puzzleCopy)) {
							// rule violation found; that cell cannot contain a 0
							puzzle[row][col] = '1';
							return true;
						}
					}
				}
			}
		}

		// check column quotas
		for (int col = 0; col < puzzle.length; col++) {
			if (columnOnes[col] == (puzzle.length / 2) - 1) {
				// for each dot, set a 1, then a 0 to all other dots
				for (int row = 0; row < puzzle.length; row++) {
					// make a copy to avoid corrupting the real puzzle
					char[][] puzzleCopy = copy(puzzle);
					
					if(puzzleCopy[row][col] == '.') {
						puzzleCopy[row][col] = '1';
						for (int row2 = 0; row2 < puzzle.length; row2++) {
							if(puzzleCopy[row2][col] == '.') {
								puzzleCopy[row2][col] = '0';
							}
						}
						
						if(!isLegal(puzzleCopy)) {
							// rule violation found; that cell cannot contain a 1
							puzzle[row][col] = '0';
							return true;
						}
					}
				}
			}
			if (columnZeroes[col] == (puzzle.length / 2) - 1) {
				// for each dot, set a 1, then a 0 to all other dots
				for (int row = 0; row < puzzle.length; row++) {
					// make a copy to avoid corrupting the real puzzle
					char[][] puzzleCopy = copy(puzzle);
					
					if(puzzleCopy[row][col] == '.') {
						puzzleCopy[row][col] = '0';
						for (int row2 = 0; row2 < puzzle.length; row2++) {
							if(puzzleCopy[row2][col] == '.') {
								puzzleCopy[row2][col] = '1';
							}
						}
						
						if(!isLegal(puzzleCopy)) {
							// rule violation found; that cell cannot contain a 0
							puzzle[row][col] = '1';
							return true;
						}
					}
				}
			}
		}

		return false;
	}
	
	public static char[][] copy(char[][] puzzle){
		char[][] copy = new char[puzzle.length][puzzle.length];
		
		for (int row = 0; row < puzzle.length; row++) {
			copy[row] = new char[puzzle.length];
			for (int col = 0; col < puzzle.length; col++) {
				copy[row][col] = puzzle[row][col];
			}
		}
		
		return copy;
	}
	
	public static boolean isLegal(char[][] puzzle) {
		int[] oneColumnCounts = new int[puzzle.length];
		int[] zeroColumnCounts = new int[puzzle.length];
		StringBuilder[] columnSBs = new StringBuilder[puzzle.length];
		List<String> rows = new ArrayList<>();

		for (int i = 0; i < puzzle.length; i++) {
			oneColumnCounts[i] = 0;
			zeroColumnCounts[i] = 0;
			columnSBs[i] = new StringBuilder();
		}

		for (int row = 0; row < puzzle.length; row++) {
			int oneRowCount = 0;
			int zeroRowCount = 0;
			for (int col = 0; col < puzzle.length; col++) {
				columnSBs[col].append(puzzle[row][col]);
				if (puzzle[row][col] == '1') {
					oneColumnCounts[col]++;
					oneRowCount++;
				} else if(puzzle[row][col] == '0') {
					zeroColumnCounts[col]++;
					zeroRowCount++;
				}
			}
			if (oneRowCount > puzzle.length / 2) {
				return false;
			}
			if (zeroRowCount > puzzle.length / 2) {
				return false;
			}
			String rowText = new String(puzzle[row]);
			if(rowText.contains("111") || rowText.contains("000")) {
				return false;
			}
			if(rows.contains(rowText) && !rowText.contains(".")) {
				return false;
			}
			rows.add(rowText);
		}

		List<String> columns = new ArrayList<>();
		for (int i = 0; i < puzzle.length; i++) {
			if (oneColumnCounts[i] > puzzle.length / 2) {
				return false;
			}
			if (zeroColumnCounts[i] > puzzle.length / 2) {
				return false;
			}
			String colText = columnSBs[i].toString();
			if(colText.contains("111") || colText.contains("000")) {
				return false;
			}
			if(columns.contains(colText) && !colText.contains(".")) {
				return false;
			}
			columns.add(colText);
		}

		return true;
	}
	
	public static String toString(char[][] puzzle) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < puzzle.length; i++) {
			sb.append(new String(puzzle[i]));
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
