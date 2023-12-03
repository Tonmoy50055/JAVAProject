/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop_project;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 *
 * @author HP
 */
public class GraphicalratioforEmergency extends EmergencyManager implements Serializable {
    
     public static ObservableList<PieChart.Data> piechartforEmp(){
     
     ObservableList<PieChart.Data> pieDataSet
                = FXCollections.observableArrayList();
     int electrical=0;
     int IT=0;
     int Medical=0;
     ObjectInputStream ois = null;
     
     EmergencyManager emergencyteam=null;
     
     try{
     
      ois = new ObjectInputStream(
                new FileInputStream( "Emergencyemp.bin")
                );
            while(true){
                emergencyteam= (EmergencyManager)ois.readObject();
                if(emergencyteam.getUnitname().equals("Electrical"))
                    electrical++;
                else if(emergencyteam.getUnitname().equals("IT"))
                    IT++;
                else if(emergencyteam.getUnitname().equals("Medical"))
                  Medical++;
                
            } //while
        }   //try
        catch(Exception e){
            if(ois!=null)
                try {
                    ois.close();
            } catch (IOException ex) {
                    //...            
            }                   
        } //end of catch
        finally{
            pieDataSet.add(
                    new PieChart.Data("Electrical",electrical)
            );
            pieDataSet.add(
                    new PieChart.Data("IT",IT)
            );
            pieDataSet.add(
                    new PieChart.Data("Medical",Medical)
            );
            

            return pieDataSet;
     
     
     }
     }

    public GraphicalratioforEmergency(int id, String name, LocalDate Dob, int salary, int opid, String unitname) {
        super(id, name, Dob, salary, opid, unitname);
    }
    
    
    
}
