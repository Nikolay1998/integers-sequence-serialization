package sample;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.WindowEvent;

import javax.xml.bind.JAXBException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    TextField indexTextField;
    @FXML
    TextField valueTextField;
    @FXML
    Button addButton;
    @FXML
    Label stateLabel;
    @FXML
    Label errorLabel;

    private StateManager stateManager;
    private ArrayList<Integer> sequence;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            stateManager = new StateManager();
            sequence = stateManager.getState();
            stateLabel.setText(sequence.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void add() {
        errorLabel.setText("");
        try {
            Integer index = Integer.valueOf(indexTextField.getText());
            Integer value = Integer.valueOf(valueTextField.getText());
            sequence.add(index, value);
            stateLabel.setText(sequence.toString());
            System.out.println("Add!");
        }catch (NumberFormatException ex){
            errorLabel.setText("Enter correct index and value");
        }catch (IndexOutOfBoundsException ex){
            errorLabel.setText("Can't add element with " + indexTextField.getText() + " index");
        }

    }

    public void delete() {
        errorLabel.setText("");
        try {
            Integer index = Integer.valueOf(indexTextField.getText());
            sequence.remove((int) index);
            stateLabel.setText(sequence.toString());
            System.out.println("Delete!");
        }catch (NumberFormatException ex){
            errorLabel.setText("Enter correct index");
        }catch (IndexOutOfBoundsException e){
            errorLabel.setText("There is no element with " + indexTextField.getText() + " index");
        }
    }

    public void onClose() {
        try {
            stateManager.setState(sequence);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
