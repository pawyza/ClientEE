/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author kamil
 */

public class AddClientController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    String data[] = new String[4];
    
    @FXML
    private TextField idOfClient;

    @FXML
    private TextField cardNumberOfClient;

    @FXML
    private TextField loginOfClient;

    @FXML
    private TextField passwordOfClient;

    @FXML
    void btn_OK_OnAction(ActionEvent event) {
      data[2] = idOfClient.getText();
        data[0] = cardNumberOfClient.getText();
        data[1] = loginOfClient.getText();
        data[3] = passwordOfClient.getText();
        OptionsController.recordStage.close();
        Main.getFacade().addClient(data);
        
    }

    @FXML
    void btn_Return_OnAction(ActionEvent event) {
        OptionsController.recordStage.close();
    }

    @FXML
    void recordOnAction(ActionEvent event) {
    }
}
