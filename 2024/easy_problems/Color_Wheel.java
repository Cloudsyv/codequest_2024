import java.util.Scanner;

public class Color_Wheel {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for(int testcase = 0; testcase < testCases; testcase++) {
                /*The primary colors are:
                    Red, Green, Blue
                */
                
                //store user input
                String wanted_color = input.nextLine().toLowerCase();

                if (wanted_color.indexOf("green") >= 0) {
                    System.out.println("In order to make " + wanted_color + ", blue and yellow must be mixed.");
                } 
                if (wanted_color.indexOf("orange") >= 0) {
                    System.out.println("In order to make " + wanted_color + ", red and yellow must be mixed.");
                } 
                if (wanted_color.indexOf("violet") >= 0) {
                    System.out.println("In order to make " + wanted_color + ", blue and red must be mixed.");
                } 
                if (wanted_color.equals("yellow")) {
                    System.out.println ("No colors need to be mixed to make " + wanted_color.toLowerCase() + ".");
                }
                if (wanted_color.equals("red")) {
                    System.out.println("No colors need to be mixed to make " +  wanted_color.toLowerCase() + ".");
                }
                if (wanted_color.equals("blue")) {
                    System.out.println("No colors need to be mixed to make " +  wanted_color.toLowerCase() + ".");
                }
            }
        }
    }
}
