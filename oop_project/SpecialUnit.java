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
public class SpecialUnit implements Serializable {
    
    private int id;
     String name;
     LocalDate Dob;
    int salary;
   private int opid;
    
    public SpecialUnit(int id,String name,LocalDate Dob,int salary,int opid)
    {
    this.id=id;
    
        this.name=name;
     this.Dob=Dob;
    this.salary=salary;
    this.opid=opid;
    
    
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
    
    @Override
    public String toString() {
        return "Special Unit:{" + "Id=" + id + ", Name=" + name + ",Date of Birth=" + Dob + ", Salarye=" + salary +", Optional ID"+opid +'}';
    }
    
    
    
}
