import java.util.*;

public class Detecting_Multipaction {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] arrayOne = input.nextLine().split(" ");
                String[] arrayTwo = input.nextLine().split(" ");

                String answer = "";
                int counter = 0;

                for (int i = 0; i < arrayOne.length; i++) {
                  if (Double.parseDouble(arrayOne[i]) >= 0.6 && Double.parseDouble(arrayOne[i]) <= 0.85 && Double.parseDouble(arrayTwo[i]) >= 0.6 && Double.parseDouble(arrayTwo[i]) <= 0.85) {
                      answer += Integer.toString(i) + " ";
                      counter++;
                  }
                }
                if (answer.length() == 0) {
                  System.out.println("No multipaction events detected.");
                  continue;
                }
                String fin = answer.substring(0, answer.length() - 1);
                if (counter == 1) {
                  System.out.println("A multipaction event was detected at time index " + fin + ".");
                } else {
                  System.out.println(Integer.toString(counter) + " multipaction events were detected at time indices: " + fin + ".");
                  continue;
                }
            }
        }
    }
}
