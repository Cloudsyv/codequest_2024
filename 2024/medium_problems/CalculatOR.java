import java.util.Scanner;

public class CalculatOR {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(" ");
                double frontNum = Double.parseDouble(line[0]);
                String operator = line[1];
                double backNum = Double.parseDouble(line[2]);
        
                if (operator.equals("+")) {
                    System.out.printf("%.1f %.1f\n", frontNum + backNum, backNum + frontNum);
                } else if (operator.equals("-")) {
                    System.out.printf("%.1f %.1f\n", frontNum - backNum, backNum - frontNum);
                } else if (operator.equals("*")) {
                    System.out.printf("%.1f %.1f\n", frontNum * backNum, backNum * frontNum);
                } else if (operator.equals("/")) {
                    System.out.printf("%.1f %.1f\n", frontNum / backNum, backNum / frontNum);
                }
            }
        }
    }
}
