import java.util.Scanner;

public class Batter_Up {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {

                //split the name from the labelled scores by a colon
                String[] line = input.nextLine().split(":");
                //split score into its specific categories by a comma
                String[] scores = line[1].split(",");
                double atBats = 0;
                int total = 0;

                for (int i = 0; i < scores.length; i++) {
                    switch (scores[i]) {
                        case "1B":
                            total += 1;
                            atBats++;
                            break;
                        case "2B":
                            total += 2;
                            atBats++;
                            break;
                        case "3B":
                            total += 3;
                            atBats++;
                            break;
                        case "HR":
                            total += 4;
                            atBats++;
                            break;
                        case "K":
                            atBats++;
                            break;
                    }   
                }
                double SLG = total / atBats;
                if (atBats == 0)
                    SLG = 0;
                System.out.printf(line[0] + "=%.3f%n", SLG);
            }
        }
    }
}
