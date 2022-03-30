package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.PriorityQueue;

public class SpeachTherapist extends Employee implements Comparator<Child>{
    private String workingMethods;
    //private PriorityQueue<Child> allChildrenAtSpeachLessons = new PriorityQueue<>();
    private ArrayList<Child> allCASL = new ArrayList<>(5);
   
    //Get funkcijas
    /*public PriorityQueue<Child> getAllChildrenAtSpeachLessons() {
        return allChildrenAtSpeachLessons;
    }*/
    public ArrayList<Child> getallCASL() {
        return allCASL;
    }
    //Pārsniedzot size pazūd pēdējais elements
    public void setallCASL(ArrayList<Child> allCASL) {
        if(allCASL != null && allCASL.size() <= 5) {
            this.allCASL = allCASL;
        }
        else if(allCASL.size() > 5) {
            int index = allCASL.size() - 5;
            System.out.println("Pievienotais saraksts ir pilns!" + "Nepiciessams izdzeest "+ index + " elementu/s!");
        } else this.allCASL = new ArrayList<>(5);
    }
    public String getWorkingMethods() {
        return workingMethods;
    }
    //Set funkcijas
    /*public void setAllChildrenAtSpeachLessons(PriorityQueue<Child> allChildrenAtSpeachLessons) {
        if(allChildrenAtSpeachLessons != null) {
            this.allChildrenAtSpeachLessons = allChildrenAtSpeachLessons;
        } else this.allChildrenAtSpeachLessons = new PriorityQueue<>(5);
    }*/
    public void setWorkingMethods(String workingMethods) {
        if(workingMethods != null && workingMethods.matches("[A-ZĒŪĪĀŠĢĶĻŅČŽa-zēūīļķģšāžčņ]+\s?([A-ZĒŪĪĀŠĢĶĻŅČŽa-zēūīļķģšāžčņ]+)?")) {
            this.workingMethods = workingMethods;
        } else workingMethods = "NoWorkingMethods";  
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
        if(allCASL.size() >= 5) {
            return 5;
        } else {
            allCASL.add(child);
            Collections.sort(allCASL, new SpeachTherapist());
        }
        return allCASL.size();
    }
    public boolean removeChildFromAllCASL(){
        if(allCASL != null) {
            allCASL.remove(allCASL.size() - 1);
            System.gc();
            return true;
        }
        return false;
    }
    @Override
    public int compare(Child o1, Child o2) {
        return o1.getPriorityForSpeachLessons() - o2.getPriorityForSpeachLessons();
    }
}

