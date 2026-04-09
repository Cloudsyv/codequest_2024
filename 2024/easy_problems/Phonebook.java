import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(" ");
                String phoneNumber = line[0];
                String format = line[1];
                if (format.equals("PARENTHESES"))
                  System.out.println("(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6));
                else if (format.equals("DASHES"))
                  System.out.println(phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6));
                else if (format.equals("PERIODS"))
                  System.out.println(phoneNumber.substring(0, 3) + "." + phoneNumber.substring(3, 6) + "." + phoneNumber.substring(6));
            }
        }
    }
}
