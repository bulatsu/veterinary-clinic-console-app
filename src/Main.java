package src;

import src.command.CommandReader;

public class Main {

    public static void main(String[] args) {

        Authentication authentication = new Authentication();
        if (!authentication.authenticate()) {
            System.out.println("Login failed");
            return;
        }

        CommandReader.startReadCommand();
    }
}