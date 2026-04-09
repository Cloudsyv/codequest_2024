import java.util.*;

public class StallingOut {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for (int testcase = 0; testcase < testCases; testcase++) {
                // String[] SensoryDegrees = input.nextLine().split(" ");

                // double TotalValue = 0;
                // int Total = 0;
                // //boolean GreaterThan5 = false;
                // double SensOG = Double.parseDouble(SensoryDegrees[0]);
                // double Sens1 = Double.parseDouble(SensoryDegrees[0]);
                // for (int i = 0; i < SensoryDegrees.length-1; i++){
                //     double Sens1 = Double.parseDouble(SensoryDegrees[i]);
                //     double Sens2 = Double.parseDouble(SensoryDegrees[i+1]);

                //     TotalValue+= Math.abs(Sens1-Sens2);
                //     Total++;
                //     if (Math.abs(Sens1-Sens2) > 5 || Math.abs(SensOG-Sens2) > 5){
                //          System.out.println("ALARM");
                //          //GreaterThan5 = true;
                //          return;
                //     }
                // }

                // System.out.println((TotalValue)/Total);
                // if (((TotalValue-Math.abs(SensOG-))/Total) >= 2){
                //     System.out.println("WARNING");
                // } else {
                //     System.out.println("OK");
                // }
            }
        }
    }
}
