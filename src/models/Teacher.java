package models;
import java.util.Date;

public class Teacher extends Employee {
    private TeachingLevel teachingLevel;
    //Get funkcijas
    public TeachingLevel getTeachingLevel() {
        return teachingLevel;
    }
    //Set funkcijas
    public void setTeachingLevel(TeachingLevel teachingLevel) {
        this.teachingLevel = teachingLevel;
    }
    //Constructor
    Teacher() {
        setName("None");
        setSurname("None");
        setPersonalCode("None");
        //setContractDate();
        setTeachingLevel(teachingLevel);
    }
    Teacher(String name, String surname, String personalCode, Date contractDate, TeachingLevel teachingLevel) {
        setName(name);
        setSurname(surname);
        setPersonalCode(personalCode);
        setContractDate(contractDate);
        setTeachingLevel(teachingLevel);
    }
    //toString funkcija
    @Override
    public String toString() {
        return "Teacher [teachingLevel=" + teachingLevel + "]";
    }
    
}
