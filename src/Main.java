import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create a new Scanner object to read the input from the command line
        String s = scanner.nextLine(); // read the input
        StrongPasswordChecker checker = new StrongPasswordChecker(); // create a new StrongPasswordChecker object to
        // check if the password provided is strong
        System.out.println(checker.strongPassword(s)); // call to the strongPassword method of the checker object,
        // passing the s variable as an argument and prints the result to the console

    }

}
