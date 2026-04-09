import java.util.*;

public class Look_After_The_Pennies {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                int num = input.nextInt();
                double savings = 0;
                for (int i = 0; i < num; i++) {
                  double decimal = input.nextDouble();
                  System.out.println((int) Math.ceil(decimal));
                  savings += Math.ceil(decimal) - decimal;
                }
              System.out.printf("%.2f%n", savings);
            }
        }
    }
}
