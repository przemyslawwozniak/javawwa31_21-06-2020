package pl.sda.javawwa31.exceptions;

import java.util.Arrays;
import java.util.List;

public class SmallLetterValidator extends CharacterValidator implements Valideable {

    private static List<Integer> asciiCodes;

    static {
        Integer[] codes = intRange(97, 122);
        asciiCodes = Arrays.asList(codes);
    }

    public SmallLetterValidator() {
        super(asciiCodes);  //super musi byc 1wszym statement ktory wolacie w konstruktorze
    }

}
