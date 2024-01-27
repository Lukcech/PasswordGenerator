import java.security.SecureRandom;
import java.util.Scanner;

// Class for generating and evaluating passwords
class PasswordGenerator {
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBER_CHARS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

    private SecureRandom random;

    // Constructor to initialize the random number generator

    public PasswordGenerator() {
        this.random = new SecureRandom();
    }
    // Method to generate a random password based on user preferences
    public String generateRandomPassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder();
        String allChars = "";
    // Construct the character set based on user preferences
        if (includeUppercase) {
            allChars += UPPERCASE_CHARS;
        }
        if (includeLowercase) {
            allChars += LOWERCASE_CHARS;
        }
        if (includeNumbers) {
            allChars += NUMBER_CHARS;
        }
        if (includeSpecialChars) {
            allChars += SPECIAL_CHARS;
        }
    // Check if at least one character set is selected
        if (allChars.isEmpty()) {
            System.out.println("Error: No character set selected for password generation.");
            return "";
        }
    // Generate the random password
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }
    // Method to evaluate the strength of a password
    public String evaluatePasswordStrength(String password) {
        int strengthScore = calculatePasswordStrengthScore(password);
        // Determine the strength label based on the calculated score
        if (strengthScore >= 15) {
            return "Strong Password";
        } else if (strengthScore >= 10) {
            return "Good Password";
        } else {
            return "Weak Password";
        }
    }
    // Helper method to calculate the strength score of a password based on length and variety
    private int calculatePasswordStrengthScore(String password) {
        int lengthScore = Math.min(password.length(), 10);
        int varietyScore = calculateVarietyScore(password);

        return lengthScore + varietyScore;
    }
    // Helper method to calculate the variety score of a password based on character categories
    private int calculateVarietyScore(String password) {
        int varietyCount = 0;
        if (containsCharacterCategory(password, UPPERCASE_CHARS)) {
            varietyCount++;
        }
        if (containsCharacterCategory(password, LOWERCASE_CHARS)) {
            varietyCount++;
        }
        if (containsCharacterCategory(password, NUMBER_CHARS)) {
            varietyCount++;
        }
        if (containsCharacterCategory(password, SPECIAL_CHARS)) {
            varietyCount++;
        }
        return Math.min(varietyCount, 4) * 5;
    }
    // Helper method to check if a password contains characters from a specific category
    private boolean containsCharacterCategory(String password, String charCategory) {
        return password.chars().anyMatch(c -> charCategory.indexOf(c) != -1);
    }
}


