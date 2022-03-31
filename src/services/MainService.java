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
        Child c = new Child("Genadijs", "Alkalns", "581476-55482", "", 1, Nationality.ESTONIAN);
        Child c1 = new Child("Fricis", "Berniks", "145456-54715", "Laktoze", 3, Nationality.OTHER);
        Child c2 = new Child("Jānis", "Resku", "123476-88774", "Alerģija pret olbaltumvielām", 3, Nationality.OTHER);
        Child c3 = new Child();
        Child c4 = new Child("Francis", "Kerko", "478656-51478", "", 5, Nationality.LATVIAN);
        allChildren.add(c);
        allChildren.add(c1);
        allChildren.add(c2);
        allChildren.add(c3);
        allChildren.add(c4);

        LocalDate localDate1 = LocalDate.of(2022, 03, 25);
        Date dDate1 = Date.valueOf(localDate1);
        LocalDate localDate2 = LocalDate.of(2022, 04, 14);
        Date dDate2 = Date.valueOf(localDate2);
        LocalDate localDate3 = LocalDate.of(2021, 06, 15);
        Date dDate3 = Date.valueOf(localDate3);

        Teacher t = new Teacher("Daiga", "Strogolova", "647289-15475", dDate1, TeachingLevel.TODDLER);
        Teacher t1 = new Teacher("Paula", "Sevalcuk", "225488-11245", dDate2, TeachingLevel.PRESCHOOL);
        Teacher t2 = new Teacher("Mafin", "Korkov", "874789-54792", dDate3, TeachingLevel.YOUNGCHILD);
        Teacher t3 = new Teacher();
        allEmployees.add(t);
        allEmployees.add(t1);
        allEmployees.add(t2);
        allEmployees.add(t3);

        Group g = new Group((short) 2021, "Zaķīši", t);
        Group g1 = new Group((short) 2022, "Taurenīši", t1);
        Group g2 = new Group((short) 2020, "Mārītes", t2);
        Group g3 = new Group();
        allGroups.add(g);
        allGroups.add(g1);
        allGroups.add(g2);
        allGroups.add(g3);

        SpeachTherapist s = new SpeachTherapist("Roberts", "Strelkovs", "547985-54874", dDate1, "Leksikas attistiba");
        SpeachTherapist s1 = new SpeachTherapist("Kevins", "Lemens", "197846-54789", dDate2, "Logopedija");
        SpeachTherapist s2 = new SpeachTherapist();
        allEmployees.add(s);
        allEmployees.add(s1);
        allEmployees.add(s2);
        //AddNew funkcijas
        addNewTeacher("Mafin", "Korkov", "874789-54792", dDate1, TeachingLevel.YOUNGCHILD);
        addNewSpeachTherapist("Ron", "Terkov", "164857-57465", dDate1, "Sarunas");
        addNewChild("Thomas", "Freeman", "187568-54875", "", 5, Nationality.LITHUANIAN);
        addNewGroup((short) 2022, "Bitites", t);  
        //AllEmployees izvade
        for(Employee employee : allEmployees) {
            System.out.println(employee.toString());
        }
        System.out.println("----------------------------------------------");
        //RemoveBy funkcijas
        removeTeacherByPersonalCode("874789-54792");
        removeTeacherByEmployeeId(5);
        removeSpeachTherapistByEmployeeId(6);
        removeSpeachTherapistByPersonalCode("164857-57465");
        removeChildByPersonalCode("547985-54874");
        for(Employee employee : allEmployees) {
            System.out.println(employee.toString());
        }
        //Group funkcijas
        System.out.println("----------------------------------------------");
        for(Group groups : allGroups) {
            System.out.println(groups.toString());
            for(Child childs : allChildren) {
                System.out.println(childs.toString());
            }
            System.out.println("==============================");
        }
        removeGroupByTitleAndYearAndTeacher("Zaķīši", (short) 2021, t);

        addChildInGroup(c4, g3);
        showAllChildrenInGroup(g3);
        showAllChildrenInGroup(g1);
        System.out.println("----------------------------------------------");
        changeGroup(c4, g3, g1);
        showAllChildrenInGroup(g3);
        showAllChildrenInGroup(g1);
        System.out.println("----------------------------------------------");
        removeChildFromGroup(c4, g1);
        showAllChildrenInGroup(g3);
        showAllChildrenInGroup(g1);
        System.out.println("----------------------------------------------");

        subcribeChildInSpeachLessonsByChildPersonalCode("478656-51478", s);
        System.out.println("----------------------------------------------");
        showAllTeachers();
        System.out.println("----------------------------------------------");
        showAllSpeachTherapists();
        System.out.println("----------------------------------------------");
        showAllChildrenInGroup(g2);
        System.out.println("----------------------------------------------");
        s1.setallCASL(allChildren);
        showAllChildrenInSpeachLessonBySpeachTherapistPersonalCode("197846-54789");
        System.out.println("----------------------------------------------");
        showAllChildrenByGroupStartYear((short) 2021);
        System.out.println("----------------------------------------------");
        sortChildrenInGroupBySurname(g1);
        System.out.println("----------------------------------------------");
        sortLast(allChildren);
    }
    /**
     * Pievienot jaunu Teacher objektu ievērojot nosacijumus, ka allEmployees arraylist nesatur to.
     * @param name
     * @param surname
     * @param personalCode
     * @param contractDate
     * @param teachingLevel
     * @return boolean vērtība vai nosacijumi izpildās.
     */
    public static boolean addNewTeacher(String name, String surname, String personalCode, Date contractDate, TeachingLevel teachingLevel) {
        Teacher teacher = new Teacher(name, surname, personalCode, contractDate, teachingLevel);
        if(allEmployees.contains(teacher)) {
            return false;
        } else allEmployees.add(teacher);
        return true;
    }
    /**
     * Pievienot jaunu SpeachTherapist objektu ievērojot nosacijumus, ka allEmployees arraylist nesatur to.
     * @param name
     * @param surname
     * @param personalCode
     * @param contractDate
     * @param workingMethods
     * @return boolean vērtība vai nosacijumi izpildās.
     */
    public static boolean addNewSpeachTherapist(String name, String surname, String personalCode, Date contractDate, String workingMethods) {
        SpeachTherapist speachTherapist = new SpeachTherapist(name, surname, personalCode, contractDate, workingMethods);
        if(allEmployees.contains(speachTherapist)) {
            return false;
        } else allEmployees.add(speachTherapist);
        return true;
    }
    /**
     * Pievienot jaunu SpeachTherapist objektu ievērojot nosacijumus, ka allEmployees arraylist nesatur to.
     * @param name
     * @param surname
     * @param personalCode
     * @param alergies
     * @param priorityForSpeachLessons
     * @param nationality
     * @return boolean vērtība vai nosacijumi izpildās.
     */ 
    public static boolean addNewChild(String name, String surname, String personalCode, String alergies, int priorityForSpeachLessons, Nationality nationality) {
        Child child = new Child(name, surname, personalCode, alergies, priorityForSpeachLessons, nationality);
        if(allChildren.contains(child)) {
            return false;
        } else allChildren.add(child);
        return true;
    }
    /**
     * Pievienot jaunu Group objektu ievērojot nosacijumus, ka allGroups arraylist nesatur to.
     * @param groupStartYear
     * @param title
     * @param teacher
     * @return boolean vērtība vai nosacijumi izpildās.
     */
    public static boolean addNewGroup(short groupStartYear, String title, Teacher teacher) {
        Group group = new Group(groupStartYear, title, teacher);
        if(allGroups.contains(group)) {
            return false;
        } else allGroups.add(group);
        return true;
    }
    /**
     * Tiek dzēsts Teacher objekts no allEmployees arraylist, ja tas atbilst padotam personalCode.
     * @param personalCode
     * @return boolean vērtība vai nosacijumi izpildās.
     */
    public static boolean removeTeacherByPersonalCode(String personalCode) {
        for(Employee teacher : allEmployees) {
            if(teacher.getPersonalCode() == personalCode && teacher instanceof Teacher) {
                allEmployees.remove(teacher);
                return true;
            }
        }
        return false;
    }
    /**
     * Tiek dzēsts Teacher objekts no allEmployees arraylist, ja tas atbilst padotam employeeId.
     * @param employeeId
     * @return boolean vērtība vai nosacijumi izpildās.
     */
    public static boolean removeTeacherByEmployeeId(int employeeId) {
        for(Employee teacher : allEmployees) {
            if(teacher.getEmployeeId() == employeeId && teacher instanceof Teacher) {
                allEmployees.remove(teacher);
                return true;
            }
        }
        return false;
    }
    /**
     * Tiek dzēsts SpeachTherapist objekts no allEmployees arraylist, ja tas atbilst padotam employeeId.
     * @param employeeId
     * @return boolean vērtība vai nosacijumi izpildās.
     */
    public static boolean removeSpeachTherapistByEmployeeId(int employeeId) {
        for(Employee speachTherapist : allEmployees) {
            if(speachTherapist.getEmployeeId() == employeeId && speachTherapist instanceof SpeachTherapist) {
                allEmployees.remove(speachTherapist);
                return true;
            }
        }
        return false;
    }
    /**
     * Tiek dzēsts SpeachTherapist objekts no allEmployees arraylist, ja tas atbilst padotam personalCode.
     * @param personalCode
     * @return boolean vērtība vai nosacijumi izpildās.
     */
    public static boolean removeSpeachTherapistByPersonalCode(String personalCode) {
        for(Employee speachTherapist : allEmployees) {
            if(speachTherapist.getPersonalCode() == personalCode && speachTherapist instanceof SpeachTherapist) {
                allEmployees.remove(speachTherapist);
                return true;
            }
        }
        return false;
    }
    /**
     * Tiek dzēsts Child objekts no allGroups arraylist, ja tas atbilst padotam personalCode.
     * @param personalCode
     * @return boolean vērtība vai nosacijumi izpildās.
     */
    public static boolean removeChildByPersonalCode(String personalCode) {
        for(Child child : allChildren) {
            if(child.getPersonalCode() == personalCode ) {
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
    /**
     * Tiek dzēsts Group objekts no allGroups arraylist, ja tas atbilst padotam personalCode un teacher objektam.
     * @param title
     * @param groupStartYear
     * @param teacher
     * @return boolean vērtība vai nosacijumi izpildās.
     */
    public static boolean removeGroupByTitleAndYearAndTeacher(String title, short groupStartYear, Teacher teacher) {
        for(Group group : allGroups) {
            if(group.getTitle() == title && group.getGroupStartYear() == groupStartYear && group.getTeacher() == teacher) {
                allGroups.remove(group);
                return true;
            }
        }
        return false;
    }
    /**
     * Pievieno Child objektu iekšs Group objekta kurš satur sarakstu arraylist ar Child objektiem.
     * @param child
     * @param group
     * @return boolean vērtība vai nosacijumi izpildās.
     */
    public static boolean addChildInGroup(Child child, Group group) {
        for(Group groups : allGroups) {
            if(group.equals(groups)) {
                groups.addChildrenInGroup(child);
                return true;
            }
        }
        return false;
    }
    /**
     * Tiek dzēsts Child objekts no Group objekta kurš satur sarakstu arraylist ar Child objektiem.
     * @param child
     * @param group
     * @return boolean vērtība vai nosacijumi izpildās.
     */
    public static boolean removeChildFromGroup(Child child, Group group) {
        for(Group groups : allGroups) {
            if(groups.equals(group) && groups.getAllChildrenInGroup().contains(child)) {
                groups.removeChildInGroup(child);
                return true;
            }
        }
        return false;
    }
    /**
     * Samaina padotā Child objekta novietojumu no Group1 objekta saturošā saraksta arraylist uz Group2 objekta sarakstu.
     * @param child
     * @param group1
     * @param group2
     * @return boolean vērtība vai nosacijumi izpildās.
     */
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
    /**
     * Pievieno Child objektu iekšs SpeachTherapist objekta kuršs satur priority sarakstu iekšs kura tiek pievienots Child pēc tā prioritāte vērtība.
     * @param personalCode
     * @param speachTherapist
     * @return boolean vērtība vai nosacijumi izpildās.
     */
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
    /**
     * Ejot cauri sarakstam allEmployees tiek izprintēts Teacher objekti.
     */
    public static void showAllTeachers() {
        for(Employee teachers : allEmployees) {
            if(teachers instanceof Teacher) {
                System.out.println(teachers.toString());
            }
        }
    }
    /**
     * Ejot cauri sarakstam allEmployees tiek izprintēts SpeachTherapist objekti.
     */
    public static void showAllSpeachTherapists() {
        for(Employee speachTherapists : allEmployees) {
            if(speachTherapists instanceof SpeachTherapist) {
                System.out.println(speachTherapists.toString());
            }
        }
    }
    /**
     * Funkcijai tiek pādots, kā parametrs Group objekts un tiek izprintēts tā saraksta Child objekti.
     * @param group
     */
    public static void showAllChildrenInGroup(Group group) {
        for(Group groups : allGroups) {
            if(groups.equals(group)) {
                System.out.println(groups.getAllChildrenInGroup().toString());
            }
        }
    } 
    /**
     * Tiek izprintēti visi Child objekti kuri atrodās iekš SpeachTherapist objekta saraksta kur SpeachTherapist tiek izvēlēts pēc padotā parametra personalCode.
     * @param personalCode
     */
    public static void showAllChildrenInSpeachLessonBySpeachTherapistPersonalCode(String personalCode) {
       for(Employee speachTherapists : allEmployees) {
           if(speachTherapists.getPersonalCode().equals(personalCode)) {
                SpeachTherapist specificObject = (SpeachTherapist) speachTherapists;
                System.out.println(specificObject.getallCASL());
            }
       }
    }
    /**
     * Tiek izprintēti visi Child objekti kuri atrodās iekšs Group objekta, savukārt objekts tiek izvēlēt pēc padotā parametra groupStartYear.
     * @param groupStartYear
     */
    public static void showAllChildrenByGroupStartYear(short groupStartYear) {
        for(Group groups : allGroups) {
            if(groups.getGroupStartYear() == groupStartYear) {
                System.out.println(groups.getAllChildrenInGroup());
            }
        } 
    }
    /**
     * Kārto Group objekta padoto arraylist saturošos Child objektus pēc Surname pirmā burta.
     * @param group
     */
    public static void sortChildrenInGroupBySurname(Group group) {
        for(Group groups : allGroups) {
            if(groups.equals(group)) {
                MainService.sortLast(allChildren);
            }
        } 
    }
    /**
     * Tiek izveidota funkcija kurā tiek aprakstīta sort loģika, lai izmantotu Collections iekšs sortChildrenInBySurname(Group group) funkcijas.
     * @param allC
     */
    public static void sortLast(ArrayList<Child> allC) {
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
    /**
     * Nerealizētais generateLunch() funckija.
     * @return
     */
    public String generateLunch() {
        return null;
    }
}
