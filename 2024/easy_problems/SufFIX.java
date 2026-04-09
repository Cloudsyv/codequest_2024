import java.util.*;

public class SufFIX {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String str = input.nextLine();
                str = str.replaceAll("\\D", "");
                if (str.endsWith("1") && !("0" + str).endsWith("11"))
                    System.out.println(str + "st");
                else if (str.endsWith("2") && !("0" + str).endsWith("12")) {
                    System.out.println(str + "nd");
                } else if (str.endsWith("3") && !("0" + str).endsWith("13")) {
                    System.out.println(str + "rd");
                } else {
                    System.out.println(str + "th");
                }
            }
        }
    }
}
