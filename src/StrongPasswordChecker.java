public class StrongPasswordChecker {

    public int strongPassword(String s) {
        boolean upperCaseFlag = false;
        boolean lowerCaseFlag = false;
        boolean digitFlag = false;
        boolean strongPass = true;

        Validators validators = new Validators();

        if (!validators.isValidLength(s)) {
            int difference = 0;
            strongPass = false;
            if (s.length() < 6) {
                difference = 6 - s.length();
                System.out.println("You need to add more " + difference + " characters");
            } else if (s.length() > 20) {
                difference = s.length() - 19;
                System.out.println("You need to delete " + difference + " characters");
            }
        }
        if (!validators.validCharacters(s)) {
            strongPass = false;
            for (int i = 0; i < s.length(); i++) {
                char chars = s.charAt(i);
                if (Character.isDigit(chars)) {
                    digitFlag = true;
                } else if (Character.isUpperCase(chars)) {
                    upperCaseFlag = true;
                } else if (Character.isLowerCase(chars)) {
                    lowerCaseFlag = true;
                }
            }
            if (!digitFlag) {
                System.out.println("You need to have at least one digit in your password.");
            }
            if (!upperCaseFlag) {
                System.out.println("You need to have at least one upper case letter in your password.");
            }
            if (!lowerCaseFlag) {
                System.out.println("You need to have at least one lower case letter in your password.");
            }
        }
        if (!validators.repeatedCharacters(s)) {
            strongPass = false;
            int count = 0;
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                if (Character.isLetter(chars[i]) == Character.isLetter(chars[i + 1])) {
                    count++;
                }
            }
            if (count > 2) {
                System.out.println("You need to have only 2 same letters in a row.");
            }
        }
        return 0;
    }
}


