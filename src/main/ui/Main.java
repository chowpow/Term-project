package ui;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FantasyTeam fantasyTeam = new FantasyTeam();
        try {
            fantasyTeam.runFantasyTeam();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            System.out.println("Thanks for playing!");
        }
    }
}