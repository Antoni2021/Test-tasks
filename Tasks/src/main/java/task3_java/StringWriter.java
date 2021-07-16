package task3_java;

import java.util.*;

public class StringWriter {

    public static void writeStrings(){
        HashMap<Integer, String> hm = new HashMap<>();
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        int number = sc.nextInt();
        if (number < 1 | number > 100) {
            System.out.println("the number of lines is not allowed");
            System.exit(-1);
        }
        String word = sc.next();
        for (int i = 0; i < number; i++){
            int count = 0;
            String string = sc.next();
            String[] strMass = string.split(" ");
            for (String s: strMass){
                if (s.equals(word)){
                    count++;
                }
            }
            hm.put(count, string);
        }
        List<Integer> keys = new ArrayList<>(hm.keySet());
        Collections.sort(keys);
        for (Integer key: keys){
            System.out.println(hm.get(key));
        }
    }
}
