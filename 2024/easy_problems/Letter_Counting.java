import java.util.*;

public class Letter_Counting {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String str = input.nextLine();
                System.out.println(str.length() + 1);
            }
        }
    }
}
