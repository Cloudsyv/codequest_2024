import java.util.*;

public class Positive_Negative {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                int num = input.nextInt();
                if (num > 0)
                  System.out.println("POSITIVE");
                else if (num < 0)
                  System.out.println("NEGATIVE");
            }
        }
    }
}
