import java.util.*;

public class Around_And_Around {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for (int testcase = 0; testcase < testCases; testcase++) {
                int altitude = input.nextInt();
                System.out.printf("%.1f%n", 40075 + altitude * 2 * Math.PI);
            }
        }
    }
}
