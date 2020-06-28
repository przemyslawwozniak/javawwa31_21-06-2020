package pl.sda.javawwa31.exceptions;

import java.util.Arrays;
import java.util.List;

public class SpecialCharacterValidator extends CharacterValidator implements Valideable {

    //statyczny kod wykonuje sie na poczatku
    private static List<Integer> asciiCodes;
    //blok statycznego kodu
    static {
        Integer[] codes = {33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
                58, 59, 60, 61, 62, 63, 64,
                91, 92, 93, 94, 95, 96,
                123, 124, 125, 126};
        asciiCodes = Arrays.asList(codes);
    }

    public SpecialCharacterValidator() {
        super(asciiCodes);  //super musi byc 1wszym statement ktory wolacie w konstruktorze
    }
}
