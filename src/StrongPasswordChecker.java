public class StrongPasswordChecker {

    public int strongPassword(String s) {
        // initialize flags to keep track of password criteria
        boolean upperCaseFlag = false;
        boolean lowerCaseFlag = false;
        boolean digitFlag = false;
        boolean repeatFlag = false;
        int strongPass = 0; // helper variable to check if the password is strong or not

        Validators validators = new Validators(); // create a new instance of the Validators class

        if (!validators.isValidLength(s)) { // check with our helper method if the length is valid
            strongPass++; // increment strongPass to signal something is wrong and the password does not respect
            // the criteria
            int difference = 0; // initialize the difference in length 0, prepare it to store how many characters
            // the user need to insert/delete
            if (s.length() < 6) { // check if it is in the lower range
                difference = 6 - s.length(); // compute how many characters do we need
                System.out.println("You need to add more " + difference + " characters"); // show the user what is wrong
                // with the password and what changes are required
            } else if (s.length() > 20) { // check if it is in the higher range
                difference = s.length() - 19; // compute how many characters do we need
                System.out.println("You need to delete " + difference + " characters");  // show the user what is wrong
                // with the password and what changes are required
            }
        }
        if (!validators.validCharacters(s)) { // check with the helper method if the characters respect the criteria
            // as in at least one lower case, at least one upper case and at least one digit
            strongPass++; // increment strongPass to signal something is wrong and the password does not
            // respect the criteria
            for (int i = 0; i < s.length(); i++) { // iterate over each character in the password
                char chars = s.charAt(i); // get the character at the current position
                if (Character.isDigit(chars)) { // if the character is a digit
                    digitFlag = true; // set digitFlag to true
                } else if (Character.isUpperCase(chars)) { // if the character is an uppercase letter
                    upperCaseFlag = true; // set upperCaseFlag to true
                } else if (Character.isLowerCase(chars)) { // if the character is a lowercase letter
                    lowerCaseFlag = true; // set lowerCaseFlag to true
                }
            }
            if (!digitFlag) { // if the password does not contain a digit
                System.out.println("You need to have at least one digit in your password."); // print message
            }
            if (!upperCaseFlag) { // if the password does not contain an uppercase letter
                System.out.println("You need to have at least one upper case letter in your password.");
                // print message
            }
            if (!lowerCaseFlag) { // if the password does not contain a lowercase letter
                System.out.println("You need to have at least one lower case letter in your password.");
                // print message
            }
        }
        if (validators.repeatedCharacters(s)) { // check if password contains repeated characters
            strongPass++; // increment strongPass to signal something is wrong with the password
            int count = 0; // initialize count of repeating characters to 0
            char[] chars = s.toCharArray(); // convert the string to a character array
            char lastChar = '\0'; // initialize the last character to null

            for(int i = 0; i < chars.length; i++) { // iterate over each character in the password
                if (chars[i] == lastChar) { // if the current character is the same as the last one
                    count++; // increment the count of repeating characters
                    // check if there are 3 repeating characters in a row
                    // if the count of repeating characters is 2 and if the current index i is less than the length of
                    // the chars array - 1 => there is at least
                    // one more character in the array to check
                    // if the next character is the same at the current character that means that we have 3
                    // characters that repeat in a row
                    if (count == 2 && i < chars.length - 1 && chars[i + 1] == chars[i]) {
                        // found 3 repeating in a row
                        System.out.println("You need to have only 2 same letters in a row."); // display message
                        repeatFlag = true; // set the flag to true because there are 3 repeating characters in a row
                    }
                } else {
                    count = 1; // reset the count of repeating characters
                    lastChar = chars[i]; // update the last character to the current character
                }
            }
        }
        if(strongPass == 0 && !repeatFlag) { // if strongPass is 0 which means nothing needs to be changed
            // and repeatedFlag is false
            return 0; // the password is strong
        } else {
            int minChanges = 0; // variable to store the minimum number of changes needed to make
            // so the password is strong
            if(s.length() < 6) {
                minChanges++; // if it is out of bounds
            }
            if(s.length() > 20) {
                minChanges++; // if it is out of bounds
            }
            if(!digitFlag) {
                minChanges++; // if the digit is missing
            }
            if(!upperCaseFlag) {
                minChanges++; // if the uppercase letter is missing
            }
            if(!lowerCaseFlag) {
                minChanges++; // if the lowercase letter is missing
            }
            if(repeatFlag) {
                minChanges++; // if there are more than 2 repeated characters in a row
            }
            System.out.println("The number of minimum changes to make the password strong is: "); // show message
            return minChanges; // display the minimum number of changes that is needed to be made
        }

    }
}


