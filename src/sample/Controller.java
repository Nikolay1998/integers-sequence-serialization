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
        Integer index = Integer.valueOf(indexTextField.getText());
        Integer value = Integer.valueOf(valueTextField.getText());
        sequence.add(index, value);
        stateLabel.setText(sequence.toString());
        System.out.println("Add!");
    }

    public void delete() {
        Integer index = Integer.valueOf(indexTextField.getText());
        sequence.remove((int)index);
        stateLabel.setText(sequence.toString());
        System.out.println("Delete!");
    }

    public void onClose() {
        try {
            stateManager.setState(sequence);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
