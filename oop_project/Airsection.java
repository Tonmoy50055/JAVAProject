/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop_project;

/**
 *
 * @author HP
 */
public class Airsection {
    private int aircraftid;
    private int pilotid;
    private String pilotname;
    
    public Airsection(int aircraftid,int pilotid,String pilotname){
    this.aircraftid=aircraftid;
    this.pilotid=pilotid;
    this.pilotname=pilotname;
    
    
    
    
    }
    public void setAircraftId(int aircraftid){
    this.aircraftid=aircraftid;
    }
     public int getAircraftId(){
    return aircraftid;
     
    }
     public void setpilotId(int pilotid){
    this.pilotid=pilotid;
    }
     public int getpilotId(){
    return pilotid;
     
    }
     public void setPilotName(String pilotname){
    this.pilotname=pilotname;
    }
     public String getPilotName(){
    return pilotname;
     
    }
     @Override
      public String toString() {
        return "Aircraft:{" + "Id=" + aircraftid + ", Pilot id= "+pilotid+", Pilot name="+pilotname +'}';
    }
     
     
}