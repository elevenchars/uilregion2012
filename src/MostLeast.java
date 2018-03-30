import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MostLeast {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("judges/mostleast.dat"));
        int n = in.nextInt();in.nextLine(); //scanner sucks
        while(n-- > 0) {
            String para = in.nextLine();
            List<String> words = new ArrayList<>(Arrays.asList(para.split("[\\s\\.,?]")));
//            System.out.println(words);
            Map<String, Integer> dict = new HashMap<>();
            for(String word: words) {
                if(!word.equals("")) {
                    dict.putIfAbsent(word, 0);
                    dict.put(word, dict.get(word) + 1);
                }
            }
//            System.out.println(dict);

            int max = getMax(dict);
            int min = getMin(dict);

            List<String> mins = new ArrayList<>();
            List<String> maxs = new ArrayList<>();
            for(String key: dict.keySet()) {
                if (dict.get(key) == min) {
                    mins.add(key);
                } else if(dict.get(key) == max){
                    maxs.add(key);
                }
            }

            Collections.sort(mins);
            Collections.sort(maxs);

            String maxOut = max + " ";
            String minOut = min + " ";
            for(String spot: maxs) {
                maxOut += spot + " ";
            }
            for(String spot: mins) {
                minOut += spot + " ";
            }
            System.out.println(maxOut.trim());
            System.out.println(minOut.trim());
        }
    }

    public static int getMax(Map<String, Integer> m) {
        int max = Integer.MIN_VALUE;
        for(String key: m.keySet()) {
            if (m.get(key) > max) {
                max = m.get(key);
            }
        }
        return max;
    }

    public static int getMin(Map<String, Integer> m) {
        int min = Integer.MAX_VALUE;
        for(String key: m.keySet()) {
            if (m.get(key) < min) {
                min = m.get(key);
            }
        }
        return min;
    }
}
