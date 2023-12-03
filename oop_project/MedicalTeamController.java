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
public class MedicalTeamController implements Initializable {

    @FXML
    private TableView<MedicalTeam> TableforMedical;
    @FXML
    private TableColumn<MedicalTeam, Integer> EmpId;
    @FXML
    private TableColumn<MedicalTeam, String> EmpName;
    @FXML
    private TableColumn<MedicalTeam, LocalDate> EmpDob;
    @FXML
    private TableColumn<MedicalTeam, Integer> EmpSalary;
    @FXML
    private TableColumn<MedicalTeam, Integer> EmpunitId;
    @FXML
    private TableColumn<MedicalTeam, String> EmpUnitNme;
    @FXML
    private TextField InsertId;
    @FXML
    private TextField InsertNamae;
    @FXML
    private TextField InsertSalary;
    @FXML
    private TextField InsertUnitId;
    @FXML
    private TextField InsertUnitName;
    @FXML
    private DatePicker InsertDathofbirth;

    /**
     * Initializes the controller class.
     */
    private ObservableList<MedicalTeam>Employee;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   Employee = FXCollections.observableArrayList();
        EmpId.setCellValueFactory(new PropertyValueFactory<MedicalTeam,Integer>("Employee Id"));
        EmpName.setCellValueFactory(new PropertyValueFactory<MedicalTeam,String>("Name"));
        EmpDob.setCellValueFactory(new PropertyValueFactory<MedicalTeam,LocalDate>("Date of birth"));
        EmpSalary.setCellValueFactory(new PropertyValueFactory<MedicalTeam,Integer>("Salary"));
        EmpunitId.setCellValueFactory(new PropertyValueFactory<MedicalTeam,Integer>("Optional"));
        EmpUnitNme.setCellValueFactory(new PropertyValueFactory<MedicalTeam,String>("Unit name"));
     

  TableforMedical.setItems(Employee);
    
    
    }    

    @FXML
    private void ExecuteOperationonClick(ActionEvent event) {
        try {
        FileOutputStream fileOut = new FileOutputStream("IT.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (MedicalTeam emp : Employee) {
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
               MedicalTeam emp = (MedicalTeam) objectIn.readObject();
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
    private void TableonClick(ActionEvent event) {
         int Empid = Integer.parseInt(InsertId.getText());
        String Name = InsertNamae.getText();
        LocalDate D = InsertDathofbirth.getValue();
        int Salary = Integer.parseInt(InsertSalary.getText());
        int  Opid= Integer.parseInt(InsertUnitId.getText());
String Unitname= InsertUnitName.getText();
        
  //EmergencyEmployerTable.getItems().add(new EmergencyManager(Empid, Name, dob, Salary ,Opid));      
MedicalTeam emp=new MedicalTeam(Empid,Name,D,Salary,Opid,Unitname);
    
    Employee.add(emp);
    
    InsertId.clear();
        InsertNamae.clear();
        InsertDathofbirth.setValue(null);
      InsertSalary.clear();
        InsertUnitId.clear();
   InsertUnitName.clear();
        
        
    
    
        
        
    }

    @FXML
    private void deletonClick(ActionEvent event) {
        
         MedicalTeam emp =TableforMedical.getSelectionModel().getSelectedItem();
        if (emp != null){
            Employee.remove(emp);
         }
        
        
    }
    
        
        
    
    
}
