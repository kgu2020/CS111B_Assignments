/**
 * Algorithm:
 * 1) Instansiate 2D array of Cell objects
 * 2) Add each Cell and label to the board
 * 3) Set a token and draw appropriate shape when a Cell is clicked
 * 4) Check if current player wins, or if board is full
 * 5) Move to other player if nobody has won and board is not full
 */
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Ellipse;

/**
* XsAndOs program simulates the game of TicTacToe using JavaFx.
*
* @author Ken Gu
* @version 1.0
* @since 2020-04-22
*/
public class XsAndOs  extends Application {

    private boolean gameOver = false;  //flag
    private char whoseTurn = 'X'; // 'X' or 'O' but 'X' starts
    private Cell[][] board =  new Cell[3][3];  //the 2-D array board for playing
    private Label statusLabel = new Label("X's turn to play");  //let user know status of game


    /**
    * The start() method sets up the graphics and instantiates the Cell objects.
    * @param primaryStage A Stage object.
    * @return void
    */
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        //generating cells
        for (int row = 0; row < board.length; row++) {
          for (int col = 0; col < board[row].length; col++) {
            board[row][col] = new Cell();
            pane.add(board[row][col], row, col);
          }
        }

        BorderPane borderPane = new BorderPane(); //the BoarderPane gives us control over layout of stage
        borderPane.setCenter(pane);  //set center of the stage to be the GridPane object 'pane'
        borderPane.setBottom(statusLabel); //set bottom of the stage to be the Label object 'statusLabel'

        Scene scene = new Scene(borderPane, 300, 300);
        primaryStage.setTitle("XsAndOs");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
    * The isFull() method checks if the board has empty Cells.
    * @return boolean If the board is full or not.
    */
    public boolean isFull() {
        boolean emptyCell = false;
        for (int row = 0; row < board.length; row++) {
          for (int col = 0; col < board[row].length; col++) {
            if (board[row][col].getToken() == ' ') {
              emptyCell = true;
            }
          }
        }
        if (emptyCell == true) {
          return false;
        }
        else {
          return true;
        }
    }
    /**
    * The hasWon() method checks if the winning conditions are met.
    * @param tkn A char primitive; either 'X' or 'O' is valid.
    * @return boolean If there is 3 in a row/col/diag for the value of tkn or not.
    */
    public boolean hasWon(char tkn) {
        boolean won = false;
        for (int row = 0; row < board.length; row++) {
          for (int col = 0; col < board[row].length; col++) {
            //horizontal check
            if (col == board[row].length - 1) {
              if (board[row][col].getToken() == tkn && board[row][col - 1].getToken() == tkn && board[row][col - 2].getToken() == tkn) {
                won = true;
              }
            }
            //vertical check
            if (row == board.length - 1) {
              if (board[row][col].getToken() == tkn && board[row - 1][col].getToken() == tkn && board[row - 2][col].getToken() == tkn) {
                won = true;
              }
            }
            //diagonal check
            if (board[0][0].getToken() == tkn && board[1][1].getToken() == tkn && board[2][2].getToken() == tkn) {
              won = true;
            }
            else if (board[0][2].getToken() == tkn && board[1][1].getToken() == tkn && board[2][0].getToken() == tkn) {
              won = true;
            }
          }
        }
        if (won == true) {
          return true;
        }
        else {
          return false;
        }
    }

    /**
     * The Cell class represents each cell in the board used by XsAndOs.
     *
     * @author Ken Gu
     * @version 1.0
     * @since 2020-04-22
     */
    public class Cell extends Pane {

        private char token = ' ';   // one of blank, X, or O
        /**
        * Constructor for Cell an object.
        * @param No_Parameters
        */
        public Cell() {
            setStyle("-fx-border-color: black");
            setPrefSize(100, 100);
            setOnMouseClicked(e -> handleMouseClick());
        }
        /**
        * getToken() accesses the instance variable of the Cell.
        * @return char token The instance variable of the Cell.
        */
        public char getToken() {
            return token;
        }
        /**
        * drawX() generates a X shape on the Cell.
        * @return void
        */
        public void drawX() {
            double w = getWidth();
            double h = getHeight();
            Line line1 = new Line(0, 0, w, h);
            Line line2 = new Line(0, h, w, 0);
            getChildren().addAll(line1, line2);
        }
        /**
        * drawO() generates a ellipse shape on the Cell.
        * @return void
        */
        public void drawO() {
            double w = getWidth();
            double h = getHeight();
            Ellipse ellipse = new Ellipse((w / 2), (h / 2), (w / 2), (h / 2));
            ellipse.setStroke(Color.BLACK);
            ellipse.setFill(Color.WHITE);
            getChildren().add(ellipse);
        }
        /**
        * setToken() Changes the instance variable token proceeds
        * call either drawX() or drawO() based on param.
        * @param c A char primitive; either 'X' or 'O' is valid.
        * @return void
        */
        public void setToken(char c) {
            token = c;
            if (token == 'X') {
              drawX();
            }
            else if (token == 'O') {
              drawO();
            }
        }
        /**
        * handleMouseClick() is the event handler for clicking on a Cell
        * the method contains logic of the game.
        * @return void
        */
        private void handleMouseClick() {
            String s = "";
            if (!gameOver) {
                if (whoseTurn == 'X') {
                  setToken('X');
                  if (hasWon('X') == true) {
                    gameOver = true;
                    s = "X has won";
                  }
                  else if (isFull() == true) {
                    gameOver = true;
                    s = "Board is full";
                  }
                  else {
                    whoseTurn = 'O';
                    s = "O's turn";
                  }
                }
                else if (whoseTurn == 'O') {
                  setToken('O');
                  if (hasWon('O') == true) {
                    gameOver = true;
                    s = "O has won";
                  }
                  else if (isFull() == true) {
                    gameOver = true;
                    s = "Board is full";
                  }
                  else {
                    whoseTurn = 'X';
                    s = "X's turn";
                  }
                }
            }
            else {
              s = "The game is already over";
            }
            statusLabel.setText(s);
        }
    }
    /**
    * main() Start of the program; launches command line argument.
    * @param args A String containing command line argument.
    * @return void
    */
    public static void main(String[] args) {
        launch(args);
    }
}
