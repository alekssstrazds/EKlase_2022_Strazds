package models;

import java.sql.Date;
import java.util.PriorityQueue;

public class SpeachTherapist extends Employee {
    private String workingMethods;
    private static PriorityQueue<Child> allChildrenAtSpeachLessons = new PriorityQueue<>();
    //Get funkcijas
    public PriorityQueue<Child> getAllChildrenAtSpeachLessons() {
        return allChildrenAtSpeachLessons;
    }
    public String getWorkingMethods() {
        return workingMethods;
    }

    //Set funkcijas
    public void setAllChildrenAtSpeachLessons(PriorityQueue<Child> allChildrenAtSpeachLessons) {
        SpeachTherapist.allChildrenAtSpeachLessons = allChildrenAtSpeachLessons;
    }
    public void setWorkingMethods(String workingMethods) {
        this.workingMethods = workingMethods;
    }
    //Constructor
    SpeachTherapist() {
        super();
        setWorkingMethods("None");
    }
    SpeachTherapist(String name, String surname, String personalCode, Date contractDate, String workingMethods) {
        super(name, surname, personalCode, contractDate);
        setWorkingMethods(workingMethods);
    }
    //toString funkcija
    public String toString() {
        return super.toString() + " " + workingMethods;
    }
    //addChildByPriority funkcija
    public int addChildByPriority(Child child) {
        return child.getPriorityForSpeachLessons();
    }
}
