package src;

import java.util.Scanner;

public class Authentication {
    private static final String LOGIN = "admin";
    private static final String PASSWORD = "admin";

    public boolean authenticate() {
        String login;
        String password;

        Scanner s = new Scanner(System.in);

        System.out.print("Login: ");
        login = s.nextLine();

        System.out.print("Password: ");
        password = s.nextLine();

        return login.equals(LOGIN) && password.equals(PASSWORD);
    }
}
