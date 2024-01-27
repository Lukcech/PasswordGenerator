import java.security.SecureRandom;
import java.util.Scanner;

// Class for generating and evaluating passwords
class PasswordGenerator {
    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBER_CHARS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[]{}|;:'\",.<>/?";

    private SecureRandom random;

    public PasswordGenerator() {
        this.random = new SecureRandom();
    }

    public String generateRandomPassword(int length, boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder();
        String allChars = "";

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

        if (allChars.isEmpty()) {
            System.out.println("Error: No character set selected for password generation.");
            return "";
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(allChars.length());
            password.append(allChars.charAt(randomIndex));
        }

        return password.toString();
    }

    public String evaluatePasswordStrength(String password) {
        int strengthScore = calculatePasswordStrengthScore(password);

        if (strengthScore >= 15) {
            return "Strong Password";
        } else if (strengthScore >= 10) {
            return "Good Password";
        } else {
            return "Weak Password";
        }
    }

    private int calculatePasswordStrengthScore(String password) {
        int lengthScore = Math.min(password.length(), 10);
        int varietyScore = calculateVarietyScore(password);

        return lengthScore + varietyScore;
    }

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

    private boolean containsCharacterCategory(String password, String charCategory) {
        return password.chars().anyMatch(c -> charCategory.indexOf(c) != -1);
    }
}


