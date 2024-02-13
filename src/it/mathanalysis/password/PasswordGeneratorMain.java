package it.mathanalysis.password;

import java.util.Scanner;

public class PasswordGeneratorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter the length of the password: ");
            String input = scanner.nextLine();
            if (isNotaNumber(input)) {
                System.out.println("Please enter a valid number");
                continue;
            }
            int length = Integer.parseInt(input);
            if (length < 1) {
                System.out.println("Password length must be at least 1");
                continue;
            }
            PasswordGenerator passwordGenerator = new PasswordGenerator();
            passwordGenerator.generatePassword(length);
            break;
        }

        while (true) {
            System.out.println("Do you want to generate another password? (yes/no)");
            String input = scanner.nextLine();

            if (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) {
                System.out.println("Please enter a valid answer");
                continue;
            }


            if (input.equalsIgnoreCase("yes")) {
                System.out.println("Enter the length of the password: ");

                Scanner scanner2 = new Scanner(System.in);
                String input2 = scanner2.nextLine();

                if(input2.isEmpty() || isNotaNumber(input2)){
                    System.out.println("Please enter a valid number");
                    continue;
                }

                int length = Integer.parseInt(input2);

                if (length <= 0) {
                    System.out.println("Password length must be at least 1");
                    continue;
                }

                PasswordGenerator passwordGenerator = new PasswordGenerator();
                passwordGenerator.generatePassword(length);
            } else if (input.equalsIgnoreCase("no")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }


    private static boolean isNotaNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

}



