import java.util.Scanner;
import java.math.BigInteger;

public class Grains_Of_Sand {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                int number = input.nextInt();
                BigInteger sand = new BigInteger("0");
                for (int i = 0; i < number; i++) {
                  sand = sand.add(input.nextBigInteger());
                }
                System.out.println(sand.toString());
            }
        }
    }
}
