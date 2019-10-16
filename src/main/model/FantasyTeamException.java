package model;

public class FantasyTeamException extends Exception {
    FantasyTeamException(String exception) {
        super("Fantasy Team Exception: " + exception);
    }
}
