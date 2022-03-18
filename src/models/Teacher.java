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
        super();
        setContractDate(new Date());
        setTeachingLevel(TeachingLevel.PRESCHOOL);
    }
    Teacher(String name, String surname, String personalCode, Date contractDate, TeachingLevel teachingLevel) {
        super(name, surname, personalCode, contractDate);
        setTeachingLevel(teachingLevel);
    }
    //toString funkcija
    public String toString() {
        return super.toString() + getContractDate() + " " + teachingLevel;
    }
    
}
