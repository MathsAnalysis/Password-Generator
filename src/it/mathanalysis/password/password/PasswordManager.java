package it.mathanalysis.password.password;


import java.util.Random;

public class PasswordManager {

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String PUNCTUATION = "!@#$%&*()_+-=[]|,./?><";

    private static final int PASSWORD_LENGTH = 8;


    private final boolean useLower;
    private final boolean useUpper;
    private final boolean useDigits;
    private final boolean usePunctuation;


    public PasswordManager(boolean useLower, boolean useUpper, boolean useDigits, boolean usePunctuation) {
        this.useLower = useLower;
        this.useUpper = useUpper;
        this.useDigits = useDigits;
        this.usePunctuation = usePunctuation;
    }


    public String getAvailableChars() {
        StringBuilder availableChars = new StringBuilder();

        if (useLower) {
            availableChars.append(LOWER);
        }
        if (useUpper) {
            availableChars.append(UPPER);
        }
        if (useDigits) {
            availableChars.append(DIGITS);
        }
        if (usePunctuation) {
            availableChars.append(PUNCTUATION);
        }

        if (availableChars.isEmpty()) {
            availableChars.append(LOWER);
        }

        return availableChars.toString();
    }

    public char getRandomChar(String availableChars) {
        if (availableChars == null || availableChars.isEmpty()) {
            throw new IllegalArgumentException("String of available characters must not be null or empty");
        }

        if (PASSWORD_LENGTH < 1) {
            throw new IllegalArgumentException("Password length must be at least 1");
        }

        Random random = getRandomPass();

        random.setSeed(System.currentTimeMillis());

        int randomPos = (int) Math.floor(Math.random() * availableChars.length());
        return availableChars.charAt(randomPos);
    }

    public Random getRandomPass(){
        return new Random();
    }

}
