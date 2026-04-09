import java.util.*;

public class Something_Is_Missing {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(" ");
                String str = line[0];
                int num = Integer.parseInt(line[1]);
                System.out.println(str.substring(0, num) + str.substring(num + 1));
            }
        }
    }
}
