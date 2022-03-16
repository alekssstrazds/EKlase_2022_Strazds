package models;

public class Employee extends Person{
    private int employeeId;
    //private Date contractDate;
    private String contractNumber;

    private static int employeeCounter = 0;

    
    public void setId() 
    {
        this.employeeId = employeeCounter;
        employeeCounter++;
    }
}
