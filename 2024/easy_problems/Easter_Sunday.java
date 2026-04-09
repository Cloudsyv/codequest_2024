import java.util.*;

public class Easter_Sunday {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                //store the inputted year
                int year = Integer.parseInt(input.nextLine());

                //declare the month
                int month = 3;

                //calculate the rules to find the data using Carl Guass's algorithm
                double a = year % 19;
                double b = year % 4;
                double c = year % 7;
                double k = Math.floor(year/100);
                double p = Math.floor((13+8*k)/25);
                double q = Math.floor(k/4);
                double m = (15 - p + k - q) % 30;
                double n = (4 + k - q) % 7;
                double d = (19 * a + m) % 30;
                double e = (2 * b + 4 * c + 6 * d + n) % 7;
                double f = (11 * m + 11) % 30;
                
                double date = 22 + d + e;
                int day = (int) date;

                if (day <= 31) {
                    month = 3;
                } else if (day > 31) {
                    day -= 31;
                    month = 4;
                }

                if (d == 29 && e == 6) {
                    month = 4;
                    day = 19;
                } else if (d == 28 && e == 6 && f < 19) {
                    month = 4;
                    day = 18;
                }

                if (day < 10) {
                    System.out.println(year + "/0" + month + "/0" + day); 
                } else {
                    System.out.println(year + "/0" + month + "/" + day);
                }
            }
        }
    }
}
