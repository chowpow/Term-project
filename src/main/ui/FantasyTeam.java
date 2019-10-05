package ui;

import model.Loadable;
import model.Player;
import model.Saveable;
import model.Team;

import java.io.*;
import java.util.Scanner;

public class FantasyTeam implements Saveable, Loadable {
    private Scanner scanner;
    private Team fantasyTeam;

    public FantasyTeam() {
        scanner = new Scanner(System.in);
        fantasyTeam = new Team();
    }

    public void runFantasyTeam() throws IOException, ClassNotFoundException {
        processFantasyTeam();
    }

    private void processFantasyTeam() throws IOException, ClassNotFoundException {
        String function = null;

        while (true) {
            printUserInput();
            function = scanner.nextLine();
            System.out.println("You selected: " + function);

            if (function.equals("5")) {
                save(fantasyTeam);
                break;
            }
            processUserOperation(function);
        }
    }

    private void printUserInput() {
        System.out.println("Please pick an option: [1] to add player to your team"
                + " [2] to remove a player from your team"
                + " [3] to see your team"
                + " [4] to see how many points your team got"
                + " [5] to quit"
                + " [6] to load previous save");
    }

    private void processUserOperation(String function) throws IOException, ClassNotFoundException {
        if (function.equals("1")) {
            addPlayerToTeam();
        }
        if (function.equals("2")) {
            removePlayer();
        }
        if (function.equals("3")) {
            viewTeam();
        }
        if (function.equals("4")) {
            viewTeamPoints();
        }
        if (function.equals("6")) {
            fantasyTeam = load();
        }
    }

    private void addPlayerToTeam() {
        String playerName;
        String position;
        int goals;
        int assists;

        System.out.println("Please enter the player's name");
        playerName = scanner.nextLine();

        System.out.println("Is the player a forward, midfielder, defender, or goalkeeper?");
        position = scanner.nextLine();

        System.out.println("Please enter how many goals the player scored this gameweek");
        goals = scanner.nextInt();

        System.out.println("Please enter how many assists the player had this gameweek");
        assists = scanner.nextInt();
        scanner.nextLine();
        Player playerToBeAdded = new Player(playerName,position,goals,assists);
        System.out.println("You've added " + playerName + " to your team");
        fantasyTeam.addPlayer(playerToBeAdded);
    }

    private void removePlayer() {
        String playerToBeRemoved;
        System.out.println("Enter the name of the player you would like to remove");
        playerToBeRemoved = scanner.nextLine();
        System.out.println("You've removed " + playerToBeRemoved + " from your team");
        fantasyTeam.removePlayer(fantasyTeam.findPlayerWithName(playerToBeRemoved));
    }

    private void viewTeam() {
        System.out.println(fantasyTeam.allPlayerNames());
    }

    private void viewTeamPoints() {
        System.out.println("Your team got " + fantasyTeam.calculateTeamPoints() + " points!");
    }

    @Override
    public void save(Team team) throws IOException {
        ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("Save.txt"));
        save.writeObject(team);
        save.close();

    }

    @Override
    public Team load() throws IOException, ClassNotFoundException {
        ObjectInputStream load = new ObjectInputStream(new FileInputStream("Save.txt"));
        Team team;
        team = (Team) load.readObject();
        return team;
    }

}
