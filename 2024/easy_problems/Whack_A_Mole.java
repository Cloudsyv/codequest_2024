import java.util.*;

public class Whack_A_Mole {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String output = "";
                String[] line = input.nextLine().split(" ");
                for (int i = 0; i < 9; i++) {
                    String position = line[i];
                    if (position.equals("M")) {
                        output += (i + 1) + " ";
                    }
                }
                System.out.println(output.trim());
            }
        }
    }
}
