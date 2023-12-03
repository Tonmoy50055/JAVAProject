/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package oop_project;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Tooltip;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class GraphforEmergencyController implements Initializable {

    @FXML
    private PieChart PiechartforEmp;


    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       // TODO
    setupPieChartData();
    ObservableList<PieChart.Data> generatedPieDataSet
                = GraphicalratioforEmergency.piechartforEmp();
        if(generatedPieDataSet!=null)
            PiechartforEmp.setData(generatedPieDataSet);
        else{
            //Error Alert
        }
        
        for(PieChart.Data data: PiechartforEmp.getData()){
            //data.getNode().addEventHandler(MouseEvent.ANY, 
            data.getNode().addEventHandler(javafx.scene.input.MouseEvent.ANY, 
                    new EventHandler <javafx.scene.input.MouseEvent>(){
                @Override
                public void handle(javafx.scene.input.MouseEvent event) {
                    Tooltip.install(
                        data.getNode(),
                        new Tooltip(
                            "No of Student: "+String.valueOf(data.getPieValue())
                        )
                    );
                }
            }
            );        
        }
        
    
    }    

    @FXML
    private void Showemergency(ActionEvent event) {
        
        
        
    }

    @FXML
    private void Showspecial(ActionEvent event) {
    }

    private void setupPieChartData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
    
}
