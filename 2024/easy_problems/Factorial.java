import java.util.Scanner;

class Factorial {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                long userInput = input.nextLong();
                if (userInput > 0) {
                    System.out.println(factorial(userInput));
                } else {
                  System.out.println(0);
                }
            }
        }
    }
    public static long factorial(long num) {
        if (num > 1) {
            return num * factorial(num - 1);
        } else {
            return 1;
        }
    }
}
