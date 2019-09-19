import java.util.Scanner;
import java.util.ArrayList;

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

        String function = "";
        Team yourTeam = new Team();

        while (true) {
            System.out.println("Please pick an option: [1] to add player to your team"
                    + " [2] to remove a player from your team"
                    + " [3] to see your team"
                    + " [4] to quit");
            function = scanner.nextLine();
            System.out.println("You selected: " + function);

            if (function.equals("4")) {
                break;
            }
            processUserOperation(function);
        }
    }

    private void processUserOperation(String function) {
        if (function.equals("1")) {
            addPlayer();
        }
        if (function.equals("2")) {
            removePlayer();
        }
        if (function.equals("3")) {
            viewTeam();
        }
    }

    private void addPlayer() {
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
        fantasyTeam.addPlayer(playerToBeAdded);
    }

    private void removePlayer() {
    }

    private void viewTeam() {
        System.out.println(fantasyTeam.allPlayerNames());
    }

    public static void main(String[] args) {
        new Main();
    }




}
