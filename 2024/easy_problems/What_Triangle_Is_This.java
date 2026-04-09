import java.util.*;

public class What_Triangle_Is_This {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for (int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(", ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                int c = Integer.parseInt(line[2]);
                int max = Math.max(a, Math.max(b, c));
                int min = Math.min(a, Math.min(b, c));
                int mid = a + b + c - min - max;
                if (min + mid <= max)
                    System.out.println("Not a Triangle");
                else if (min == max)
                    System.out.println("Equilateral");
                else if (min == mid || mid == max)
                    System.out.println("Isosceles");
                else
                    System.out.println("Scalene");
            }
        }
    }
}
