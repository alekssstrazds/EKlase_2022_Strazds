package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

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
        return contractDate;
    } 
    public String getContractNumber() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return year + "_" + employeeId + "_" + super.getName().substring(0, 1) + "_" + super.getSurname().substring(0, 1);
    }
    //Set funkcijas
    public void setEmployeeId() {
        this.employeeId = employeeCounter;
        employeeCounter++;
    }
    //TODO neatgriež default date
    public void setContractDate(Date contractDate) {
        String compareDate = "24/03/2022";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date cDate = dateFormat.parse(compareDate);
            if(contractDate != null && contractDate.after(cDate)) {
                this.contractDate = contractDate;
            } else contractDate = new Date(0);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }  
    }
    public void setContractNumber(String contractNumber) {
        if(contractNumber != null && contractNumber.matches("[2][0][2]{2}[_][0-9]+[_][A-ZĒŪĪĀŠĢĶĻŅČŽ][_][A-ZĒŪĪĀŠĢĶĻŅČŽ]")) {
            this.contractNumber = contractNumber;
        } else  this.contractNumber = "No ContractNumber";
    }
    //Constructor
    //TODO konstruktors atgriežas hautiski
    public Employee(){
        super();
        setEmployeeId();
        setContractDate(new Date(0));
    }
    public Employee(String name, String surname, String personalCode, Date contractDate) {
        super(name, surname, personalCode);
        setEmployeeId();
        setContractDate(contractDate);
        
    }
    //toString funkcija
    public String toString() {
        return super.toString() + " "  + contractDate + " " + contractNumber + " " + employeeId ;
    }
}
