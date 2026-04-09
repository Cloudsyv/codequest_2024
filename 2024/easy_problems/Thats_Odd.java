import java.util.*;

public class Thats_Odd {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                int num = input.nextInt();
                System.out.println(num % 2 == 0?"EVEN":"ODD");
            }
        }
    }
}
