import java.util.*;

public class Fibonacci {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                int number = input.nextInt();
                if (number == 0) {
                    System.out.println("TRUE");
                    continue;
                }
                long num1 = 0;
                long num2 = 1;
                for (int i = 1; i < number; i++) {
                    long num3 = num1 + num2;
                    num1 = num2;
                    num2 = num3;
                }
                System.out.println(number + " = " + num1);
            }
        }
    }
}
