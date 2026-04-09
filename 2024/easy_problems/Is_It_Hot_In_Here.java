import java.util.*;

public class Is_It_Hot_In_Here {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                int num = input.nextInt();
                for (int i = 0; i < num; i++) {
                  String temperature = input.next();
                  String scale = input.next();
                  String newScale = scale.equals("C")?"F":"C";
                  double newTemperature = 0;
                  if (scale.equals("C")) {
                    newTemperature = 9.0 / 5 * Double.parseDouble(temperature) + 32;
                  } else if (scale.equals("F")) {
                    newTemperature = 5.0 / 9 * (Double.parseDouble(temperature) - 32);
                  }
                  System.out.printf("%s %s = %.1f %s%n", temperature, scale, newTemperature, newScale);
                }
            }
        }
    }
}
