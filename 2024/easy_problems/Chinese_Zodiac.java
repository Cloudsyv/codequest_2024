import java.util.Scanner;
import java.util.*;

class Chinese_Zodiac {
  public static void main(String[] args) {
        try (Scanner Scanner = new Scanner(System.in)) {
            int testCases = Integer.parseInt(Scanner.nextLine());
            ArrayList<String> Combinations = new ArrayList<String>();
            String[] Elements = {"Wood", "Fire", "Earth", "Metal", "Water"};
            String[] Animals = {"Rat", "Ox", "Tiger", "Rabbit", "Dragon", "Snake", "Horse", "Goat", "Monkey", "Rooster", "Dog", "Pig"};
            
            for (int i = 0; i < testCases; i++){
              int Year = Scanner.nextInt();
              if (Year % 2 == 0){
                Combinations.add(Year + " Yang");
              } else {
                Combinations.add(Year + " Yin");
              }
              String ElementCoordinate = Elements[(int) ((Year - 4) % 10) / 2];
              String AnimalCoordinate = Animals[(Year - 4) % 12];
              Combinations.set(i, Combinations.get(i) + " " + ElementCoordinate + " " + AnimalCoordinate);
            }
            
            for (int i = 0; i < Combinations.size(); i++) {
              System.out.println(Combinations.get(i));
            }
        }
    }
}
