import java.util.Scanner;

public class Main {
    private Scanner scanner;
    private Team fantasyTeam;

    // comment
    public Main() {
        scanner = new Scanner(System.in);
        fantasyTeam = new Team();
        fantasyTeam.makeTeam();
        processFantasyTeam();
    }

    private void processFantasyTeam() {
        String function = null;

        while (true) {
            printUserInput();
            function = scanner.nextLine();
            System.out.println("You selected: " + function);

            if (function.equals("5")) {
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
                + " [5] to quit");
    }

    private void processUserOperation(String function) {
        if (function.equals("1")) {
            addPlayerToTeam();
        }
        if (function.equals("2")) {
            fantasyTeam.removePlayer(removePlayer());
        }
        if (function.equals("3")) {
            viewTeam();
        }
        if (function.equals("4")) {
            viewTeamPoints();
        }
    }

    private void addPlayerToTeam() {
        String playerName;
        String position;
        int goals;
        int assists;
        Player playerToBeAdded = new Player();

        System.out.println("Please enter the player's name");
        playerName = scanner.nextLine();

        System.out.println("Is the player a forward, midfielder, defender, or goalkeeper?");
        position = scanner.nextLine();

        System.out.println("Please enter how many goals the player scored this gameweek");
        goals = scanner.nextInt();

        System.out.println("Please enter how many assists the player had this gameweek");
        assists = scanner.nextInt();
        scanner.nextLine();

        playerToBeAdded.makeplayer(playerName,position,goals,assists);
        System.out.println("You've added " + playerName + " to your team");
        fantasyTeam.addPlayer(playerToBeAdded);
    }

    private Player removePlayer() {
        String playerToBeRemoved;

        System.out.println("Enter the name of the player you would like to remove");
        playerToBeRemoved = scanner.nextLine();
        for (Player player : fantasyTeam.getSquad()) {
            if (player.getPlayerName().equals(playerToBeRemoved)) {
                return player;
            }
        }
        return null;
    }

    private void viewTeam() {
        System.out.println(fantasyTeam.allPlayerNames());
    }

    private void viewTeamPoints() {
        System.out.println(fantasyTeam.calculateTeamPoints());
    }

    public static void main(String[] args) {
        new Main();
    }
}