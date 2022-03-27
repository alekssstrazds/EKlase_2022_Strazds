package models;

import java.sql.Date;
import java.util.PriorityQueue;

public class SpeachTherapist extends Employee implements Comparable<Child>{
    private String workingMethods;
    private static PriorityQueue<Child> allChildrenAtSpeachLessons = new PriorityQueue<>(5);
    //Get funkcijas
    public PriorityQueue<Child> getAllChildrenAtSpeachLessons() {
        return new PriorityQueue<>(allChildrenAtSpeachLessons);
    }
    public String getWorkingMethods() {
        return workingMethods;
    }
    //Set funkcijas
    public void setAllChildrenAtSpeachLessons(PriorityQueue<Child> allChildrenAtSpeachLessons) {
        //getPriorityForSpeachLessons()
        if(allChildrenAtSpeachLessons != null) {
            SpeachTherapist.allChildrenAtSpeachLessons = allChildrenAtSpeachLessons;
        } else SpeachTherapist.allChildrenAtSpeachLessons = new PriorityQueue<>(5);
    }
    public void setWorkingMethods(String workingMethods) {
        if(workingMethods != null && workingMethods.matches("[A-ZĒŪĪĀŠĢĶĻŅČŽa-zēūīļķģšāžčņ]+\s?([A-ZĒŪĪĀŠĢĶĻŅČŽa-zēūīļķģšāžčņ]+)?")) {
            this.workingMethods = workingMethods;
        } else workingMethods = "Unknown";  
    }
    //Constructor
    public SpeachTherapist() {
        super();
        setWorkingMethods("None");
    }
    public SpeachTherapist(String name, String surname, String personalCode, Date contractDate, String workingMethods) {
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
    @Override
    public int compareTo(Child o) {
        for(Child child : allChildrenAtSpeachLessons) {
            if(child.getPriorityForSpeachLessons() == o.getPriorityForSpeachLessons()) {
                return 1;
            }
            else if(child.getPriorityForSpeachLessons() < o.getPriorityForSpeachLessons()) {
                return -1;
            }
        }
        return 0;
    }  
}
