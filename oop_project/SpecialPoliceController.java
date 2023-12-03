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
public class SpecialPoliceController implements Initializable {

    @FXML
    private TextField InsertName;
    @FXML
    private TextField InsertId;
    @FXML
    private TextField InsertSalary;
    @FXML
    private DatePicker InsertDob;
    @FXML
    private TextField InsertUnitID;
    @FXML
    private TextField InsertUnitName;
    @FXML
    private TableView<SpecialPolice> SpecialPoliceTable;
    @FXML
    private TableColumn<SpecialPolice, Integer> IDCol;
    @FXML
    private TableColumn<SpecialPolice, String> NameCol;
    @FXML
    private TableColumn<SpecialPolice, Integer> SalaryCol;
    @FXML
    private TableColumn<SpecialPolice, LocalDate> DobCOl;
    @FXML
    private TableColumn<SpecialPolice, Integer> UnitIdCol;
    @FXML
    private TableColumn<SpecialPolice, String> UnitCol;

    /**
     * Initializes the controller class.
     */
    private ObservableList<SpecialPolice>Employee;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Employee = FXCollections.observableArrayList();
        IDCol.setCellValueFactory(new PropertyValueFactory<SpecialPolice,Integer>("Employee Id"));
        NameCol.setCellValueFactory(new PropertyValueFactory<SpecialPolice,String>("Name"));
        DobCOl.setCellValueFactory(new PropertyValueFactory<SpecialPolice,LocalDate>("Date of birth"));
        SalaryCol.setCellValueFactory(new PropertyValueFactory<SpecialPolice,Integer>("Salary"));
        UnitIdCol.setCellValueFactory(new PropertyValueFactory<SpecialPolice,Integer>("Optional"));
        UnitCol.setCellValueFactory(new PropertyValueFactory<SpecialPolice,String>("Unit name"));
     

SpecialPoliceTable.setItems(Employee);
    
         
       
    }    

    @FXML
    private void AddDataonClick(ActionEvent event) {
    
    
    
     try {
        FileOutputStream fileOut = new FileOutputStream("Special.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (SpecialPolice emp : Employee) {
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
        FileInputStream fileIn = new FileInputStream("SpecialPolice.bin");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        
        //Employee.clear(); // 
        
        while (true) {
            try {
               SpecialPolice emp = (SpecialPolice) objectIn.readObject();
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
    private void ResetDataonClick(ActionEvent event) {
    }

    @FXML
    private void DeleteonCLick(ActionEvent event) {
        
       SpecialPolice emp =SpecialPoliceTable.getSelectionModel().getSelectedItem();
        if (emp != null){
            Employee.remove(emp);
         }
    }

    @FXML
    private void showtableonclick(ActionEvent event) {
        
        
        int Empid = Integer.parseInt(InsertId.getText());
        String Name = InsertName.getText();
        LocalDate D = InsertDob.getValue();
        int Salary = Integer.parseInt(InsertSalary.getText());
        int  Opid= Integer.parseInt(InsertUnitID.getText());
String Unitname= InsertUnitName.getText();
        
  //EmergencyEmployerTable.getItems().add(new EmergencyManager(Empid, Name, dob, Salary ,Opid));      
SpecialPolice emp=new SpecialPolice(Empid,Name,D,Salary,Opid,Unitname);
    
    Employee.add(emp);
    
    InsertId.clear();
        InsertName.clear();
        InsertDob.setValue(null);
      InsertSalary.clear();
        InsertUnitID.clear();
   InsertUnitName.clear();
        
        
        
        
        
        
    }
    
}
