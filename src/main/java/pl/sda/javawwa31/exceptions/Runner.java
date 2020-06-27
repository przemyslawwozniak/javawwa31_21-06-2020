package pl.sda.javawwa31.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj haslo i zatwierdz klikajac [ENTER]: ");
        String pswd = sc.nextLine();

        boolean isValidPswd = validatePswd(pswd);
        while(!isValidPswd) {
            System.out.println("Wprowadz ponownie haslo: ");
            pswd = sc.nextLine();
            isValidPswd = validatePswd(pswd);
        }

        System.out.println("Prawidlowo ustawiono haslo.");
    }

    public static boolean validatePswd(String pswd) {
        List<Valideable> validators = new ArrayList<>();
        validators.add(new PswdLengthValidator(8));
        validators.add(new SpecialCharacterValidator());
        validators.add(new BigLetterValidator());
        validators.add(new SmallLetterValidator());

        try {
            for(Valideable v : validators)
                v.validate(pswd);
        }
        catch(LengthValidationException lve) {
            System.out.println(lve.getMessage());
            return false;
        }
        catch(CharacterValidationException cve) {
            System.out.println(cve.getMessage());
            return false;
        }
        catch(ValidationException ve) {
            System.out.println("Validation exception");
            return false;
        }

        return true;
    }

}
