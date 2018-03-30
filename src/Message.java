import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Message {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("judges/message.dat"));
        int n = in.nextInt();
        while(n-- > 0) {
            int len = in.nextInt(); in.nextLine(); //get rid of that pesky newline
            String data = in.nextLine();
            String out = "";
            for(String foo: data.split("[\\s\\.,]")) {
                out += (foo.length() == len ? foo+" " : "");
            }
            System.out.println(out);
        }
    }
}

/*
DONE
 */