package it.mathanalysis.password;

import it.mathanalysis.password.password.PasswordManager;

import java.awt.*;

public class PasswordGenerator {
    private PasswordManager passwordManager;

    public PasswordGenerator() {
        loadManager();
    }


    public void generatePassword(int length) {
        String availableChars = this.passwordManager.getAvailableChars();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(this.passwordManager.getRandomChar(availableChars));
        }

        System.out.println(password);
    }


    private void loadManager(){
        this.passwordManager = new PasswordManager(true, true, true, true);
    }


}
