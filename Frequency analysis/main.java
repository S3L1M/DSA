import java.util.*;

class Main {
    public static void main(String[] args) {

        // Geting input
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split(" ");
        sc.close();

        // Definition of variables
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, TreeSet<String>> freqToWords = new HashMap<>();

        // Initialize map
        for(String w:words)
            map.put(w, 0);

        // Fill in the frequancies of words
        for(String w:words)
            map.put(w, map.get(w)+1);
        
        // Initialize freqToWord
        for(String w:words) {
            freqToWords.put(map.get(w), new TreeSet<>());     
        }

        // Associate freq with list of words
        for(String w:words) {
            Integer freq = map.get(w);
            TreeSet<String> wordList = freqToWords.get(freq);
            wordList.add(w);
            freqToWords.put(freq, wordList);
            
        }
                
        // Sort
        Object[] freq = freqToWords.keySet().toArray();
        Arrays.sort(freq, Collections.reverseOrder());
        
        // Print output
        for(Object f:freq) {
            for(String w:freqToWords.get(f)) {
                System.out.println(w + " " + f);
            }
        }
    }
}
