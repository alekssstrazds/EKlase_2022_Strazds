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
        if(teachingLevel != null) {
            this.teachingLevel = teachingLevel;
        } else this.teachingLevel = TeachingLevel.PRESCHOOL;
    }
    //Constructor
    public Teacher() {
        super();
        setContractDate(new Date(0));
        setTeachingLevel(TeachingLevel.PRESCHOOL);
    }
    public Teacher(String name, String surname, String personalCode, Date contractDate, TeachingLevel teachingLevel) {
        super(name, surname, personalCode, contractDate);
        setTeachingLevel(teachingLevel);
    }
    //toString funkcija
    public String toString() {
        return super.toString() + getContractDate() + " " + teachingLevel;
    }
    
}
