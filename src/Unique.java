import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Unique {
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> primes = generatePrimes(4, 2099);
        Scanner in = new Scanner(new File("judges/unique.dat"));
        int n = in.nextInt();
        while(n-- > 0) {
            int year = in.nextInt();
            boolean prime = primes.contains(year);
            int sequences = 0;
            String seq ="";
            for(int i = 0; i < primes.indexOf(year); i++) {
                int sum = 0;
                int j = i;
                while(sum < year) {
                    sum += primes.get(j++);
                }
                if(sum == year) {
                    sequences++;
                    seq = "AND THE SUM OF " + (sequences > 1 ? "MORE THAN ONE SET OF" : "OF " + primes.subList(i, j).size()) + " CONSECUTIVE PRIMES";
                }
            }
            if(prime) {
                System.out.println(year + " PRIME YEAR " + seq);
            } else{
                System.out.println(year + " NOT A PRIME YEAR");
            }
        }
    }

    public static List<Integer> generatePrimes(int start, int stop) {
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        primes.add(3);
        for(int i = start; i < stop+1; i++) {
            boolean prime = true;
            for(int j = 2; j <= Math.ceil(Math.sqrt(i)); j++) {
                if(i % j == 0) {
                    prime = false;
                }
            }
            if(prime) {
                primes.add(i);
            }
        }
        return primes;
    }
}

/*
DONE
 */