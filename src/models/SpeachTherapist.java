package models;

import java.sql.Date;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SpeachTherapist extends Employee implements Comparator<Child>{
    private String workingMethods;
    private PriorityQueue<Child> allChildrenAtSpeachLessons = new PriorityQueue<>();
    
    //Get funkcijas
    public PriorityQueue<Child> getAllChildrenAtSpeachLessons() {
        return allChildrenAtSpeachLessons;
    }
    public String getWorkingMethods() {
        return workingMethods;
    }
    //Set funkcijas
    public void setAllChildrenAtSpeachLessons(PriorityQueue<Child> allChildrenAtSpeachLessons) {
        if(allChildrenAtSpeachLessons != null) {
            this.allChildrenAtSpeachLessons = allChildrenAtSpeachLessons;
        } else this.allChildrenAtSpeachLessons = new PriorityQueue<>(5);
    }
    public void setWorkingMethods(String workingMethods) {
        if(workingMethods != null && workingMethods.matches("[A-ZĒŪĪĀŠĢĶĻŅČŽa-zēūīļķģšāžčņ]+\s?([A-ZĒŪĪĀŠĢĶĻŅČŽa-zēūīļķģšāžčņ]+)?")) {
            this.workingMethods = workingMethods;
        } else workingMethods = "No WorkingMethods";  
    }
    //Constructor
    public SpeachTherapist() {
        super();
        setWorkingMethods(" ");
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
        if(child.getPriorityForSpeachLessons() > 4 || allChildrenAtSpeachLessons.size() > 5) {
            return 0;
        } else allChildrenAtSpeachLessons.add(child);
        return allChildrenAtSpeachLessons.size();
    }
    @Override
    public int compare(Child o1, Child o2) {
        //return o1.getPriorityForSpeachLessons() - o2.getPriorityForSpeachLessons();
        if(o1.getPriorityForSpeachLessons() < o2.getPriorityForSpeachLessons()) {
            return 1;
        }
        else if(o1.getPriorityForSpeachLessons() > o2.getPriorityForSpeachLessons()) {
            return -1;
        }
        return 0;
    } 
}
