package finished;
import java.util.Scanner;

public class Caught_Spending {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for (int testcase = 0; testcase < testCases; testcase++) {
                String[] str = input.nextLine().toLowerCase().split(" ");
                int speed = Integer.parseInt(str[0]);
                boolean birthday = Boolean.parseBoolean(str[1]);
                int noTicket = 60;
                int smallTicket_min = 61;
                int smallTicket_max = 80;
                int bigTicket = 81;
                
                
                if (birthday) {
                    noTicket += 5;
                    smallTicket_min += 5; 
                    smallTicket_max += 5; 
                    bigTicket += 5;
                }
                
                if (speed <= 60) {
                    System.out.println("no ticket");
                } else if (speed >= smallTicket_min && speed <= smallTicket_max) {
                    System.out.println("small ticket");
                } else if (speed >= bigTicket) {
                    System.out.println("big ticket");
                }
            }
        }
    }
}