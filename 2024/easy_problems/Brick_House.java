import java.util.Scanner;

class Brick_House {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                //take in the user input and split the string of numbers apart
                String[] line = input.nextLine().split(" ");
                int smallBricks = Integer.parseInt(line[0]);
                int largeBricks = Integer.parseInt(line[1]);
                int target = Integer.parseInt(line[2]);

                target = target - 5 * Math.min(largeBricks, target / 5);

                //compare what's left, if smallbrick is more, then print true, else false
                if (target <= smallBricks) {
                    System.out.println(true);
                } else {
                    System.out.println(false);
                }
            }
        }
    }
}
