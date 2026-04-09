import java.util.*;

public class Space_Station_Repair_Lights {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(" ");
                String output = "";
                int index = 0;
                for (int i = 0; i < 2; i++) {
                    String a = line[index];
                    String b = line[index + 1];
                    if (a.equals("WORKING") && b.equals("WORKING"))
                        output += "off ";
                    else if (a.equals("WORKING") && b.equals("BROKEN"))
                        output += "red ";
                    else if (a.equals("BROKEN") && b.equals("WORKING"))
                        output += "green ";
                    else if (a.equals("BROKEN") && b.equals("BROKEN"))
                        output += "blue ";
                    index += 2;
                }
                System.out.println(output.trim());
            }
        }
    }
}
