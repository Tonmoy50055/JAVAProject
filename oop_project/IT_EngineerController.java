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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class IT_EngineerController implements Initializable {

    @FXML
    private TextField InsertId;
    @FXML
    private TextField InsertNamae;
    @FXML
    private TextField Insertsalary;
    @FXML
    private DatePicker InsertDob;
    @FXML
    private TextField InsertUnitId;
    @FXML
    private TextField InsertUnitName;
    @FXML
    private TableView<IT_team> TableofIT;
    @FXML
    private TableColumn<IT_team, Integer> TableId;
    @FXML
    private TableColumn<IT_team, String> TableName;
    @FXML
    private TableColumn<IT_team, Integer> TableSalary;
    @FXML
    private TableColumn<IT_team, LocalDate> TableDob;
    @FXML
    private TableColumn<IT_team, Integer> TableUnitId;
    @FXML
    private TableColumn<IT_team, String> TableUnitName;

    /**
     * Initializes the controller class.
     */
    private ObservableList<IT_team>Employee;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         
        Employee = FXCollections.observableArrayList();
        TableId.setCellValueFactory(new PropertyValueFactory<IT_team,Integer>("Employee Id"));
        TableName.setCellValueFactory(new PropertyValueFactory<IT_team,String>("Name"));
        TableDob.setCellValueFactory(new PropertyValueFactory<IT_team,LocalDate>("Date of birth"));
        TableSalary.setCellValueFactory(new PropertyValueFactory<IT_team,Integer>("Salary"));
        TableUnitId.setCellValueFactory(new PropertyValueFactory<IT_team,Integer>("Optional"));
        TableUnitName.setCellValueFactory(new PropertyValueFactory<IT_team,String>("Unit name"));
     

  TableofIT.setItems(Employee);
    
        
    }    

    @FXML
    private void ExecuteOperationonClick(ActionEvent event) {
        try {
        FileOutputStream fileOut = new FileOutputStream("IT.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (IT_team emp : Employee) {
            objectOut.writeObject(emp);
        }
        
        objectOut.close();
        fileOut.close();
        
        
    } catch (IOException e) {
        e.printStackTrace();
    }
        
    }

    @FXML
    private void ShowRecordonClick(ActionEvent event) {
        
        
        
        try {
        FileInputStream fileIn = new FileInputStream("Electrical.bin");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        
        //Employee.clear(); // 
        
        while (true) {
            try {
               IT_team emp = (IT_team) objectIn.readObject();
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
    private void ReserDataonClick(ActionEvent event) {
    }

    @FXML
    private void DeleteButtononClick(ActionEvent event) {
        
         IT_team emp =TableofIT.getSelectionModel().getSelectedItem();
        if (emp != null){
            Employee.remove(emp);
         }
    }

    @FXML
    private void tableViewonClick(ActionEvent event) {
        
          int Empid = Integer.parseInt(InsertId.getText());
        String Name = InsertNamae.getText();
        LocalDate D = InsertDob.getValue();
        int Salary = Integer.parseInt(Insertsalary.getText());
        int  Opid= Integer.parseInt(InsertUnitId.getText());
String Unitname= InsertUnitName.getText();
        
  //EmergencyEmployerTable.getItems().add(new EmergencyManager(Empid, Name, dob, Salary ,Opid));      
IT_team emp=new IT_team(Empid,Name,D,Salary,Opid,Unitname);
    
    Employee.add(emp);
    
    InsertId.clear();
        InsertNamae.clear();
        InsertDob.setValue(null);
       Insertsalary.clear();
        InsertUnitId.clear();
   InsertUnitName.clear();
        
        
    
    
        
        
    }
    
}
