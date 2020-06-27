package pl.sda.javawwa31.exceptions;

public class LengthValidationException extends ValidationException {
    private int expectedLen;

    public LengthValidationException(int expectedLen) {
        this.expectedLen = expectedLen;
    }

    @Override
    public String getMessage() {
        return "Haslo zbyt krotkie - powinno miec minimum " + expectedLen + " znakow!";
    }
}
