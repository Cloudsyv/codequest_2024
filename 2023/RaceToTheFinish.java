import java.util.*;

public class RaceToTheFinish {
    public static int[] GetIndex(String SearchValue, String[][] RefArray){
        for (int i = 0; i < RefArray.length; i++){
            for (int v = 0; v < RefArray[i].length; v++){
                if (RefArray[i][v].equals(SearchValue)){
                    return new int[]{i,v};
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] Rotate(int[] curIndex, int[] curDir, String[][] RefArray){
        // Rotates 90 degrees

        if (curIndex[0]-curDir[0] == 0){ // X Axis
            System.out.println("X: "+(curIndex[1]-curDir[1]));
            if (curIndex[1]-curDir[1] >= 0){ // Left
                System.out.println("Set upwards");
                return new int[]{curIndex[0]+1, curIndex[1]}; // Set Upwards
            } else { // Right
                System.out.println("Set Below");
                return new int[]{curIndex[0]-1, curIndex[1]}; // Set Below
            }
        } else { // Y Axis
            System.out.println("Y: "+(curIndex[0]-curDir[0]));
            if (curIndex[0]-curDir[0] >= 0){ // Above
                System.out.println("Set right");
                return new int[]{curIndex[0], curIndex[1]+1}; // Set Right
            } else { // Below
                System.out.println("Set Left");
                return new int[]{curIndex[0], curIndex[1]-1}; // Set Left
            }
        }
    }

    public static int[] Move(int[] CurIndex, int[] NewIndex, String[][] RefArray){
        // Checks if theres a space and if so moves it
        // EndZone = (-1, -1)
        //System.out.println(RefArray[NewIndex[0]][NewIndex[1]]);
        if (RefArray[NewIndex[0]][NewIndex[1]].equals(" ")){
            return NewIndex;
        } else if (RefArray[NewIndex[0]][NewIndex[1]].equals("$")){
            return new int[]{-1, -1};
        } else {
            return CurIndex;
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int testCases = Integer.parseInt(input.nextLine());
            for (int testcase = 0; testcase < testCases; testcase++) {
                String[] str = input.nextLine().split(" ");
                int Y = Integer.parseInt(str[0]);
                int X = Integer.parseInt(str[1]);

                // Convert to 2D array
                String[][] Maze = new String[Y][X];
                
                for (int i = 0; i < Y; i++){
                    String RowText = input.nextLine();
                    for (int v = 0; v < RowText.length(); v++){
                        Maze[i][v] = RowText.substring(v, v+1);
                    }
                }

                // Make weighted 2D Array
                int[][] Weighted2DArray = new int[Y][X];
                for (int i = 0; i < Weighted2DArray.length; i++){
                    for (int v = 0; v < Weighted2DArray[i].length; v++){
                        Weighted2DArray[i][v] = 0;
                    }
                }

                // Start loop
                int[] StartIndex = GetIndex("C", Maze); // (1,2)
                int[] FacingIndex = new int[]{StartIndex[0]-1, StartIndex[1]};
                Weighted2DArray[StartIndex[0]][StartIndex[1]] = -1;

                System.out.println(StartIndex[0]+", "+StartIndex[1]);

                int[] CurIndex = StartIndex;
                while (Move(CurIndex, FacingIndex, Maze) != new int[]{-1, -1}){ // If not at end then move
                    System.out.println("MOVING: "+CurIndex[0]+", "+CurIndex[1] + " / "+Maze[CurIndex[0]][CurIndex[1]]);
                    while (Move(CurIndex, FacingIndex, Maze) == CurIndex){ // If Not moving then rotate
                        System.out.println(FacingIndex[0] +", "+ FacingIndex[1]);
                        FacingIndex = Rotate(CurIndex, FacingIndex, Maze);
                        Weighted2DArray[CurIndex[0]][CurIndex[1]] += 1;
                    }
                    CurIndex = Move(StartIndex, FacingIndex, Maze);
                    Weighted2DArray[CurIndex[0]][CurIndex[1]] += 1;
                }

                // Analyze results
                for (int i = 0; i < Weighted2DArray.length; i++){
                    for (int v = 0; v < Weighted2DArray[i].length; v++){
                        System.out.println(Weighted2DArray[i][v]);
                    }
                }
            }
        }
    }
}
