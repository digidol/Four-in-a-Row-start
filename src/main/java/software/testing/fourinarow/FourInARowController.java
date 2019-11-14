package software.testing.fourinarow;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.MenuItem; 

/**
 * Controller for the main user interface. This will respond to the 
 * user interface events, e.g. button presses. 
 * 
 * @author Neil Taylor (nst@aber.ac.uk)
 */
public class FourInARowController implements Initializable {
    
	/**
     * A link to the text area that is shown at the bottom of the main window.
     */
    @FXML
    private TextArea messageArea;
    
    /**
     * Link to the undo menu item. 
     */ 
    @FXML 
    private MenuItem undoMenuItem; 
    
    /** 
     * Link to the redo menu item. 
     */
    @FXML 
    private MenuItem redoMenuItem; 
    
    /**
     * A link to the grid that shows the different squares that represent 
     * the game. This is a link to the GridPane shown in the JavaFX
     * user interface.
     */
    @FXML
    private GridPane boardGrid;
    
    /**
     * Displays the current state of the board. This will redraw the 
     * entire board on the screen. 
     */
    private void displayBoard() {

        // TODO - fill in this method. It should get information
        // from the game class about the status for the cell. It can
        // then use that information to set the colour of the cell in the
        // JavaFX panel.

        // You can use CSS colours to set the colour of the background
        // for a cell in the JavaFX display. The suggested colours are:
        // "#eaeaea" for empty cells
        // "#00f" for Player One cells
        // "#f00" for Player Two cells
        //
        // For example: String colour = "#000"; could be a default value
        // and then you have some logic for which colour to use for the
        // CellStatus.

        // The following method call will get you the node for the
        // given row and cell value. Note that the Game class uses 0
        // to represent the first row. However, the following method
        // assumes that 1 is the first row.
        // Node node = getNodeByRowColumnIndex(row + 1, column)

        // To set the colour of the node, you can use the following lines
        // if(node instanceof Pane) {
        //     node.setStyle("-fx-background-color: " + colour);
        // }
        // else {
        //     messageArea.setText("Describe some error");
        // }

    }
    
    /**
     * Handles a button press from one of the buttons at the top of the 
     * screen. When the button is pressed, it checks if there is a space in 
     * the same column as the button. If there is a space, the space is 
     * set to the value for the current player. The board is then redisplayed.  
     * 
     * @param event The event that specifies which button was pressed. 
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        // determine the column number for the column that contains the button
        // The event.getSource() will represent the button.
        GridPosition position = getGridPositionForNode((Node)event.getSource());
        int selectedColumn = position.getColumn();
        messageArea.setText("Column " + (selectedColumn + 1) + " selected");

        // TODO - use the Game class to try and add a piece of the
        // column. If it can be added, update the display. If it cannot be added
        // show a message in the messageArea, for example:
        // messageArea.setText("No available positions in this column.");

    }

    /**
     * Gets the position of a node in the GridPane. From the node, the 
     * row and column position is extracted. This is then placed into 
     * a GridPosition object. 
     * 
     * @param node The node from the user interface, e.g. a Pane. 
     * @return A GridPosition object. 
     */
    public GridPosition getGridPositionForNode(Node node) { 
        GridPosition position = new GridPosition(); 
        position.setRow(GridPane.getRowIndex(node)); 
        position.setColumn(GridPane.getColumnIndex(node));
        return position;
    }
    
    /**
     * Given a row and column pair, this method identifies the Node that is held within the 
     * grid pane that shows the board. A node is a visual component. For this application, 
     * it is a Button if it is in the top column. Otherwise, this is a Pane, which is rectangular 
     * block that we are setting to a colour to represent a move played. 
     * 
     * @param row The row. 
     * @param column The column. 
     * @return If a node is found it is returned. Otherwise, null is returned. 
     */
    public Node getNodeByRowColumnIndex (int row, int column) {
        Node result = null;
        ObservableList<Node> children = boardGrid.getChildren();
        
        for (Node node : children) {
            GridPosition position = getGridPositionForNode(node);
            if (row == position.getRow() && column == position.getColumn()) { 
                result = node;
                break;
            }
        }
        return result;
    }
    
    /**
     * Shows an About dialog. 
     * @param event The event that started the action.
     */
    @FXML
    private void handleAboutDialogAction(ActionEvent event) {
        FourInARowDialogController dialogController = new FourInARowDialogController(); 
        dialogController.showDialog(boardGrid.getScene().getWindow());
    }
    
    /**
     * Starts a game with two human players. This will initialise an empty board and
     * display that to the screen. The default situation is that the top level buttons 
     * are not enabled. This method will enable them so that the players can select 
     * which column to make a move with. 
     * 
     * @param event The event that sarted the action.
     */
    @FXML
    private void handleStartTwoPlayerGameAction(ActionEvent event) { 

        // TODO - initialise the game

        displayBoard();

        // reset the buttons so that they can be pressed.
        for(int column = 0; column < 7; column++) { 
            Node node = getNodeByRowColumnIndex(0, column);
            if(node instanceof Button) { 
                ((Button)node).setDisable(false);
            }
            else { 
                System.err.println("Unexpected item found: " + node);
            }
        }
        
        messageArea.setText("Starting a two player game.");
    }
    
    /**
     * A place where you could add support for a single person game. You would use this 
     * to start a game where one of the players is your computer player. 
     * 
     * @param event The event that generated this action. 
     */
    @FXML 
    private void handleStartOnePlayerGameAction(ActionEvent event) { 
    	messageArea.setText("Not implemented - implement this if you start work on a computer player.");
    }
    
    /**
     * Quits the application by calling System.exit(0); 
     * @param event The event that specifies which user interface item generated 
     * the action. In this case, it is a menu item.
     */
    @FXML
    private void handleQuitAction(ActionEvent event) { 
       System.exit(0); 
    }
    
    /** 
     * Responds to the Undo action being called from the menu. 
     */
    @FXML
    private void handleUndoAction(ActionEvent event) {
        // TODO - use the Game class to undo the most recent move. Then, redisplay the board.
        messageArea.setText("undo");
    }
    
    /** 
     * Responds to the Redo action being called from the menu. 
     */
    @FXML
    private void handleRedoAction(ActionEvent event) {
        // TODO - use the Game class to redo the most recent move that was undone. Then, redisplay the board.
       messageArea.setText("redo");  
    }
    
    /** 
     * Required as part of the Initializable interface. Not used in this class.
     * @param url Not used. 
     * @param rb Not used.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // EMPTY - this method does not need any content.
    }    
    
}
