import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        generatePasswordAndEvaluateStrength(passwordGenerator);
    }

    private static void generatePasswordAndEvaluateStrength(PasswordGenerator passwordGenerator) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter the length of the password: ");
            int passwordLength = scanner.nextInt();

            System.out.print("Include Uppercase Letters? (true/false): ");
            boolean includeUppercase = scanner.nextBoolean();

            System.out.print("Include Lowercase Letters? (true/false): ");
            boolean includeLowercase = scanner.nextBoolean();

            System.out.print("Include Numbers? (true/false): ");
            boolean includeNumbers = scanner.nextBoolean();

            System.out.print("Include Special Characters? (true/false): ");
            boolean includeSpecialChars = scanner.nextBoolean();

            String generatedPassword = passwordGenerator.generateRandomPassword(passwordLength, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);

            if (!generatedPassword.isEmpty()) {
                System.out.println("------------------------------------------");
                System.out.println("Generated Password: " + generatedPassword);
                System.out.println("");

                String strengthLabel = passwordGenerator.evaluatePasswordStrength(generatedPassword);
                System.out.println("Password Strength: " + strengthLabel);
                System.out.println("------------------------------------------");
            }

            System.out.print("Do you want to generate another password? (Y/N): ");
        } while (scanner.next().equalsIgnoreCase("Y"));
    }
}
