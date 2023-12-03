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
public class Electrical_EngineerController implements Initializable {

    @FXML
    private TextField InsertName;
    @FXML
    private TextField InsertUnitId;
    @FXML
    private TextField InsertId;
    @FXML
    private TextField InsertSalary;
    @FXML
    private DatePicker InsertDob;
    @FXML
    private TableView<Electrical_team> ElectricalEmployerTable;
    @FXML
    private TableColumn<Electrical_team, Integer> Idcol;
    @FXML
    private TableColumn<Electrical_team, String> nameCol;
    @FXML
    private TableColumn<Electrical_team, Integer> salaryCol;
    @FXML
    private TableColumn<Electrical_team, LocalDate> dobCol;
    @FXML
    private TableColumn<Electrical_team, Integer> unitIdxCol;
    @FXML
    private TableColumn<Electrical_team, String> UnitnameCol;

    /**
     * Initializes the controller class.
     */
    private ObservableList<Electrical_team>Employee;
    @FXML
    private TextField InsertUnitName;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        Employee = FXCollections.observableArrayList();
        Idcol.setCellValueFactory(new PropertyValueFactory<Electrical_team,Integer>("Employee Id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Electrical_team,String>("Name"));
        dobCol.setCellValueFactory(new PropertyValueFactory<Electrical_team,LocalDate>("Date of birth"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<Electrical_team,Integer>("Salary"));
        unitIdxCol.setCellValueFactory(new PropertyValueFactory<Electrical_team,Integer>("Optional"));
        UnitnameCol.setCellValueFactory(new PropertyValueFactory<Electrical_team,String>("Unit name"));
     

  ElectricalEmployerTable.setItems(Employee);
    
        
        
        
    }    

    @FXML
    private void AddDataonClick(ActionEvent event) {
         try {
        FileOutputStream fileOut = new FileOutputStream("Electrical.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (Electrical_team emp : Employee) {
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
               Electrical_team emp = (Electrical_team) objectIn.readObject();
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
    private void DeleteRecordonClick(ActionEvent event) {
        
        
         Electrical_team emp = ElectricalEmployerTable.getSelectionModel().getSelectedItem();
        if (emp != null){
            Employee.remove(emp);
         }
    }

    @FXML
    private void ResetRecordonclick(ActionEvent event) {
    }

    @FXML
    private void Tableonclick(ActionEvent event) {
        
         int Empid = Integer.parseInt(InsertId.getText());
        String Name = InsertName.getText();
        LocalDate D = InsertDob.getValue();
        int Salary = Integer.parseInt(InsertSalary.getText());
        int  Opid= Integer.parseInt(InsertUnitId.getText());
String Unitname= InsertUnitName.getText();
        
  //EmergencyEmployerTable.getItems().add(new EmergencyManager(Empid, Name, dob, Salary ,Opid));      
 Electrical_team emp=new Electrical_team(Empid,Name,D,Salary,Opid,Unitname);
    
    Employee.add(emp);
    
    InsertId.clear();
        InsertName.clear();
        InsertDob.setValue(null);
       InsertSalary.clear();
        InsertUnitId.clear();
   InsertUnitName.clear();
        
        
    }
    
}
