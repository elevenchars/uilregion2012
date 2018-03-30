import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Etch {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("example/etch.dat"));
        int n = in.nextInt();
        while(n-- > 0) {
            String[][] mat = new String[15][25];
            int spotR = in.nextInt()-1;
            int spotC = in.nextInt()-1;in.nextLine();
            String[] instructions = in.nextLine().split("\\s");
//            System.out.println(spotR + " " + spotC);
//            System.out.println(Arrays.toString(instructions));
            draw(mat, spotR, spotC);
//            System.out.println(display(mat));
            for(String instruction: instructions) {
                switch(instruction.substring(0,1)) {
                    case "R":
                        for(int i = 0; i < Integer.parseInt(instruction.substring(1)); i++) {
                            if(spotC+1 < mat[0].length) {
                                draw(mat, spotR, spotC++);
                            }
                        }
                        break;
                    case "L":
                        for(int i = 0; i < Integer.parseInt(instruction.substring(1)); i++) {
                            if(spotC-1 > 0) {
                                draw(mat, spotR, spotC--);
                            }
                        }
                        break;
                    case "U":
                        for(int i = 0; i < Integer.parseInt(instruction.substring(1)); i++) {
                            if(spotR+1 < mat.length) {
                                draw(mat, spotR++, spotC);
                            }
                        }
                        break;
                    case "D":
                        for(int i = 0; i < Integer.parseInt(instruction.substring(1)); i++) {
                            if(spotR-1 > 0) {
                                draw(mat, spotR--, spotC);
                            }
                        }
                        break;
                }
            }
            System.out.println(display(mat));

        }
    }
    public static void draw(String[][] m, int r, int c) {
        m[r][c] = "*";
    }
    public static String display(String[][] m) {
        String out ="";
        for(String[] line: m) {
            for(String spot: line) {
                out += (spot instanceof Object ? spot : ".");
            }
            out += "\n";
        }
        return out;
    }
}
