//This project uses the Caesar Cipher encryption method described in the Cybersecurity lectures.  You will develop a Java program to implement Caesar Cipher encryption.   The program will encrypt your last name (UPPER-CASE LETTERS) using the last two digits of your SMU ID number as your offset value.
// For your Java file (*.java), the main file name should contain the first 4 letters of your last name and the first letter of your first name.  For example, my Java file name would be manit.java.  Note: if your last name has less than 4 letters (e.g., Lee), then you may use the full last name and first letter of your first name.
// The class name in your Java file should be CaesarCipher
// The Java file should include a function that implements the Caesar Cipher encryption method:
// Function input:
// Plaintext: your last name in all UPPER-CASE letters
// Offset: the last two digits of your SMU ID number


public class CaesarCipher {

    // Caesar Cipher encryption function
    public static String encrypt(String plaintext, int offset) {
        StringBuilder ciphertext = new StringBuilder();

        // Keep offset within 0–25 range
        offset = offset % 26;

        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);

            if (ch >= 'A' && ch <= 'Z') {
                char c = (char) ((ch - 'A' + offset) % 26 + 'A');
                ciphertext.append(c);
            } else {
                ciphertext.append(ch);
            }
        }

        return ciphertext.toString();
    }

    public static void main(String[] args) {
        String name = "Travis Pryor";
        String course = "CS 3341 FALL 2025";
        String plaintext = "PRYOR";
        int offset = 35;

        System.out.println(name);
        System.out.println(course);
        System.out.println("\nEncryption using Caesar Cipher");
        System.out.println("plaintext: " + plaintext);
        System.out.println("offset: " + offset);
        System.out.println("ciphertext: " + encrypt(plaintext, offset));
    }
}
