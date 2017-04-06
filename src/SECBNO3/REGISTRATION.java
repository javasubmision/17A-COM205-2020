/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SECBNO3;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author evawero
 */
public class REGISTRATION {
    static String name, address, job, annualSalary;
    
 public static String getname() {
        return name;  }
 public static void setname(String name) {
        REGISTRATION.name = name;}
 public static String getaddress() {
        return address; }
 public static void setaddress(String address) {
        REGISTRATION.address = address;}
 public static String getjob() {
        return job;}
  public static void setjob(String job) {
        REGISTRATION.job = job;}
  public static String getnnualSalary(){
      return annualSalary;}
  public static void setannualSalary(String annualSalary){
      REGISTRATION.annualSalary = annualSalary;
  }
  public static void writeFile(String content)
    {
        try {
             BufferedWriter myBF; 
            myBF = new BufferedWriter(new FileWriter("REGISTRATION.txt", true));
            myBF.newLine();
            myBF.write(content);
            myBF.close();
        } catch (IOException ex) {
            Logger.getLogger(REGISTRATION.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
  public static void SaveDB(String inputName, String inputAddress, String inputJob, String inputAnnualSalary) {
        try {
            Connection myCon;
            Statement myST;
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentprofile","root","");
            myST = myCon.createStatement();
            
            myST.executeUpdate("insert into student(Student_Name,address,job, annualSalary) values ('"+inputName+"', '"+inputAddress+"','"+inputJob+"', '"+inputAnnualSalary+"')");
        } catch (SQLException ex) {
            Logger.getLogger(REGISTRATION.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
        
}
