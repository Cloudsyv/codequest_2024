import java.util.*;

public class Leap_Year {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                int num = input.nextInt();
                for (int i = 0; i < num; i++) {
                  int year = input.nextInt();
                  if (year < 1592)
                    System.out.println("No");
                  else if (year % 4 != 0)
                    System.out.println("No");
                  else if (year % 100 != 0)
                    System.out.println("Yes");
                  else if (year % 400 != 0)
                    System.out.println("No");
                  else 
                    System.out.println("Yes");
                }
            }
        }
    }
}
