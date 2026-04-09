import java.util.*;

public class NotSoSelfDriving {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for (int testcase = 0; testcase < testCases; testcase++) {
              String[] VandX = input.nextLine().split(":");
              double V = Double.parseDouble(VandX[0]);
              double X = Double.parseDouble(VandX[1]);

              if (X/V <= 1){
                System.out.println("SWERVE");
              } else if (X/V <= 5){
                System.out.println("BRAKE");
              } else {
                System.out.println("SAFE");
              }
            }
        }
    }
}
