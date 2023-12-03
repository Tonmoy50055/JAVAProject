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
public class DogUnitController implements Initializable {

    @FXML
    private TableView<DogUnit> DogUnitTable;
    @FXML
    private TableColumn<DogUnit, Integer> Idcol;
    @FXML
    private TableColumn<DogUnit, String> Namecol;
    @FXML
    private TableColumn<DogUnit, Integer> Salarycol;
    @FXML
    private TableColumn<DogUnit, LocalDate> Dobcol;
    @FXML
    private TableColumn<DogUnit, Integer> UnitIdcol;
    @FXML
    private TableColumn<DogUnit, String> UnitNamecol;
    @FXML
    private TextField Insertname;
    @FXML
    private TextField Insertsalary;
    @FXML
    private DatePicker Insertdob;
    @FXML
    private TextField InsertunitId;
    @FXML
    private TextField InsertUnitName;
    @FXML
    private TextField InsertID;

    /**
     * Initializes the controller class.
     */
    private ObservableList<DogUnit> Employee;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
   
        Employee = FXCollections.observableArrayList();
        Idcol.setCellValueFactory(new PropertyValueFactory<DogUnit,Integer>("Employee Id"));
        Namecol.setCellValueFactory(new PropertyValueFactory<DogUnit,String>("Name"));
        Dobcol.setCellValueFactory(new PropertyValueFactory<DogUnit,LocalDate>("Date of birth"));
        Salarycol.setCellValueFactory(new PropertyValueFactory<DogUnit,Integer>("Salary"));
        UnitIdcol.setCellValueFactory(new PropertyValueFactory<DogUnit,Integer>("Optional"));
        UnitNamecol.setCellValueFactory(new PropertyValueFactory<DogUnit,String>("Unit name"));
     

  DogUnitTable.setItems(Employee);
    
    }    

    @FXML
    private void addDataonClick(ActionEvent event) {
        
        try {
        FileOutputStream fileOut = new FileOutputStream("Dog.bin");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        
        
        for (DogUnit emp : Employee) {
            objectOut.writeObject(emp);
        }
        
        objectOut.close();
        fileOut.close();
        
        
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    @FXML
    private void showDataonClick(ActionEvent event) {
        
        try {
        FileInputStream fileIn = new FileInputStream("Dog.bin");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        
        //Employee.clear(); // 
        
        while (true) {
            try {
               DogUnit emp = (DogUnit) objectIn.readObject();
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
    private void resetDataonClick(ActionEvent event) {
    }

    @FXML
    private void deleteButtononClick(ActionEvent event) {
        
         DogUnit emp = DogUnitTable.getSelectionModel().getSelectedItem();
        if (emp != null){
            Employee.remove(emp);
         }
    }

    @FXML
    private void TableViewClick(ActionEvent event) {
   
     int Empid = Integer.parseInt(InsertID.getText());
        String Name = Insertname.getText();
        LocalDate D = Insertdob.getValue();
        int Salary = Integer.parseInt(Insertsalary.getText());
        int  Opid= Integer.parseInt(InsertunitId.getText());
String Unitname= InsertUnitName.getText();
        
  //EmergencyEmployerTable.getItems().add(new EmergencyManager(Empid, Name, dob, Salary ,Opid));      
 DogUnit emp=new DogUnit(Empid,Name,D,Salary,Opid,Unitname);
    
    Employee.add(emp);
    
    InsertID.clear();
        Insertname.clear();
        Insertdob.setValue(null);
       Insertsalary.clear();
        InsertunitId.clear();
   InsertUnitName.clear();
    }
    
}
