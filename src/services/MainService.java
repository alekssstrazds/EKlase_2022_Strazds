package services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import models.*;

public class MainService {
    
    private static ArrayList<Employee> allEmployees = new ArrayList<>();
    private static ArrayList<Group> allGroups = new ArrayList<>();
    private static ArrayList<Child> allChildren = new ArrayList<>();
    
    public static void main(String[] args) {

        LocalDate localDate1 = LocalDate.of(2022, 03, 25);
        Date dDate1 = Date.valueOf(localDate1);
        Teacher t = new Teacher();
        Child c = new Child();
        Group g = new Group();
        Group g1 = new Group();
        Child c1 = new Child();
        SpeachTherapist s = new SpeachTherapist();
        allChildren.add(c);
        allGroups.add(g);
        allGroups.add(g1);
        allChildren.add(c1);
        allEmployees.add(s);
        
        addNewTeacher("Mafin", "Korkov", "874789-54792", dDate1, TeachingLevel.YOUNGCHILD);
        addSpeachTherapist("Ron", "Terkov", "164857-57465", dDate1, "Nekas ipass tikai prakse");
        addNewChild("Thomas", "Freeman", "187568-54875", "", 5, Nationality.LITHUANIAN);
        addNewGroup((short) 2022, "Bitites", t);
        
        //Funkcija strādā
        //addChildInGroup(c, g);
        g1.addChildInGroup(c);
        System.out.println(g.getAllChildrenInGroup());
        System.out.println(g1.getAllChildrenInGroup());
        //Funkcija change and remove strādā
        //changeGroup(c, g1, g);
        //removeChildFromGroup(c, g1);
        System.out.println(g.getAllChildrenInGroup());
        System.out.println(g1.getAllChildrenInGroup());
        //System.out.println(allChildren);
        s.addChildByPriority(c);
        System.out.println(s.getAllChildrenAtSpeachLessons());
    }
    public static boolean addNewTeacher(String name, String surname, String personalCode, Date contractDate, TeachingLevel teachingLevel) {
        Teacher teacher = new Teacher(name, surname, personalCode, contractDate, teachingLevel);
        if(allEmployees.contains(teacher)) {
            return false;
        } else allEmployees.add(teacher);
        return true;
    }
    public static boolean addSpeachTherapist(String name, String surname, String personalCode, Date contractDate, String workingMethods) {
        SpeachTherapist speachTherapist = new SpeachTherapist(name, surname, personalCode, contractDate, workingMethods);
        if(allEmployees.contains(speachTherapist)) {
            return false;
        } else allEmployees.add(speachTherapist);
        return true;
    }
    public static boolean addNewChild(String name, String surname, String personalCode, String alergies, int priorityForSpeachLessons, Nationality nationality) {
        Child child = new Child(name, surname, personalCode, alergies, priorityForSpeachLessons, nationality);
        if(allChildren.contains(child)) {
            return false;
        } else allChildren.add(child);
        return true;
    }
    public static boolean addNewGroup(short groupStartYear, String title, Teacher teacher) {
        Group group = new Group(groupStartYear, title, teacher);
        if(allGroups.contains(group)) {
            return false;
        } else allGroups.add(group);
        return true;
    }

    public static boolean removeTeacherByPersonalCode(String personalCode) {
        for(Employee teacher : allEmployees) {
            if(teacher.getPersonalCode() == personalCode) {
                allEmployees.remove(teacher);
                return true;
            }
        }
        return false;
    }
    public static boolean removeTeacherByEmployeeId(int employeeId) {
        for(Employee teacher : allEmployees) {
            if(teacher.getEmployeeId() == employeeId) {
                allEmployees.remove(teacher);
                return true;
            }
        }
        return false;
    }

    public static boolean removeSpeachTherapistByEmployeeId(int employeeId) {
        for(Employee speachTherapist : allEmployees) {
            if(speachTherapist.getEmployeeId() == employeeId) {
                allEmployees.remove(speachTherapist);
                return true;
            }
        }
        return false;
    }
    public static boolean removeSpeachTherapistByPersonalCode(String personalCode) {
        for(Employee speachTherapist : allEmployees) {
            if(speachTherapist.getPersonalCode() == personalCode) {
                allEmployees.remove(speachTherapist);
                return true;
            }
        }
        return false;
    }
    public static boolean removeChildByPersonalCode(String personalCode) {
        for(Child child : allChildren) {
            if(child.getPersonalCode() == personalCode) {
                allChildren.remove(child);
                for(Group group : allGroups) {
                    if(group.getAllChildrenInGroup().contains(child)) {
                        removeChildFromGroup(child, group);
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean removeGroupByTitleAndYearAndTeacher(String title, short groupStartYear, Teacher teacher) {
        for(Group group : allGroups) {
            if(group.getTitle() == title && group.getGroupStartYear() == groupStartYear && group.getTeacher() == teacher) {
                allGroups.remove(group);
                return true;
            }
        }
        return false;
    }
    public static boolean addChildInGroup(Child child, Group group) {
        for(Group groups : allGroups) {
            if(group.equals(groups)) {
                group.addChildInGroup(child);
                return true;
            }
        }
        return false;
    }
    public static boolean removeChildFromGroup(Child child, Group group) {
        for(Group groups : allGroups) {
            if(groups.equals(group) && groups.getAllChildrenInGroup().contains(child)) {
                groups.removeChildInGroup(child);
                return true;
            }
        }
        return false;
    }
    public static boolean changeGroup(Child child, Group group1, Group group2) {
        for(Child children : allChildren) {
            if(children.equals(child)) {
                for(Group groups : allGroups) {
                    if(groups.equals(group1)) {
                        addChildInGroup(child, group2);
                        removeChildFromGroup(child, group1);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean subcribeChildInSpeachLessonsByChildPersonalCode(String personalCode, SpeachTherapist speachTherapist) {
        
        return false;
    }

    public void showAllTeachers() {

    }
    public void showAllSpeachTherapists() {

    }
    public void showAllChildrenInGroup(Group group) {

    }
    public void showAllChildrenInSpeachLessonBySpeachTherapistPersonalCode(String personalCode) {
       
    }
    public void showAllChildrenByGroupStartYear(short groupStartYear) {

    }
    public void sortChildrenInGroupBySurname(Group group) {

    }
    
    public String generateLunch() {
        return null;
    }
}
