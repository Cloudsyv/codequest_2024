import java.util.ArrayList;
import java.util.Scanner;

public class Normal_Math {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)){
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String Information[] = input.nextLine().split(" ");
                // Matrix size
                int M = Integer.parseInt(Information[0]), N = Integer.parseInt(Information[1]);

                // Matrix values
                ArrayList<Integer> Numbers = new ArrayList<Integer>();

                for (int i = 0; i < M; i++){
                    String RowContent[] = input.nextLine().split(" ");
                    for (int v = 0; v < N; v++) {
                        Numbers.add(Integer.parseInt(RowContent[v]));
                    }
                }

                // Math
                double Total = 0;
                for (int i = 0; i < Numbers.size(); i++){
                    Total += Math.pow(Math.abs(Numbers.get(i)), 2);
                }

                System.out.println(String.format("%.2f", (double) Math.round(Math.sqrt(Total)*100)/100));
            }
        }
    }
}