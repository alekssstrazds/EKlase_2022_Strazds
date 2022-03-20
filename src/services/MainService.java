package services;

import java.util.ArrayList;

import models.*;

public class MainService {
    
    private static ArrayList<Employee> allEmployees = new ArrayList<>();
    private static ArrayList<Group> allGroups = new ArrayList<>();
    private static ArrayList<Teacher> allTeachers = new ArrayList<>();
    private ArrayList<Child> allChild = new ArrayList<>();
    private static ArrayList<SpeachTherapist> allspeachTherapists = new ArrayList<>();
    public static void main(String[] args) {
        Group g = new Group();
        allGroups.add(g);
        g.getAllChildrenInGroup();
    }
    //CRUD - create, read, update, delete
    //C
    private static boolean addNewTeacher() {
        Teacher teacher = new Teacher();
        if(allTeachers.contains(teacher)) {
            return false;
        } else allTeachers.add(teacher);
        return true;
    }
    private static boolean addSpeachTherapist() {
        SpeachTherapist speachTherapist = new SpeachTherapist();
        if(allspeachTherapists.contains(speachTherapist)) {
            return false;
        } else allspeachTherapists.add(speachTherapist);
        return true;
    }
    private static boolean addNewChild() {
        Group group = new Group();
        Child child = new Child();
        if(group.getAllChildrenInGroup().contains(child)) {
            return false;
        } else ;
        return true;
    }
    private static boolean addNewGroup() {
        Group group = new Group();
        if(allGroups.contains(group)) {
            return false;
        } else allGroups.add(group);
        return true;
    }
    //D
    public void deleteTeacherByPersonalCode(String personalCode) {
    }
}
