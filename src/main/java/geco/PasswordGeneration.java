package geco;

import java.util.Random;

/** Allow to generate passwords. */
public class PasswordGeneration {

    /** All the char in the alphabet (lower and upper letters). */
    public static final String LETTER =
            "azertyuiopqsdfghjklmwxcvbnAZERTYUIOPQSDFGHJKLMWXCVBN";
    /** All the digit (0-9). */
    public static final String DIGIT = "123456789";
    /** The number of char for the password. */
    public static final int NB_CHAR = 8;

    /** Constructor. */
    public PasswordGeneration() {

    }

    /** Generate a new password
     * (first is a letter, others are letters or digit.
     * @return password
     * */
    public static String getRandomPassword() {
        char[] letter = LETTER.toCharArray();
        char[] letterOrDigit = (LETTER + DIGIT).toCharArray();
        Random r = new Random();

        StringBuilder password = new StringBuilder();

        //first char is from alphabet
        password.append(letter[r.nextInt(letter.length)]);

        //nexts can be alphabet or digit
        for (int i = 0; i < NB_CHAR - 1; i++) {
            password.append(letterOrDigit[r.nextInt(letterOrDigit.length)]);
        }

        return password.toString();
    }

}
