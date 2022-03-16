package models;
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
        return contractDate;
    }
    public String getContractNumber() {
        return contractNumber;
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
        this.contractNumber = contractNumber;
    }
    //Constructor
    Employee() {
        setName("None");
        setSurname("None");
        setPersonalCode("None");
        setContractDate(contractDate);
    }
    Employee(String name, String surname, String personalCode, Date contractDate) {
        setName(name);
        setSurname(surname);
        setPersonalCode(personalCode);
        setContractDate(contractDate);
    }
    //toString funkcija
    @Override
    public String toString() {
        return "Employee [contractDate=" + contractDate + ", contractNumber=" + contractNumber + ", employeeId=" + employeeId + "]";
    }   
}
