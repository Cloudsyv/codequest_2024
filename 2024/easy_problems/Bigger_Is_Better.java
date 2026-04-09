package finished;
import java.util.Scanner;

public class Bigger_Is_Better {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for (int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(" ");
                int[] givenNums = new int[line.length]; 
                for (int i = 0; i < line.length; i++) {
                    givenNums[i] = Integer.parseInt(line[i]); 
                }
                int highestNum = givenNums[0];
                for (int index = 1; index < givenNums.length; index++) {
                    if (highestNum < givenNums[index]) {
                        highestNum = givenNums[index];
                    }
                }
                System.out.println(highestNum);
            }
        }
    }
}
