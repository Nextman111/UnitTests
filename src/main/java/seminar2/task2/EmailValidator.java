package seminar2.task2;

import java.util.regex.Pattern;

public class EmailValidator {

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public boolean isValidEmail(String email) {
        return pattern.matcher(email).matches();
    }
}