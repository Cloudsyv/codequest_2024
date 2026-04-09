import java.util.*;

public class Palindrome_Series {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                int num = input.nextInt();
                boolean all = true;
                ArrayList<Integer> indexes = new ArrayList<>();
                for (int i = 1; i <= num; i++) {
                    String s = input.next().toLowerCase();
                    StringBuilder sb = new StringBuilder(s);
                    if (!sb.toString().equals(sb.reverse().toString()))
                    {
                        all = false;
                        indexes.add(i);
                    }
                }
                if (all) {
                  System.out.println("True");
                } else {
                  System.out.print("False - ");
                  for (int i = 0; i < indexes.size(); i++) {
                    if (i != 0) {
                      System.out.print(", ");
                    }
                    System.out.print(indexes.get(i));
                  }
                  System.out.println();
                }
            }
        }
    }
}
