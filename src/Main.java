import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StrongPasswordChecker checker = new StrongPasswordChecker();
        System.out.println(checker.strongPassword(s));
    }

}
