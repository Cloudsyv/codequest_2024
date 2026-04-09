import java.util.*;

public class Fibbing_Fibonacci_Byteman {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                int number = input.nextInt();
                if (number == 0) {
                  System.out.println("TRUE");
                  continue;
                }
                int num1 = 0;
                int num2 = 1;
                while (num2 < number) {
                  int num3 = num1 + num2;
                  num1 = num2;
                  num2 = num3;
                }
                if (num2 == number) {
                  System.out.println("TRUE");
                } else {
                  System.out.println("FALSE");
                }
            }
        }
    }
}
