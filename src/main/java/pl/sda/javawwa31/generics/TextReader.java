package pl.sda.javawwa31.generics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TextReader {

    public static void main(String[] args) {
        Map<String, Integer> wordsMap = new HashMap<>();
        File file = new File("C:\\Users\\przwo\\Desktop\\news.txt");
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                List<String> words = Arrays.asList(line.split(" "));
                for(String word : words) {
                    word = word.trim();
                    wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
                }
            }
        }
        catch(FileNotFoundException ex) {
            System.err.println("Wrong file path!");
        }

        System.out.println("Oto zestawienie slow w pliku " + file + "\n");
        System.out.println(wordsMap);
    }

}
