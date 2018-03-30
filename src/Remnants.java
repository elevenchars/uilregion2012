import java.util.*;
import java.io.*;
public class Remnants {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("example/remnants.dat"));
        String[] data = sc.nextLine().split(" ");
        for(String s : data){
            System.out.print(Integer.parseInt(s)*3/14+1+" ");
        }
    }
}

/*
DONE
 */