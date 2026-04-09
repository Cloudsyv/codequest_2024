import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Manipulation_For_Mass {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(" ");
                Double d = new Double(line[0]);
                Double v = new Double(line[1]);
                BigDecimal density = BigDecimal.valueOf(d);
                BigDecimal volume = BigDecimal.valueOf(v);
                BigDecimal mass = density.multiply(volume);
                mass = mass.setScale(2, RoundingMode.HALF_UP);
                System.out.println(mass.toString());
            }
        }
    }
}
