/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package oop_project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class UseropenController implements Initializable {

    @FXML
    private MenuBar Menubar;
    @FXML
    private TextField Nametxt;
    @FXML
    private TextField passtext;
    @FXML
    private MenuItem SpecialId;
    @FXML
    private MenuItem EmergencyID;
    @FXML
    private TextField Userfieldname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SwitchToemergency(ActionEvent event) {
        Userfieldname.setText("EmergencyManager");
        
        
    }

    @FXML
    private void Switchtospecial(ActionEvent event) {
   Userfieldname.setText("Special unit manager");
    }

    @FXML
    private void SwitchtoSceneonclick(ActionEvent event) throws IOException {
   
    if(Nametxt.getText().equals("Yazda")&& passtext.getText().equals("12345") && Userfieldname.getText().equals("EmergencyManager"))
    
    {
    
         Parent root=FXMLLoader.load(getClass().getResource("EmergencyManager.fxml"));
        Scene newScene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.show();
        
        
    }
    
    else if(Nametxt.getText().equals("Yazda")&& passtext.getText().equals("12345") && Userfieldname.getText().equals("Special unit manager"))
    {
    
    Parent root=FXMLLoader.load(getClass().getResource("SpecialUnitManager.fxml"));
        Scene newScene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.show();
    
    
    }
    passtext.setVisible(false);
    
    }
    
}
