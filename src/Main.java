import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\User\\Desktop\\dz");
        FileModified.findWords(file);
    }
}

class FileModified {

    public static void findWords (File file) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        int maxValue = 0;
        String s = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"windows-1251"));

        while(br.ready()){
            String line = br.readLine();
            s += line;
        }
        br.close();

        String s2 = s.replaceAll("(\\p{Punct}|\\s)"," ").replaceAll("\\s+"," ").toLowerCase();

        String[] arr = s2.split(" ");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        for (String a: arr) {
            if (map.isEmpty()) map.put(a,1);
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            } else map.put(a,1);
        }

        for (Map.Entry<String, Integer> pair: map.entrySet()) {
            String key = pair.getKey();
            int value = pair.getValue();
            if (value > maxValue) maxValue = value;
            System.out.println("Слово: "+key+", количество повторений: "+value);
        }

        for (Map.Entry<String,Integer> pair: map.entrySet()) {
            String key = pair.getKey();
            int value = pair.getValue();
            if (value == maxValue)
                System.out.println("Слово: "+key+" встречается чаще всего, количество повторов: "+value);
        }
    }
}
