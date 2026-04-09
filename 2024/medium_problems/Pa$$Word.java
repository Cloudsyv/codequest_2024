import java.util.Scanner;
// import java.io.IOException;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.ArrayList;

public class Pa$$Word {
    private static final String INVALID = "INVALID";
    private static final String VALID = "VALID";

    /**
    * Read standard input to get the values
    */
    public static void main(String[] args) {
        // First, connect to he standard input channel
        // This "try-with-resources" block will automatically close
        // the Scanner when we're done using it (even if your program throws an exception)
        try (Scanner testCases = new Scanner(System.in)) {
            int numOfTestCases = Integer.parseInt(testCases.nextLine());
            for (int testCase = 0; testCase < numOfTestCases; testCase++) {
                String candidatePassword = testCases.nextLine();
                if (isPasswordValid(candidatePassword)) {
                    System.out.println(VALID);
                } else {
                    System.out.println(INVALID);
                }
            }
        }
    }
    /**
     * Returns true if the candidate meets the password requirements
     */
    public static boolean isPasswordValid (String candidate) {
        // check length
        if (candidate.length() < 8) {
            return false;
        }
  
        // check for required Uppercase characters
        int numCharacterRequirementsUsed = 0;
        String upperRegex = ".*[A-Z].*";
        boolean containsUpper = candidate.matches(upperRegex);
        if (containsUpper) {
            ++numCharacterRequirementsUsed;
        }
        // Check for required Lowercase characters
        if (candidate.matches(".*[a-z].*")) {
            ++numCharacterRequirementsUsed;
        }
        //Check for required Numeric characters
        if (candidate.matches(".*[0-9].*")) {
            ++numCharacterRequirementsUsed;
        }
        // Check for required Special characters
        if (candidate.matches(".*[^0-9A-Za-z].*")) {
            ++numCharacterRequirementsUsed;
        }
        // Check for required number of combinations
        if (numCharacterRequirementsUsed < 3) {
            return false;
        }
  
        //Check repeat characters
        for (int i = 0; i < candidate.length() - 2; ++i) {
            if ((candidate.charAt(i) == candidate.charAt(i + 1)) && (candidate.charAt(i) == candidate.charAt(i + 2))) {
                return false;
            }
        }
        return true;
    }
}
