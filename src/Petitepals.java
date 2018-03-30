import java.util.*;
import java.io.*;
public class Petitepals {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("judges/petitepals.dat"));
        int cases = Integer.parseInt(sc.nextLine());
        while(cases-->0){
            ArrayList<String> stuff = new ArrayList<>();
            int count = 0;
            String word = sc.nextLine();
//            System.out.println(word + " -----");
            for(int i=0;i<word.length();i++){
                for(int j=i+1;j<=word.length();j++){
                    if(isPalindrome(word.substring(i,j)) && stuff.indexOf(word.substring(i,j))==-1 && j-i != word.length()){
                        stuff.add(word.substring(i,j));
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    public static boolean isPalindrome(String s){
        StringBuilder n = new StringBuilder(s);
        n.reverse();
        String rev = n.toString();
//        System.out.println(s + " -- " + rev);
        return rev.equals(s);
    }
}

/*
DONE
 */