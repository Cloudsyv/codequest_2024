import java.util.*;

public class Sum_It_Up {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(" ");
                int[] num = new int[line.length];
                for (int i = 0; i < line.length; i++) {
                    num[i] = Integer.parseInt(line[i]);
                }
                if (num[0] != num[1]) {
                  System.out.println(Sum(num[0], num[1]));
                } else {
                  System.out.println(squareOfSum(num[0], num[1]));
                }
            }
        }
    }
    public static int Sum(int num1, int num2) {
      return num1 + num2;  
    }
    public static int squareOfSum(int num1, int num2) {
      return (num1 + num2) * 2;
    }
}
