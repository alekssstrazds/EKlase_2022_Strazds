package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Employee extends Person {
    //Mainīgie
    private int employeeId;
    private Date contractDate;
    private String contractNumber;

    private static int employeeCounter = 0;

    //Get funkcijas
    public int getEmployeeId() {
        return employeeId;
    }
    public Date getContractDate() {
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = dateformat.parse("24/03/2022");
            if(contractDate.after(date)) {
                return contractDate;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    } 
    public String getContractNumber() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(contractDate);
        int year = calendar.get(Calendar.YEAR);
        return year + "_" + employeeId + "_" + super.getName().substring(0, 1) + "_" + super.getSurname().substring(0, 1);
    }
    //Set funkcijas
    public void setEmployeeId() {
        this.employeeId = employeeCounter;
        employeeCounter++;
    }
    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
    }
    public void setContractNumber(String contractNumber) {
        if(contractNumber != null && contractNumber.matches("[2][0][2]{2}[_][0-9]+[_][A-ZĒŪĪĀŠĢĶĻŅČŽ][_][A-ZĒŪĪĀŠĢĶĻŅČŽ]")) {
            this.contractNumber = contractNumber;
        } else  this.contractNumber = "notknown";
    }
    //Constructor
    public Employee() {
        super();
        setContractDate(contractDate);
    }
    public Employee(String name, String surname, String personalCode, Date contractDate) {
        super(name, surname, personalCode);
        setContractDate(contractDate);
    }
    //toString funkcija
    public String toString() {
        return super.toString() + " "  + contractDate + " " + contractNumber + " " + employeeId ;
    }   
}
