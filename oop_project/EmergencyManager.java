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
//public class EmergencyManager extends Employee implements Serializable {
public class EmergencyManager  implements Serializable {

    static void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
  protected int id;
   protected  String name;
    protected final LocalDate Dob;
    protected int salary;
    protected int opid;
    protected  String unitname;
    public EmergencyManager(int id, String name, LocalDate Dob, int salary, int opid,String unitname)
    {
    this.id=id;
    //super(id,opid);
      this.name=name;
     this.Dob=Dob;
    this.salary=salary;
    this.opid=opid;
    this.unitname=unitname;
    
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setOpid(int opid) {
        this.opid = opid;
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

    
    
    
    @Override
    public String toString() {
        return "EmergencyManager{" + "Id=" + id + ", Name=" + name + ",Date of Birth=" + Dob + ", Salary =" + salary +", Optional "+opid +", Unit name="+unitname+'}';
    }
    public void display() {
        System.out.println( "EmergencyManager{" + "Id=" + id + ", Name=" + name + ",Date of Birth=" + Dob + ", Salarye=" + salary +", Optional ID"+opid +'}');
    }
}
