package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Employee extends Person {
    private int employeeId;
    private Date contractDate;
    private String contractNumber;

    private static int employeeCounter = 0;
    /**
     * getEmployeeId() funkcija.
     * @return
     */
    public int getEmployeeId() {
        return employeeId;
    }
    /**
     * getContractDate() funkcija.
     * @return
     */
    public Date getContractDate() {
        return contractDate;
    }
    /**
     * getContractNumber() funkcija.
     * @return
     */
    public String getContractNumber() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return contractNumber = year + "_" + employeeId + "_" + super.getName().substring(0, 1) + "_" + super.getSurname().substring(0, 1);
    }
    /**
     * Tiek noteikts employeeId bez iespējām to mainīt, jo tas ir unikāls.
     */
    public void setEmployeeId() {
        this.employeeId = employeeCounter;
        employeeCounter++;
    }
    /**
     * Ievieto Date objekta contractDate mainīgo ievērojot nosacijumus un pārveidojumus.
     * @param contractDate
     */
    public void setContractDate(Date contractDate) {
        String compareDate = "24/03/2022";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //Locale.getDefault());
        try {
            Date cDate = dateFormat.parse(compareDate);
            if(contractDate != null && contractDate.after(cDate)) {
                this.contractDate = contractDate;
            } else this.contractDate = new Date(0);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }  
    }
    /**
     * Ievieto contractNumber mainīgo vērtību.
     * @param contractNumber
     */
    public void setContractNumber(String contractNumber) {
        if(contractNumber != null && contractNumber.matches("[2][0][2]{2}[_][0-9]+[_][A-ZĒŪĪĀŠĢĶĻŅČŽ][_][A-ZĒŪĪĀŠĢĶĻŅČŽ]")) {
            this.contractNumber = contractNumber;
        } else  this.contractNumber = "NoContractNumber";
    }
    //Constructor
    public Employee(){
        super();
        setEmployeeId();
        setContractDate(new Date(0));
        setContractNumber(getContractNumber());
    }
    public Employee(String name, String surname, String personalCode, Date contractDate) {
        super(name, surname, personalCode);
        setEmployeeId();
        setContractDate(contractDate);
        setContractNumber(getContractNumber());
    }
    //toString funkcija
    public String toString() {
        return employeeId + " " + contractNumber + " " + super.toString() + " "  + contractDate;
    }
}
