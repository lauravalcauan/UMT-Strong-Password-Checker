public class Validators implements  Validator<String>{

    public final int MIN_LENGTH = 7;
    public final int MAX_LENGTH = 20;

    public boolean isValidLength(String s) {
        int minLength = MIN_LENGTH;
        int maxLength = MAX_LENGTH;
        if(s.length() < minLength || s.length() > maxLength) {
            return false;
        }
        return true;
    }

    public boolean validCharacters(String s) {
        char chars;
        boolean upperCaseFlag = false;
        boolean lowerCaseFlag = false;
        boolean digitFlag = false;

        for(int i = 0; i < s.length(); i++) {
            chars = s.charAt(i);
            if(Character.isDigit(chars)) {
                digitFlag = true;
            } else if(Character.isUpperCase(chars)) {
                upperCaseFlag = true;
            } else if(Character.isLowerCase(chars)) {
                lowerCaseFlag = true;
            }
            if(digitFlag && upperCaseFlag && lowerCaseFlag)
                return true;
        }
        return false;
    }

    public boolean repeatedCharacters(String s) {
        int count = 0;
        char[] chars = s.toCharArray();

        for(int i = 0; i < chars.length - 1; i++) {
            if(Character.isLetter(chars[i]) == Character.isLetter(chars[i + 1])) {
                count++;
            }
        }
        if(count > 2)
            return true;
        else
            return false;

    }
}
