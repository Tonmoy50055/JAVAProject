/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package oop_project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SpecialUnitManagerController implements Initializable {

    @FXML
    private TableView<SpecialUnit> SpecialunitTable;
    @FXML
    private TableColumn<SpecialUnit, Integer> IDcol;
    @FXML
    private TableColumn<SpecialUnit,String> nameCol;
    @FXML
    private TableColumn<SpecialUnit, LocalDate> dobCol;
    @FXML
    private TableColumn<SpecialUnit,Integer> salaryCol;
    @FXML
    private TableColumn<SpecialUnit,Integer> opIdCol;
    @FXML
    private TextField InsertId;
    @FXML
    private TextField InsertName;
    @FXML
    private DatePicker InsertDob;
    @FXML
    private TextField InsertSalary;
    @FXML
    private ComboBox<String> SpecialUnitCombobox;
    @FXML
    private TextField InsertOptionalId;
    @FXML
    private Label Namelable;
    @FXML
    private Label IdLable;
 private ObservableList<SpecialUnit> Employee;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    Employee = FXCollections.observableArrayList();
    IDcol.setCellValueFactory(new PropertyValueFactory<SpecialUnit,Integer>("Employee Id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<SpecialUnit,String>("Name"));
        dobCol.setCellValueFactory(new PropertyValueFactory<SpecialUnit,LocalDate>("Date of birth"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<SpecialUnit,Integer>("Salary"));
        opIdCol.setCellValueFactory(new PropertyValueFactory<SpecialUnit,Integer>("Optional"));
       //ComboforEmergency.getItems().add("Medical team");
        SpecialUnitCombobox.getItems().addAll(
                                           "Commando unit",
                                           "Dog unit",
                                           "Special police unit"
                                                );
    
   SpecialunitTable.setItems(Employee);
    
    }    

    @FXML
    private void UnitByClick(ActionEvent event) throws IOException {
        
        if(SpecialUnitCombobox.getValue().equals("Commando unit"))
        {
        
        Parent root=FXMLLoader.load(getClass().getResource("Commando Unit.fxml"));
        Scene newScene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.show();
         
       }
       else if(SpecialUnitCombobox.getValue().equals("Dog unit")){
       
       
       
       Parent root=FXMLLoader.load(getClass().getResource("Dog Unit.fxml"));
        Scene newScene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.show();
       
       } 
        else if(SpecialUnitCombobox.getValue().equals("Special police unit")){
       
       
       
       Parent root=FXMLLoader.load(getClass().getResource("Special Police.fxml"));
        Scene newScene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.show();
       
       } 
        
        
        
        
    }

    @FXML
    private void ExecuteOperationonClick(ActionEvent event) {
   
      try {
        FileOutputStream fileOut = new FileOutputStream("special.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (SpecialUnit emp : Employee) {
            objectOut.writeObject(emp);
        }
        
        objectOut.close();
        fileOut.close();
        
        
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    
    }


    @FXML
    private void ShowDataonClick(ActionEvent event) {
        
        try {
        FileInputStream fileIn = new FileInputStream("stc.bin");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        
        //Employee.clear(); // 
        
        while (true) {
            try {
               SpecialUnit emp = (SpecialUnit) objectIn.readObject();
                Employee.add(emp);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break; // 
            }
        }
        
        objectIn.close();
        fileIn.close();
        
        
    } catch (IOException e) {
        e.printStackTrace();
    }
        
             
        
    }

    @FXML
    private void Resetonclick(ActionEvent event) {
    }

    @FXML
    private void DeleteonClick(ActionEvent event) {
     SpecialUnit emp = SpecialunitTable.getSelectionModel().getSelectedItem();
        if (emp != null){
            Employee.remove(emp);
         }
    }
    @FXML
    private void SwitchtoGraphonClick(ActionEvent event) {
        
        try{  Parent root=FXMLLoader.load(getClass().getResource("GraphforEmergency.fxml"));
        Scene newScene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.show();
      }
      catch (IOException ex) {
            Logger.getLogger(CommonDashBoardSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void AircraftonClick(ActionEvent event) {
        
        
        try{  Parent root=FXMLLoader.load(getClass().getResource("AirSection.fxml"));
        Scene newScene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.show();
      }
      catch (IOException ex) {
            Logger.getLogger(CommonDashBoardSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void ShowTableonclick(ActionEvent event) {
        
        
        int Empid = Integer.parseInt(InsertId.getText());
        String Name = InsertName.getText();
        LocalDate D = InsertDob.getValue();
        int Salary = Integer.parseInt(InsertSalary.getText());
        int  Opid= Integer.parseInt(InsertOptionalId.getText());

        
  //EmergencyEmployerTable.getItems().add(new EmergencyManager(Empid, Name, dob, Salary ,Opid));      
 SpecialUnit emp=new SpecialUnit(Empid,Name,D,Salary,Opid);
    
    Employee.add(emp);
    
    InsertId.clear();
        InsertName.clear();
        InsertDob.setValue(null);
       InsertSalary.clear();
        InsertOptionalId.clear();
        
    }
    
}
