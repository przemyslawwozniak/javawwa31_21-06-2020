package pl.sda.javawwa31.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LettersInSentence {

    public static void main(String[] args) {
        String text = "Bardzo lubię spacerować po zielonym parku ciepłym letnim wieczorem";
        text = text.replaceAll("\\s","");   //wykasowuje spacje z tekstu
        char[] carr = text.toCharArray();

        Map<Character, List<Integer>> lettersMap = new HashMap<>();

        for(int idx = 0; idx < carr.length; idx++) {
            Character ch = Character.valueOf(carr[idx]);
            if(lettersMap.containsKey(ch)) {
                lettersMap.get(ch).add(idx);
            }
            else {
                List<Integer> positions = new ArrayList<>();
                positions.add(idx);
                lettersMap.put(ch, positions);
            }
        }

        System.out.println(lettersMap);
    }

}
