/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.roshmelguitutorial;

import java.io.*;

/**
 *
 * @author roshmelcreer
 */
public class Employee implements Serializable {
    
    private String name;
    private String surname;
    private Job job;
    private int staffNumber;

    public Employee(String name, String surname, Job job, int staffNumber) {
        this.name = name;
        this.surname = surname;
        this.job = job;
        this.staffNumber = staffNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public int getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(int staffNumber) {
        this.staffNumber = staffNumber;
    }
    
    
    
}
