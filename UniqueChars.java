

import java.util.HashMap;
import java.util.Map;

public class UniqueChars {

    static public void main(String[] args) {
        UniqueChars uniqueChars = new UniqueChars();
        String str = " asdasda";
        uniqueChars.uniqueChars(str);
    }

    public void uniqueChars(String phrase) {
        Map<Character, Integer> myMap= new HashMap<>();
        int counter;
        System.out.println(phrase);
        for(char ch: phrase.toCharArray()) {
            if(myMap.containsKey(ch)) {
                counter = myMap.get(ch);
                counter++;
                myMap.put(ch, counter);
            } else {
                myMap.put(ch, 1);
            }
        }
        for(char ch: myMap.keySet()) {
            counter = myMap.get(ch);
            System.out.print("\'" + ch + "\': " + counter + "\n");
        }
    }
}
