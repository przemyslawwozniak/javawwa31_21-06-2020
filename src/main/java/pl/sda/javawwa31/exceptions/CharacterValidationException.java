package pl.sda.javawwa31.exceptions;

import java.util.List;

public class CharacterValidationException extends ValidationException {

    public List<Integer> asciiCodes;

    public CharacterValidationException(List<Integer> asciiCodes) {
        this.asciiCodes = asciiCodes;
    }

    @Override
    public String getMessage() {
        return "Haslo musi zawierac chociaz jeden ze znakow: " + asciiCodes;
    }
}
