/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop_project;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class IT_team  implements  Serializable {
    private int id;
     private String name;
   private LocalDate Dob;
    private int salary;
     private int opid;
   private String unitName;
    
    public IT_team(int id,String name,LocalDate Dob,int salary,int opid,String unitName)
    {
    this.id=id;
    
        
        this.name=name;
     this.Dob=Dob;
    this.salary=salary;
    this.opid=opid;
    this.unitName=unitName;
    
    
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return Dob;
    }

    public int getSalary() {
        return salary;
    }

    public int getOpid() {
        return opid;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate Dob) {
        this.Dob = Dob;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setOpid(int opid) {
        this.opid = opid;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
   
    
    
    @Override
    public String toString() {
        return "IT_team:{" + "Id=" + id + ", Name=" + name + ",Date of Birth=" + Dob + ", Salarye=" + salary +", Optional ID"+opid +",Unit name"+unitName+'}';
    }
}
