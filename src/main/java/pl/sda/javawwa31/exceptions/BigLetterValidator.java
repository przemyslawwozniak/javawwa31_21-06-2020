package pl.sda.javawwa31.exceptions;

import java.util.Arrays;
import java.util.List;

public class BigLetterValidator extends CharacterValidator implements Valideable {

    private static List<Integer> asciiCodes;

    static {
        Integer[] codes = intRange(65, 90);
        asciiCodes = Arrays.asList(codes);
    }

    public BigLetterValidator() {
        super(asciiCodes);  //super musi byc 1wszym statement ktory wolacie w konstruktorze
    }

}
