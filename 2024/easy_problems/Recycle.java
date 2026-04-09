import java.util.Scanner;

public class Recycle {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(" ");
                int aluminum = Integer.parseInt(line[0]);
                int plastic = Integer.parseInt(line[1]);
                int glass = Integer.parseInt(line[2]);
                double total = aluminum * 0.05 * 31 + plastic * 0.1 * 15 + glass * 0.2 / 2;
                System.out.printf("$%.2f%n", total);
            }
        }
    }
}
