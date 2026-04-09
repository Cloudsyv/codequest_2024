import java.util.*;

public class Ship_Health_Summary {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            ArrayList<Double> answers = new ArrayList<Double>();
            for(int testcase = 0; testcase < testCases; testcase++) {
                String line = input.nextLine();
                int index = Integer.parseInt(line);
                int total = 0;
                int weights = 0;
                for (int i = 0; i < index; i++) {
                    String a = input.nextLine();
                    String[] arr = a.split(" ");
                    int num = Integer.parseInt(arr[1]);
                    if (arr[0].equals("LOW")) {
                        total += num;
                        weights++;
                    }
                    if (arr[0].equals("MEDIUM")) {
                        total += 2 * num;
                        weights += 2;
                    }
                    if (arr[0].equals("HIGH")) {
                        total += 3 * num; 
                        weights += 3;
                    }
                }
                double average = (double) total / weights;
                average *= 10;
                if (average % 1 >= 0.5) {
                    average += 0.5;
                }
                average = Math.floor(average);
                answers.add(average);
            }
            for (double a : answers) {
                System.out.println((int) a);
            }
        }
    }
}
