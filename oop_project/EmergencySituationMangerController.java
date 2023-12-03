/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
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
 *
 * @author HP
 */
public class EmergencySituationMangerController implements Initializable {
    
    private Label label;
    @FXML
    private ComboBox<String> ComboforEmergency;
    @FXML
    private TextField InsertId;
    @FXML
    private TextField InsertName;
    @FXML
    private DatePicker InsertDob;
    @FXML
    private TextField InsertSalary;
    @FXML
    private TextField InsertFieldId;
    @FXML
    private TableView<EmergencyManager> EmergencyEmployerTable;
    @FXML
    private TableColumn<EmergencyManager,Integer > EmpId;
    @FXML
    private TableColumn<EmergencyManager, String> EmpName;
    @FXML
    private TableColumn<EmergencyManager, LocalDate> EmpDob;
    @FXML
    private TableColumn<EmergencyManager, Integer> EmpSalary;
    @FXML
    private TableColumn<EmergencyManager,Integer> EmergencyEmployerId;
    @FXML
    private TableColumn<EmergencyManager, String> Unitnamecol;
    
    @FXML
    private Label IdLabel;
    @FXML
    private Label NameLable;
    private ObservableList<EmergencyManager> Employee;
    @FXML
    private TextField Insertunitname;
    
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       Employee = FXCollections.observableArrayList();
        
        EmpId.setCellValueFactory(new PropertyValueFactory<EmergencyManager, Integer>("Employee Id"));
        EmpName.setCellValueFactory(new PropertyValueFactory<EmergencyManager, String>("Name"));
        EmpDob.setCellValueFactory(new PropertyValueFactory<EmergencyManager, LocalDate>("Date of birth"));
        EmpSalary.setCellValueFactory(new PropertyValueFactory<EmergencyManager, Integer>("Salary"));
        EmergencyEmployerId.setCellValueFactory(new PropertyValueFactory<EmergencyManager, Integer>("Optional"));
        Unitnamecol.setCellValueFactory(new PropertyValueFactory<EmergencyManager, String>("Unit name"));
       //ComboforEmergency.getItems().add("Medical team");
        ComboforEmergency.getItems().addAll(
                                           "Medical team",
                                           "IT team",
                                           "Electrical team"
                                                );
        
        
        
        
    EmergencyEmployerTable.setItems(Employee);
                
                                               
        
    }    

    @FXML
    private void TeamsButtononclick(ActionEvent event) throws IOException {
        if(ComboforEmergency.getValue().equals("Medical team"))
        {
        
        Parent root=FXMLLoader.load(getClass().getResource("MedicalTeam.fxml"));
        Scene newScene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.show();
         
       }
       else if(ComboforEmergency.getValue().equals("IT team")){
       
       
       
       Parent root=FXMLLoader.load(getClass().getResource("IT_Engineer.fxml"));
        Scene newScene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.show();
       
       } 
        else if(ComboforEmergency.getValue().equals("Electrical team")){
       
       
       
       Parent root=FXMLLoader.load(getClass().getResource("Electrical_Engineer.fxml"));
        Scene newScene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.show();
       
       } 
        
        
        
    }

    @FXML
    private void Dob(ActionEvent event) {
    }

    @FXML
    private void ExecuteOperationonClick(ActionEvent event)  {
    
         try {
        FileOutputStream fileOut = new FileOutputStream("stc.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (EmergencyManager emp : Employee) {
            objectOut.writeObject(emp);
        }
        
        objectOut.close();
        fileOut.close();
        
        
    } catch (IOException e) {
        e.printStackTrace();
    }
        
        
    }

    @FXML
    private void ResetOperationonclick(ActionEvent event) {
        
    }
    


    @FXML
    private void ShowEmployDataonclick(ActionEvent event) {
     try {
        FileInputStream fileIn = new FileInputStream("stc.bin");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        
        //Employee.clear(); // 
        
        while (true) {
            try {
                EmergencyManager emp = (EmergencyManager) objectIn.readObject();
                Employee.add(emp);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                break; // 
            }
        }
        
        objectIn.close();
        fileIn.close();
        
        System.out.println("Stock data loaded to stc.bin");
    } catch (IOException e) {
        e.printStackTrace();
    }
        
             
    }
    
    @FXML
    private void SwitchtoAircraftdataonClick(ActionEvent event) {
      
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
    private void DeleteButtononClick(ActionEvent event) {
    EmergencyManager emp = EmergencyEmployerTable.getSelectionModel().getSelectedItem();
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
    private void Exitonclick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void idTextonLCick(ActionEvent event) {
        
        InsertId.setText(null);
        
    }

    @FXML
    private void nameTextonClick(ActionEvent event) {
    
    InsertName.setText(null);
    
    
    }

    @FXML
    private void salaryTextonClick(ActionEvent event) {
     InsertSalary.setText(null);
    
    }

    @FXML
    private void opIdonClick(ActionEvent event) {
   InsertFieldId.setText(null);
    
    }

    @FXML
    private void ExecuteTableonClick(ActionEvent event) {
          int Empid = Integer.parseInt(InsertId.getText());
        String Name = InsertName.getText();
        LocalDate Dob = InsertDob.getValue();
        int Salary = Integer.parseInt(InsertSalary.getText());
        int  Opid= Integer.parseInt(InsertFieldId.getText());
String unitname=Insertunitname.getText();
        
  //EmergencyEmployerTable.getItems().add(new EmergencyManager(Empid, Name, dob, Salary ,Opid));      
 EmergencyManager emp=new EmergencyManager(Empid,Name,Dob,Salary,Opid, unitname);
    
    Employee.add(emp);
    
    InsertId.clear();
        InsertName.clear();
        InsertDob.setValue(null);
       InsertSalary.clear();
        InsertFieldId.clear();
        Insertunitname.clear();
    
    } 
    
    
    
}
