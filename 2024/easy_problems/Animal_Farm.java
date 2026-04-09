package finished;
import java.util.Scanner;

public class Animal_Farm {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for (int testcase = 0; testcase < testCases; testcase++) {
                String[] turkeys_goats_horses = input.nextLine().split(" ");
                int turkeys = Integer.parseInt(turkeys_goats_horses[0]);
                int goats = Integer.parseInt(turkeys_goats_horses[1]);
                int horses = Integer.parseInt(turkeys_goats_horses[2]);

                int turkeys_legs = turkeys * 2;
                int goats_legs = goats * 4;
                int horses_legs = horses * 4;

                System.out.println(turkeys_legs + goats_legs + horses_legs);
            }
        }
    }
}
