package pl.sda.javawwa31.exceptions;

import java.util.List;

public class CharacterValidator implements Valideable {

    private List<Integer> asciiCodes;

    public CharacterValidator(List<Integer> asciiCodes) {
        this.asciiCodes = asciiCodes;
    }

    @Override
    public boolean validate(String pswd) throws ValidationException {
        if(containsCharacters(pswd))
            return true;
        else
            throw new CharacterValidationException(asciiCodes);
    }

    protected boolean containsCharacters(String pswd) {
        boolean pswdContainsAnyOfSpecifiedChars = false;
        for(char c : pswd.toCharArray()) {
            if(asciiCodes.contains((int) c)) {
                pswdContainsAnyOfSpecifiedChars = true;
                break;
            }
        }
        return pswdContainsAnyOfSpecifiedChars;
    }

    protected static Integer[] intRange(int start, int stop) {
        Integer[] arr = new Integer[stop - start + 1];
        for(int num = start, it = 0; num <= stop; num++, it++)
            arr[it] = num;
        return arr;
    }

}
