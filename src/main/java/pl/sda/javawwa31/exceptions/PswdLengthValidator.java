package pl.sda.javawwa31.exceptions;

public class PswdLengthValidator implements Valideable {
        private int minLen;

        public PswdLengthValidator(int minLen) {
            this.minLen = minLen;
        }

        @Override
        public boolean validate(String pswd) throws ValidationException {
            if(pswd.length() >= minLen)
                return true;
            else
                throw new LengthValidationException(minLen);
        }
}
