package ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainGraphics extends Application {
    private int width = 600;
    private int height = 600;
    private Button startButton;
    private Button quitButton;
    private Button playerAddButton;
    private Button playerRemoveButton;
    private Button viewTeamButton;
    private Button viewTeamBackButton;
    private Button viewTeamPointsButton;
    private Button viewTeamPointsBackButton;
    private Button loadSaveButton;
    private Button returnToMainButton;

    private FantasyTeam fantasyTeam = new FantasyTeam();

    private Image addButton;
    private String addButtonURL = "/Users/Shaochen/Desktop/210/project_m1o2b/src/main/ui/Images/plus.png";

    private Image removeButton;
    private String removeButtonURL = "/Users/Shaochen/Desktop/210/project_m1o2b/src/main/ui/Images/remove.png";

    private Image soccer;
    private String soccerURL = "/Users/Shaochen/Desktop/210/project_m1o2b/src/main/ui/Images/soccer.jpg";

    private Image soccerTeam;
    private String soccerTeamURL = "/Users/Shaochen/Desktop/210/project_m1o2b/src/main/ui/Images/team.png";

    private Image trophy;
    private String trophyURL = "/Users/Shaochen/Desktop/210/project_m1o2b/src/main/ui/Images/trophy.png";

    private Image back;
    private String backURL = "/Users/Shaochen/Desktop/210/project_m1o2b/src/main/ui/Images/back.png";

    private Image load;
    private String loadURL = "/Users/Shaochen/Desktop/210/project_m1o2b/src/main/ui/Images/folder.png";


    private Stage window;
    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private Scene scene4;
    private Scene scene5;
    private Scene scene6;

    private GridPane layout3;
    private GridPane layout4;
    private GridPane layout5;
    private GridPane layout6;

    private TextField name;
    private TextField position;
    private TextField goals;
    private TextField assists;

    private TextField playerRemoved;

    private Label userInstruction;
    private Label positionInfo;
    private Label addMessage;
    private Label removeMessage;
    private Label printTeam;
    private Label printTeamPoints;

    private Alert alert;

    // MODIFIES: this
    // EFFECTS: starts the GUI at the initial stage
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        primaryStage.setTitle("Shao's Fantasy Team");
        startScene();
        selectScene();
        addScene();
        removeScene();
        viewTeamScene();
        viewTeamPointsScene();
        window.show();
        window.setScene(scene1);
        window.setTitle("Shao's fantasy soccer");
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Changing pane colour from https://stackoverflow.com/questions/22614758/issue-with-background-color-in-javafx-8
    private void startScene() throws FileNotFoundException {
        // Menu image
        soccer = new Image(new FileInputStream(soccerURL));
        ImageView loadingImage = new ImageView(soccer);
        loadingImage.setFitWidth(400);
        loadingImage.setFitHeight(200);

        // Start and quit buttons
        setStartButton();
        setQuitButton();

        StackPane layout1 = new StackPane();
        layout1.setPadding(new Insets(40, 50, 0, 50));
        VBox vbox = new VBox(15);
        vbox.getChildren().addAll(startButton, quitButton);

        layout1.getChildren().add(vbox);
        layout1.getChildren().add(loadingImage);
        StackPane.setAlignment(vbox, Pos.CENTER);
        layout1.setStyle("-fx-background-color: #03befc;");
        scene1 = new Scene(layout1, width, height);
    }

    private void selectScene() throws FileNotFoundException {
        // Button for adding player
        setPlayerAddButton();

        // Button for removing player
        setPlayerRemoveButton();

        // Button for viewing team
        setViewTeamButton();

        // Button for viewing team points
        setViewTeamPointsButton();

        // Button for loading previous save
        setLoadSaveButton();

        // Button for returning to main screen
        setReturnToMainButton();

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(playerAddButton, playerRemoveButton, viewTeamButton, viewTeamPointsButton);
        vbox.getChildren().addAll(loadSaveButton, returnToMainButton);

        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(vbox);
        StackPane.setAlignment(vbox, Pos.CENTER);
        layout2.setStyle("-fx-background-color: #00ccff;");
        scene2 = new Scene(layout2, width, height);
    }

    private void addScene() {
        setUpLayput3();
        // Information for user
        setUserInstructions();
        setPositionInfo();

        // Inputs
        nameInput();
        positionInput();
        goalInput();
        assistsInput();

        // Buttons
        submitButton();
        clearButton();
        backButton();

        scene3 = new Scene(layout3, width, height);
    }

    private void removeScene() {
        layout4 = new GridPane();
        layout4.setPadding(new Insets(50, 50, 50, 50));
        layout4.setStyle("-fx-background-color: #0099ff;");
        layout4.setVgap(5);
        layout4.setHgap(5);

        // Information for user
        removePlayerInstruction();

        // Input
        nameOfPlayerRemoved();

        // Buttons
        submitRemoveButton();
        clearRemoveButton();
        backRemoveButton();

        // Player removed message
        setRemoveMessage();

        scene4 = new Scene(layout4, width, height);
    }

    private void viewTeamScene() {
        layout5 = new GridPane();
        layout5.setPadding(new Insets(50, 50, 50, 50));
        layout5.setStyle("-fx-background-color: #0099ff;");
        layout5.setVgap(50);
        layout5.setHgap(10);

        setPrintTeam();

        backViewTeamButton();

        scene5 = new Scene(layout5, width, height);
    }

    private void viewTeamPointsScene() {
        layout6 = new GridPane();
        layout6.setPadding(new Insets(50, 50, 50, 50));
        layout6.setStyle("-fx-background-color: #0099ff;");
        layout6.setVgap(10);
        layout6.setHgap(5);

        setPrintTeamPoints();

        backViewTeamPointsButton();

        scene6 = new Scene(layout6, width, height);
    }

    // Setting font from https://www.tutorialspoint.com/javafx/javafx_text.htm
    private void setUserInstructions() {
        userInstruction = new Label();
        userInstruction.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
        GridPane.setConstraints(userInstruction, 0, 0);
        GridPane.setColumnSpan(userInstruction, 2);
        userInstruction.setText("Please enter the player's data.");
        layout3.getChildren().addAll(userInstruction);
    }

    private void setPositionInfo() {
        positionInfo = new Label();
        positionInfo.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10.5));
        GridPane.setConstraints(positionInfo, 0, 1);
        GridPane.setRowSpan(positionInfo, 1);
        positionInfo.setText("Positions: forward, midfielder, defender, or goalkeeper");
        layout3.getChildren().addAll(positionInfo);
    }

    private void setUpLayput3() {
        layout3 = new GridPane();
        layout3.setPadding(new Insets(50, 50, 50, 50));
        layout3.setStyle("-fx-background-color: #0099ff;");
        layout3.setVgap(10);
        layout3.setHgap(5);
    }

    private void setStartButton() {
        startButton = new Button("Start");
        startButton.setStyle("-fx-font: 24 verdana;");
        startButton.setMaxWidth(Double.MAX_VALUE);
        startButton.setPrefHeight(50);
        startButton.setOnAction(event -> window.setScene(scene2));
    }

    private void setQuitButton() {
        quitButton = new Button("Quit");
        quitButton.setStyle("-fx-font: 24 verdana;");
        quitButton.setMaxWidth(Double.MAX_VALUE);
        quitButton.setPrefHeight(50);
        quitButton.setOnAction(event -> {
            try {
                fantasyTeam.save(fantasyTeam.getFantasyTeam());
            } catch (IOException e) {
                e.printStackTrace();
            }
            Platform.exit();
        });
    }

    private void setPlayerAddButton() throws FileNotFoundException {
        addButton = new Image(new FileInputStream(addButtonURL));
        ImageView addPlayerButton = new ImageView(addButton);
        addPlayerButton.setFitHeight(50);
        addPlayerButton.setFitWidth(50);
        playerAddButton = new Button("Add Player", addPlayerButton);
        playerAddButton.setStyle("-fx-font: 14 verdana;");
        playerAddButton.setMaxWidth(Double.MAX_VALUE);

        playerAddButton.setOnAction(event -> {
            window.setScene(scene3);
        });
    }

    private void setPlayerRemoveButton() throws FileNotFoundException {
        removeButton = new Image(new FileInputStream(removeButtonURL));
        ImageView removePlayerButton = new ImageView(removeButton);
        removePlayerButton.setFitHeight(50);
        removePlayerButton.setFitWidth(50);
        playerRemoveButton = new Button("Remove Player", removePlayerButton);
        playerRemoveButton.setStyle("-fx-font: 14 verdana;");
        playerRemoveButton.setMaxWidth(Double.MAX_VALUE);

        playerRemoveButton.setOnAction(event -> {
            window.setScene(scene4);
        });
    }

    private void setViewTeamButton() throws FileNotFoundException {
        soccerTeam = new Image(new FileInputStream(soccerTeamURL));
        ImageView soccerTeamButton = new ImageView(soccerTeam);
        soccerTeamButton.setFitHeight(50);
        soccerTeamButton.setFitWidth(50);
        viewTeamButton = new Button("View Team", soccerTeamButton);
        viewTeamButton.setStyle("-fx-font: 14 verdana;");
        viewTeamButton.setMaxWidth(Double.MAX_VALUE);

        viewTeamButton.setOnAction(event -> {
            window.setScene(scene5);
        });
    }

    private void setViewTeamPointsButton() throws FileNotFoundException {
        trophy = new Image(new FileInputStream(trophyURL));
        ImageView trophyButton = new ImageView(trophy);
        trophyButton.setFitHeight(50);
        trophyButton.setFitWidth(50);
        viewTeamPointsButton = new Button("View Team Points", trophyButton);
        viewTeamPointsButton.setStyle("-fx-font: 14 verdana;");
        viewTeamPointsButton.setMaxWidth(Double.MAX_VALUE);

        viewTeamPointsButton.setOnAction(event -> {
            window.setScene(scene6);
        });
    }

    private void setLoadSaveButton() throws FileNotFoundException {
        load = new Image(new FileInputStream(loadURL));
        ImageView loadButton = new ImageView(load);
        loadButton.setFitHeight(50);
        loadButton.setFitWidth(50);

        popup();

        loadSaveButton = new Button("Load Previous Save", loadButton);
        loadSaveButton.setStyle("-fx-font: 14 verdana;");
        loadSaveButton.setMaxWidth(Double.MAX_VALUE);

        loadSaveButton.setOnAction(event -> {
            alert.showAndWait();
            try {
                fantasyTeam.setFantasyTeam(fantasyTeam.load());
                setTeamInformation();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }

    // Popup window from https://code.makery.ch/blog/javafx-dialogs-official/
    private void popup() {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Information");
        alert.setContentText("Previous Save has been loaded");
    }

    private void setReturnToMainButton() throws FileNotFoundException {
        back = new Image(new FileInputStream(backURL));
        ImageView backButton = new ImageView(back);
        backButton.setFitHeight(50);
        backButton.setFitWidth(50);
        returnToMainButton = new Button("Back", backButton);
        returnToMainButton.setStyle("-fx-font: 14 verdana;");
        returnToMainButton.setMaxWidth(Double.MAX_VALUE);

        returnToMainButton.setOnAction(event -> {
            window.setScene(scene1);
        });
    }

    private void submitButton() {
        // Submit button
        Button submit = new Button("Submit");
        GridPane.setConstraints(submit, 2, 3);
        layout3.getChildren().add(submit);

        setAddMessage();

        submit.setOnAction(event -> {
            String playerName = name.getText();
            String playerPosition = position.getText();
            int intGoals = Integer.parseInt(goals.getText());
            int intAssists = Integer.parseInt(assists.getText());

            try {
                fantasyTeam.playerCreator(playerName, playerPosition, intGoals, intAssists);
                clearInput();
                addMessage.setText("Player added: " + playerName);
                setTeamInformation();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    private void setAddMessage() {
        addMessage = new Label();
        addMessage.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        GridPane.setConstraints(addMessage, 0, 7);
        GridPane.setColumnSpan(addMessage, 2);
        layout3.getChildren().add(addMessage);
    }

    // Clear button from https://docs.oracle.com/javafx/2/ui_controls/text-field.htm
    private void clearButton() {
        // Clear button
        Button clear = new Button("Clear");
        GridPane.setConstraints(clear, 3, 3);
        layout3.getChildren().add(clear);

        clear.setOnAction(event -> {
            clearInput();
        });
    }

    private void backButton() {
        // Back button
        Button back = new Button("Back");
        GridPane.setConstraints(back, 4, 3);
        layout3.getChildren().add(back);
        back.setOnAction(event -> {
            window.setScene(scene2);
            clearInput();
        });
    }

    private void nameInput() {
        // Name Input
        name = new TextField();
        name.setPromptText("Enter the player's name");
        name.setPrefColumnCount(10);
        name.setFocusTraversable(false);
        GridPane.setConstraints(name, 0, 3);
        layout3.getChildren().addAll(name);
    }

    private void positionInput() {
        // Position Input
        position = new TextField();
        position.setPromptText("Enter the position");
        position.setFocusTraversable(false);
        GridPane.setConstraints(position, 0, 4);
        layout3.getChildren().addAll(position);
    }

    private void goalInput() {
        // goals Input
        goals = new TextField();
        goals.setPromptText("Enter the goals");
        goals.setFocusTraversable(false);
        GridPane.setConstraints(goals, 0, 5);
        layout3.getChildren().add(goals);
    }

    private void assistsInput() {
        // assists Input
        assists = new TextField();
        assists.setPromptText("Enter the assists");
        assists.setFocusTraversable(false);
        GridPane.setConstraints(assists, 0, 6);
        layout3.getChildren().add(assists);
    }

    private void clearInput() {
        name.clear();
        position.clear();
        goals.clear();
        assists.clear();
        addMessage.setText("");
    }

    private void removePlayerInstruction() {
        Label removeInstruction = new Label();
        removeInstruction.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
        GridPane.setConstraints(removeInstruction, 0, 0);
        GridPane.setRowSpan(removeInstruction, 1);
        removeInstruction.setText("Please enter the player's data.");
        layout4.getChildren().addAll(removeInstruction);
    }

    private void nameOfPlayerRemoved() {
        playerRemoved = new TextField();
        playerRemoved.setPromptText("Enter the player's name");
        playerRemoved.setPrefColumnCount(10);
        playerRemoved.setFocusTraversable(false);
        GridPane.setConstraints(playerRemoved, 0, 3);
        layout4.getChildren().addAll(playerRemoved);
    }

    private void submitRemoveButton() {
        // Submit button for removing player
        Button removeSubmitButton = new Button("Submit");
        GridPane.setConstraints(removeSubmitButton, 2, 3);
        layout4.getChildren().add(removeSubmitButton);

        removeSubmitButton.setOnAction(event -> {
            String playerToBeRemoved = playerRemoved.getText();
            removeMessage.setText("Player removed: " + playerToBeRemoved);
            fantasyTeam.removePlayerFromTeam(playerToBeRemoved);
            setTeamInformation();
            clearInput();
        });
    }

    private void clearRemoveButton() {
        // Clear button for removing player
        Button removeClearButton = new Button("Clear");
        GridPane.setConstraints(removeClearButton, 3, 3);
        layout4.getChildren().add(removeClearButton);

        removeClearButton.setOnAction(event -> {
            clearInput();
        });
    }

    private void backRemoveButton() {
        // Back button for removing player
        Button removeBackButton = new Button("Back");
        GridPane.setConstraints(removeBackButton, 4, 3);
        layout4.getChildren().add(removeBackButton);
        removeBackButton.setOnAction(event -> {
            window.setScene(scene2);
            clearInput();
        });
    }

    private void setRemoveMessage() {
        removeMessage = new Label();
        removeMessage.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 16));
        GridPane.setConstraints(removeMessage, 0, 7);
        GridPane.setColumnSpan(removeMessage, 2);
        layout4.getChildren().add(removeMessage);
    }

    private void setPrintTeam() {
        printTeam = new Label();
        printTeam.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 24));
        printTeam.setMinWidth(Region.USE_PREF_SIZE);
        printTeam.setMinHeight(Region.USE_PREF_SIZE);
        GridPane.setConstraints(printTeam, 0, 0);
        GridPane.setColumnSpan(printTeam, 2);
        layout5.getChildren().add(printTeam);
    }

    private void backViewTeamButton() {
        // Back button for viewing team
        viewTeamBackButton = new Button("Back");
        GridPane.setConstraints(viewTeamBackButton, 3, 3);
        viewTeamBackButton.setStyle("-fx-font: 20 verdana;");
        viewTeamBackButton.setPrefWidth(200);
        layout5.getChildren().add(viewTeamBackButton);
        viewTeamBackButton.setOnAction(event -> {
            window.setScene(scene2);
        });
    }

    private void setPrintTeamPoints() {
        printTeamPoints = new Label();
        printTeamPoints.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        GridPane.setConstraints(printTeamPoints, 0, 0);
        GridPane.setColumnSpan(printTeamPoints, 2);
        layout6.getChildren().add(printTeamPoints);
    }

    private void backViewTeamPointsButton() {
        // Back button for viewing team points
        viewTeamPointsBackButton = new Button("Back");
        GridPane.setConstraints(viewTeamPointsBackButton, 3, 3);
        viewTeamPointsBackButton.setAlignment(Pos.CENTER);
        viewTeamPointsBackButton.setStyle("-fx-font: 20 verdana;");
        viewTeamPointsBackButton.setPrefWidth(200);
        layout6.getChildren().add(viewTeamPointsBackButton);
        viewTeamPointsBackButton.setOnAction(event -> {
            window.setScene(scene2);
        });
    }

    private void setTeamInformation() {
        printTeam.setText(fantasyTeam.returnAllPlayerNames());
        printTeamPoints.setText(fantasyTeam.viewTeamPointsString());
    }
}
