package models;

import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

public class SpeachTherapist extends Employee implements Comparable<Child>{
    private String workingMethods;
    private PriorityQueue<Child> allChildrenAtSpeachLessons = new PriorityQueue<>(5);
    //Get funkcijas
    public PriorityQueue<Child> getAllChildrenAtSpeachLessons() {
        return allChildrenAtSpeachLessons;
    }
    public String getWorkingMethods() {
        return workingMethods;
    }
    //Set funkcijas
    /*public void setAllChildrenAtSpeachLessons(PriorityQueue<Child> allChildrenAtSpeachLessons) {
        //getPriorityForSpeachLessons()
        if(allChildrenAtSpeachLessons.peek() != null) {
            this.allChildrenAtSpeachLessons.add(getPriorityForSpeachLessons());
        } else this.allChildrenAtSpeachLessons = new PriorityQueue<>(5);
    }*/
    public void setWorkingMethods(String workingMethods) {
        this.workingMethods = workingMethods;
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
    /*@Override
    public int compareTo(Child o) {
        if(getPriorityForSpeachLessons() == o.getPriorityForSpeachLessons()) {
            return 0;
        } else if(getPriorityForSpeachLessons() < o.getPriorityForSpeachLessons()){
            return -1;
        } else {
            return +1;
        }
        return 0;
    }*/
    @Override
    public int compareTo(Child o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
