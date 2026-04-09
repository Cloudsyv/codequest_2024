import java.util.*;

public class Who_Sells_More_News_Papers {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(" ");
                int times = Integer.parseInt(line[0]);
                int herald = Integer.parseInt(line[1]);
                if (times > herald)
                    System.out.println("Times has " + (times - herald) + " more subscribers");
                else if (times < herald)
                    System.out.println("Herald has " + (herald - times) + " more subscribers");
                else
                    System.out.println("Times and Herald have the same number of subscribers");
            }
        }
    }
}
