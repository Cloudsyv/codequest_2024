import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Mobile_Miser {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String str = input.nextLine();
                BigDecimal d = new BigDecimal(str.substring(1));
                System.out.println("Total of the bill: " + str);
                BigDecimal tip15 = d.multiply(new BigDecimal("0.15"));
                tip15 = tip15.setScale(2, RoundingMode.HALF_UP);
                BigDecimal tip18 = d.multiply(new BigDecimal("0.18"));
                tip18 = tip18.setScale(2, RoundingMode.HALF_UP);
                BigDecimal tip20 = d.multiply(new BigDecimal("0.20"));
                tip20 = tip20.setScale(2, RoundingMode.HALF_UP);
                System.out.println("15% = $" + tip15);
                System.out.println("18% = $" + tip18);
                System.out.println("20% = $" + tip20);
            }
        }
    }
}
