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
public class Job implements Serializable {
    
    private double salary;
    private String nameOfJob;

    public Job(double salary, String nameOfJob) {
        this.salary = salary;
        this.nameOfJob = nameOfJob;
    }

    public boolean equals(Job job){
    
       return(this.salary == job.salary && 
              this.nameOfJob.equals(job.nameOfJob));
       
    }
    
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getNameOfJob() {
        return nameOfJob;
    }

    public void setNameOfJob(String nameOfJob) {
        this.nameOfJob = nameOfJob;
    }
    
    
}
