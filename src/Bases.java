import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bases {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("judges/bases.dat"));
        int n = in.nextInt();
        System.out.println("Base 10   Base 2    Base 4    Base 8    Base 12   Base 16");
        for(int i = 1; i <= n; i++) {
            String base2 = Integer.toString(i, 2);
            String base4 = Integer.toString(i, 4);
            String base8 = Integer.toString(i, 8);
            String base12 = Integer.toString(i, 12);
            String base16 = Integer.toString(i, 16);
            System.out.printf("%-10d%-10s%-10s%-10s%-10s%-10s\n", i, base2, base4, base8, base12, base16);
        }
    }
}

/*
DONE
 */