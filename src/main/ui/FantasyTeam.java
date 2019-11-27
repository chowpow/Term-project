package ui;

import model.*;
import observer.TeamObserver;

import java.io.*;
import java.util.Scanner;
import java.util.Set;

public class FantasyTeam implements Saveable, Loadable {
    private Scanner scanner;
    protected Team fantasyTeam;

    public FantasyTeam() {
        scanner = new Scanner(System.in);
        fantasyTeam = new Team();
        fantasyTeam.addObserver(new TeamObserver());

    }

    public void runFantasyTeam() throws IOException, ClassNotFoundException {
        processFantasyTeam();
    }

    // processFantasyTeam() and use of scanner from LoggingCalculator
    private void processFantasyTeam() throws IOException, ClassNotFoundException {
        String function;

        while (true) {
            printUserInput();
            function = scanner.nextLine();
            System.out.println("You selected: " + function);

            if (function.equals("6")) {
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
                + "\n"
                + " [5] to load previous save"
                + " [6] to quit"
                + " [7] to see how many points a player got");
    }

    // processUserOperation() from LoggingCalculator
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
        if (function.equals("5")) {
            fantasyTeam = this.load();
        }
        if (function.equals("7")) {
            seePlayerPoints();
        }
    }

    protected void addPlayerToTeam() {
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

        playerCreator(playerName, position, goals, assists);
    }

    protected void playerCreator(String n, String p, int g, int a) {
        Player playerToBeAdded;
        switch (p) {
            case "forward":
                playerToBeAdded = new Forward(n, p, g, a);
                break;
            case "midfielder":
                playerToBeAdded = new Midfielder(n, p, g, a);
                break;
            case "defender":
                playerToBeAdded = new Defender(n, p, g, a);
                break;
            default:
                playerToBeAdded = new Goalkeeper(n, p, g, a);
                break;
        }
        playerAdder(playerToBeAdded);
    }

    private void playerAdder(Player playerToBeAdded) {
        try {
            fantasyTeam.addPlayer(playerToBeAdded);
        } catch (FantasyTeamFullException exception) {
            System.out.println("Your fantasy team is full!!");
        }
    }

    protected void removePlayer() {
        String playerToBeRemoved;
        System.out.println("Enter the name of the player you would like to remove");
        playerToBeRemoved = scanner.nextLine();
        removePlayerFromTeam(playerToBeRemoved);
    }

    protected void removePlayerFromTeam(String playerTobeRemoved) {
        fantasyTeam.removePlayer(playerTobeRemoved);
    }

    protected void viewTeam() {
        System.out.println(fantasyTeam.allPlayerNames());
    }

    // set of String to String from https://stackoverflow.com/questions/3042060/fastest-way-to-put-contents-of-setstring-to-a-single-string-with-words-separat
    protected String returnAllPlayerNames() {
        return String.join(", ", fantasyTeam.allPlayerNames());
    }

    protected void viewTeamPoints() {
        System.out.println("Your team got " + fantasyTeam.calculateTeamPoints() + " points!");
    }

    protected String viewTeamPointsString() {
        return Integer.toString(fantasyTeam.calculateTeamPoints());
    }

    protected void seePlayerPoints() {
        String playerName;
        System.out.println("Which player's points would you like to check?");
        playerName = scanner.nextLine();
        System.out.println(playerName + " got " + fantasyTeam.getPlayer(playerName).calculatePoints() + " points!");
    }

    protected Team getFantasyTeam() {
        return fantasyTeam;
    }

    public void setFantasyTeam(Team fantasyTeam) {
        this.fantasyTeam = fantasyTeam;
    }

    // Saving and load functions from https://www.youtube.com/watch?v=bRuxXAF-Ysk

    // EFFECTS: save team to file "Save.txt"
    @Override
    public void save(Team team) throws IOException {
        ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("Save.txt"));
        save.writeObject(team);
        save.close();
    }

    @Override
    // EFFECTS: load the team saved in "Save.txt", adds an observer to the team and return it
    public Team load() throws IOException, ClassNotFoundException {
        ObjectInputStream load = new ObjectInputStream(new FileInputStream("Save.txt"));
        Team team;
        team = (Team) load.readObject();
        TeamObserver teamObserver = new TeamObserver();
        teamObserver.setNumOfPlayers(team.sizeOfSquad());
        team.addObserver(teamObserver);
        return team;
    }
}
