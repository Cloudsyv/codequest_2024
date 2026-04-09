import java.util.*;

public class competition_format {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(" ");
                boolean gorillaOne = Boolean.parseBoolean(line[0]);
                boolean gorillaTwo = Boolean.parseBoolean(line[1]);
                System.out.println(gorillaOne == gorillaTwo);
            }
        }
    }
}
