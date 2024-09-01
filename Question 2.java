//question 2
public class WordEncryption {

    public static String encryptString(String input1, int input2) {
        StringBuilder encrypted = new StringBuilder();
        int aValue = 'a'; // ASCII value of 'a'
        int zValue = 'z'; // ASCII value of 'z'
        
        for (char c : input1.toCharArray()) {
            int charValue = Character.toLowerCase(c) - aValue;
            int newCharValue = (charValue + input2) % 26;
            char encryptedChar = (char) (aValue + newCharValue);

            // Apply uppercase or lowercase based on original character
            if (Character.isUpperCase(c)) {
                encrypted.append(Character.toLowerCase(encryptedChar));
            } else {
                encrypted.append(Character.toUpperCase(encryptedChar));
            }
        }

        return encrypted.toString();
    }

    public static void main(String[] args) {
        String input1 = "Wipro Tech";
        int input2 = 20;
        String encrypted = encryptString(input1, input2);
        System.out.println("Encrypted Words: " + encrypted); // Output: qCJLI nYWB
    }
}
