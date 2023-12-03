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
public class CommandoUnitController implements Initializable {

    @FXML
    private TextField InsertID;
    @FXML
    private TextField InsertName;
    @FXML
    private TextField InsertSalary;
    @FXML
    private DatePicker InsertDob;
    @FXML
    private TextField InsertUnitId;
    @FXML
    private TextField InsertUnitNmae;
    @FXML
    private TableView<CommandoUnit> CommandoUnitTable;
    @FXML
    private TableColumn<CommandoUnit, Integer> IDcol;
    @FXML
    private TableColumn<CommandoUnit, String>nameCol;
    @FXML
    private TableColumn<CommandoUnit, Integer> salaryCol;
    @FXML
    private TableColumn<CommandoUnit, LocalDate> DobCol;
    @FXML
    private TableColumn<CommandoUnit, Integer> UnitIdCol;
    @FXML
    private TableColumn<CommandoUnit, String> UnitNameCol;

    /**
     * Initializes the controller class.
     */
    private ObservableList<CommandoUnit> Employee;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
Employee = FXCollections.observableArrayList();
    IDcol.setCellValueFactory(new PropertyValueFactory<CommandoUnit,Integer>("Employee Id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<CommandoUnit,String>("Name"));
        DobCol.setCellValueFactory(new PropertyValueFactory<CommandoUnit,LocalDate>("Date of birth"));
        salaryCol.setCellValueFactory(new PropertyValueFactory<CommandoUnit,Integer>("Salary"));
        UnitIdCol.setCellValueFactory(new PropertyValueFactory<CommandoUnit,Integer>("Optional"));
        UnitNameCol.setCellValueFactory(new PropertyValueFactory<CommandoUnit,String>("Unit name"));
     CommandoUnitTable.setItems(Employee);



    }    

    @FXML
    private void AdddataonClick(ActionEvent event) {
        try {
        FileOutputStream fileOut = new FileOutputStream("Com.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (CommandoUnit emp : Employee) {
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
        FileInputStream fileIn = new FileInputStream("Com.bin");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        
        //Employee.clear(); // 
        
        while (true) {
            try {
               CommandoUnit emp = (CommandoUnit) objectIn.readObject();
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
    private void ResetonClick(ActionEvent event) {
    }

    @FXML
    private void DeleteonClick(ActionEvent event) {
        CommandoUnit emp = CommandoUnitTable.getSelectionModel().getSelectedItem();
        if (emp != null){
            Employee.remove(emp);
         }
        
        
    }

    @FXML
    private void Tableviewonclick(ActionEvent event) {
        int Empid = Integer.parseInt(InsertID.getText());
        String Name = InsertName.getText();
        LocalDate D = InsertDob.getValue();
        int Salary = Integer.parseInt(InsertSalary.getText());
        int  Opid= Integer.parseInt(InsertUnitId.getText());
String Unitname= InsertUnitNmae.getText();
        
  //EmergencyEmployerTable.getItems().add(new EmergencyManager(Empid, Name, dob, Salary ,Opid));      
 CommandoUnit emp=new CommandoUnit(Empid,Name,D,Salary,Opid,Unitname);
    
    Employee.add(emp);
    
    InsertID.clear();
        InsertName.clear();
        InsertDob.setValue(null);
       InsertSalary.clear();
        InsertUnitId.clear();
   InsertUnitNmae.clear(); }

    @FXML
    private void InsertDob(ActionEvent event) {
    }
    
}
