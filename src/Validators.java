public class Validators implements Validator { // provide implementation for the Validator methods

    public static final int MIN_LENGTH = 6; // constant for keeping minimum length of the password
    public static final int MAX_LENGTH = 20; // constant for keeping maximum length of the password

    public boolean isValidLength(String s) { // helper method to check if the length is in the range,
        // returns true if so and false if it's not
        if(s.length() < MIN_LENGTH || s.length() > MAX_LENGTH) { // check if is smaller or bigger than 6 and 20
            return false; // not in the range
        }
        return true; // valid length of the password
    }

    public boolean validCharacters(String s) { // check if there is at least one uppercase letter,
        // at least one lowercase method and at least one digit
        char chars;
        boolean upperCaseFlag = false;
        boolean lowerCaseFlag = false;
        boolean digitFlag = false;

        for(int i = 0; i < s.length(); i++) { // iterates over each character in the string
            chars = s.charAt(i); // store the characters into chars
            if(Character.isDigit(chars)) { // check if there are any digits
                digitFlag = true; // set to true
            } else if(Character.isUpperCase(chars)) { // check if there are any uppercase letters
                upperCaseFlag = true; // set to true
            } else if(Character.isLowerCase(chars)) { // check if there are any lower case letters
                lowerCaseFlag = true; // set to true
            }
            if(digitFlag && upperCaseFlag && lowerCaseFlag) // if all are true
                // i.e. we have at least one of each of them the condition is satisfied
                return true; // set true, the password has all the required characters
        }
        return false; // false, some characters are missing
    }

    public boolean repeatedCharacters(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        char lastChar = '\0';

        for(int i = 0; i < chars.length; i++) { // iterates over each character in the string
            if (chars[i] == lastChar) { // check if the current element is equal to the previous one
                count++; // if yes, increment count to track how many variables of the same type there are in row
                if (count == 2 && i < chars.length - 1 && chars[i + 1] == chars[i]) {
                    // if the count reaches 2 and the next character is the same
                    // found 3 repeating in a row
                    return true; // found 3 in a row -> returns true
                }
            } else {
                count = 1; // reset count to 1
                lastChar = chars[i]; // update the lastChar to the current character
            }
        }
        return false; // not found any 3 repeating characters
    }
}
