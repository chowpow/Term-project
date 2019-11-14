package ui;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FantasyTeam fantasyTeam = new FantasyTeam();
        ReadWebPage webPageReader = new ReadWebPage();
        try {
            webPageReader.readWeb();
            fantasyTeam.runFantasyTeam();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            System.out.println("Thanks for playing!");
        }
    }
}