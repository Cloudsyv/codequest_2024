import java.util.*;

public class Stalling_Out {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                String[] line = input.nextLine().split(" ");
                double critical = Double.parseDouble(line[0]);
                double port =  Double.parseDouble(line[1]);
                double starBoard =  Double.parseDouble(line[2]);
                if (Math.abs(port - starBoard) > 5)
                    System.out.println("WARNING");
                else if ((port + starBoard) / 2 >= critical + 2) 
                    System.out.println("ALARM");
                else
                    System.out.println("OK");
            }
        }
    }
}
