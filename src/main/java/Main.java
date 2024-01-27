import java.util.Scanner;
// Main class for running the password generation program
public class Main {
    public static void main(String[] args) {
        // Create an instance of PasswordGenerator
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        // Call the method to generate passwords and evaluate strength
        generatePasswordAndEvaluateStrength(passwordGenerator);
    }
    // Method to interactively generate passwords and evaluate their strength
    private static void generatePasswordAndEvaluateStrength(PasswordGenerator passwordGenerator) {
        Scanner scanner = new Scanner(System.in);
        // Loop to allow the user to generate multiple passwords
        do {
            // User input for password generation preferences
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

        // Generate a random password based on user preferences
            String generatedPassword = passwordGenerator.generateRandomPassword(passwordLength, includeUppercase, includeLowercase, includeNumbers, includeSpecialChars);

            // Display the generated password
            if (!generatedPassword.isEmpty()) {
                System.out.println("------------------------------------------");
                System.out.println("Generated Password: " + generatedPassword);
                System.out.println("");

                String strengthLabel = passwordGenerator.evaluatePasswordStrength(generatedPassword);
                System.out.println("Password Strength: " + strengthLabel);
                System.out.println("------------------------------------------");
            }
            // Prompt the user to generate another password
            System.out.print("Do you want to generate another password? (Y/N): ");
        } while (scanner.next().equalsIgnoreCase("Y"));
    }
}
