import java.util.*;

public class Time_And_Time_Again {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String line = input.nextLine();
                int hour = 0, minute = 0, second = 0;
                if (line.contains("h")) {
                    int index = line.indexOf("h");
                    hour = Integer.parseInt(line.substring(index - 1, index));
                    if (index > 1 && Character.isDigit(line.charAt(index - 2))) {
                        hour += 10 * Integer.parseInt(line.substring(index - 2, index - 1));
                    }
                }
                if (line.contains("m")) {
                    int index = line.indexOf("m");
                    minute = Integer.parseInt(line.substring(index - 1, index));
                    if (index > 1 && Character.isDigit(line.charAt(index - 2))) {
                        minute += 10 * Integer.parseInt(line.substring(index - 2, index - 1));
                    }
                }
                if (line.contains("s")) {
                    int index = line.indexOf("s");
                    second = Integer.parseInt(line.substring(index - 1, index));
                    if (index > 1 && Character.isDigit(line.charAt(index - 2))) {
                        second += 10 * Integer.parseInt(line.substring(index - 2, index - 1));
                    }
                }
                System.out.printf("%02d:%02d:%02d\n", hour, minute, second);
            }
        }
    }
}
