/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package oop_project;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AirSectionController implements Initializable {

    @FXML
    private TableView<Airsection> AircraftDatatable;
    @FXML
    private TableColumn<Airsection, Integer> AircraftID;
    @FXML
    private TableColumn<Airsection, Integer> PilotID;
    @FXML
    private TableColumn<Airsection, String> PilotName;
    @FXML
    private TextField InsertAirId;
    @FXML
    private TextField InsertPilotId;
    @FXML
    private TextField InsertPilotname;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AircraftID.setCellValueFactory(new PropertyValueFactory<Airsection,Integer>("Aircraft Id"));
        PilotID.setCellValueFactory(new PropertyValueFactory<Airsection,Integer>(" Pilot Id"));
        PilotName.setCellValueFactory(new PropertyValueFactory<Airsection,String>(" Pilot name"));
        
    }    

    @FXML
    private void ShowDataonClick(ActionEvent event) {
    }

    @FXML
    private void ResetonClick(ActionEvent event) {
    }

    
}
