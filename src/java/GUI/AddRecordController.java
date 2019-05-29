/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import Model.RecordM;
import Model.TitleRecordM;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author User
 */
public class AddRecordController implements Initializable {

    @FXML
    private ComboBox<TitleRecordM> titleRecordBox;

    @FXML
    private TextField recordField;

    @FXML
    private Text infoField;
    
    private String[] titleRecordHelper;

    @FXML
    void on_Add(ActionEvent event) {
        String data2[] = {recordField.getText()};
        Main.getFacade().addRecord(titleRecordHelper, data2);
        infoField.setText("Dodano Record z danymi " + titleRecordBox.getValue().toString() + "  Record number: " + data2);
        }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        List<String[]> helper = Main.getFacade().getTitleRecordStrings();
        List<TitleRecordM> listHelper = new ArrayList(); 
        for (String[] t : helper) {
            listHelper.add(new TitleRecordM(t[0],t[1],t[2],t[3],t[4]));
        }
         ObservableList<TitleRecordM> list = FXCollections.observableArrayList(listHelper);
        titleRecordBox.setItems(list);
    }
    
    @FXML
    void recordOnAction(ActionEvent event) {
        TitleRecordM help = titleRecordBox.getSelectionModel().getSelectedItem();
        System.out.println("");
        String type;
        if(help.getGenre() == null){
            type = "2";
        }else if(help.getGenre() == null && help.getCast() == null){
            type="1";
        }else if(help.getAuthor() == null && help.getGenre() == null && help.getCast() == null){
            type="0";
        }else{
            type="3";
        }
        titleRecordHelper = new String[]{type, help.getId(), help.getTitle(), help.getAuthor(), help.getCast(), help.getGenre()};
    }
}
