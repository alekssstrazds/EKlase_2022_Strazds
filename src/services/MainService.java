package services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import models.*;

public class MainService {
    
    private static ArrayList<Employee> allEmployees = new ArrayList<>();
    private static ArrayList<Group> allGroups = new ArrayList<>();
    private static ArrayList<Child> allChildren = new ArrayList<>();
    
    public static void main(String[] args) {

        LocalDate localDate1 = LocalDate.of(2022, 03, 25);
        Date dDate1 = Date.valueOf(localDate1);
        Teacher t = new Teacher();
        Child c = new Child("Genadijs", "Alkalns", "581476-55482", "", 1, Nationality.ESTONIAN);
        Group g = new Group();
        Group g1 = new Group();
        Group g2 = new Group((short) 2020, "Subject", t);
        Child c1 = new Child("Fricis", "Berniks", "145456-54715", "Nezinams sindroms", 3, Nationality.OTHER);
        Child c2 = new Child();
        Teacher t2 = new Teacher("Mafin", "Korkov", "874789-54792", dDate1, TeachingLevel.YOUNGCHILD);
        SpeachTherapist s = new SpeachTherapist("Roberts", "Strelkovs", "1sd156as1d561as546", dDate1, "Leksikas attīstība jeb praktiskaas nodarbiibas");
        SpeachTherapist s1 = new SpeachTherapist();
        allChildren.add(c);
        allChildren.add(c2);
        allGroups.add(g);
        allGroups.add(g1);
        allChildren.add(c1);
        allEmployees.add(s);
        allEmployees.add(s1);
        allEmployees.add(t);
        allEmployees.add(t2);
        
        //addNewTeacher("Mafin", "Korkov", "874789-54792", dDate1, TeachingLevel.YOUNGCHILD);
        addSpeachTherapist("Ron", "Terkov", "164857-57465", dDate1, "Nekas ipass tikai prakse");
        addNewChild("Thomas", "Freeman", "187568-54875", "", 5, Nationality.LITHUANIAN);
        addNewGroup((short) 2022, "Bitites", t);
        
        //Funkcija strādā
        //addChildInGroup(c, g);
        //g1.addChildInGroup(c);
        allGroups.add(g2);
        
        g2.addChildInGroup(c1);
        g2.addChildInGroup(c);
        g2.addChildInGroup(c2);

        
        System.out.println(allEmployees);
        System.out.println(t2);
        System.out.println(t2.getContractDate());
        System.out.println(t2.getTeachingLevel());
        System.out.println(s.getWorkingMethods());
        s.setWorkingMethods("Nezinaams nezinams  NEzimansad");
        System.out.println(s.getWorkingMethods());
        
          

        //Funkcija change and remove strādā
        //changeGroup(c, g1, g);
        //removeChildFromGroup(c, g1);
        //System.out.println(g.getAllChildrenInGroup());
        //System.out.println(g1.getAllChildrenInGroup());
        //System.out.println(allChildren);
        //s.addChildByPriority(c);
        //s.addChildByPriority(c1);
        //TODO funkcijas strada, bet nav pilniigas
        //showAllTeachers();
        //showAllSpeachTherapists();
        //Funkcija straadaa ar arraylist
        //s.addChildByPriority(c1);
        //s.removeChildFromAllCASL();
        //ArrayList<Child> allC = new ArrayList<>();
    
        //s.setallCASL(allC);
        //System.out.println(s.getallCASL());
        //System.out.println(allC);

        System.out.println(s.getallCASL());
        subcribeChildInSpeachLessonsByChildPersonalCode("145456-54715", s);
        System.out.println(s.getallCASL());
        //TODO funkcija strada, bet nav pilniiiga
        //showAllChildrenInGroup(g1);
        //Funkcija straada, bet prasa atjauninajumu
        //showAllChildrenByGroupStartYear((short)0);
        //sortChildrenInGroupBySurname(g2);
        //System.out.println(g2.getAllChildrenInGroup());
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
        if(allEmployees.contains(speachTherapist)) {
            for(Child child : allChildren) {
                if(child.getPersonalCode() == personalCode) {
                    speachTherapist.addChildByPriority(child);
                    return true;
                }
            }
        }
        return false;
    }

    public static void showAllTeachers() {
        for(Employee teachers : allEmployees) {
            if(teachers instanceof Teacher) {
                System.out.println(teachers);
            }
        }
    }
    public static void showAllSpeachTherapists() {
        for(Employee speachTherapists : allEmployees) {
            if(speachTherapists instanceof SpeachTherapist) {
                System.out.println(speachTherapists);
            }
        }
    }
    public static void showAllChildrenInGroup(Group group) {
        for(Group groups : allGroups) {
            if(groups.equals(group)) {
                System.out.println(groups.getAllChildrenInGroup());
            }
        }
    } 
    public void showAllChildrenInSpeachLessonBySpeachTherapistPersonalCode(String personalCode) {
       for(Employee speachTherapists : allEmployees) {
           if(speachTherapists.getPersonalCode() == personalCode) {
                if(speachTherapists instanceof SpeachTherapist) {
                    
                }
           }
       }
    }
    public static void showAllChildrenByGroupStartYear(short groupStartYear) {
        for(Group groups : allGroups) {
            if(groups.getGroupStartYear() == groupStartYear) {
                System.out.println(groups.getAllChildrenInGroup());
            }
        } 
    }
    public static void sortChildrenInGroupBySurname(Group group) {
        MainService i = new MainService();
        for(Group groups : allGroups) {
            if(groups.equals(group)) {
                i.sortLast(allChildren);
            }
        } 
    }
    public void sortLast(ArrayList<Child> allC) {
        Collections.sort(allC, new Comparator<Child>() {
            @Override
            public int compare(Child o1, Child o2) {
                String surname1 = o1.getSurname().substring(0);
                String surname2 = o2.getSurname().substring(0);
            
                if(surname1.compareTo(surname2) > 0) {
                    return 1;
                } else return -1;
            }
        });
        System.out.println(allC);
    }
    
    public String generateLunch() {
        return null;
    }
}
