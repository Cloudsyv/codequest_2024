package finished;
import java.util.Scanner;

public class Addiply {
    public static void main (String[] args) {
        try(Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] elements = input.nextLine().split(" ");
                int firstNum = Integer.parseInt(elements[0]);
                int secondNum = Integer.parseInt(elements[1]);
                System.out.println((firstNum + secondNum) + " " + (firstNum * secondNum));
            }
        }
    }
}
