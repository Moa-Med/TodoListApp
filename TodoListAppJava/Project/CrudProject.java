package com.todoApp.Project;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudProject {

    private String nameProject;

    public static ArrayList<ProjectModel> listProject = new ArrayList<>();

    //getting input from user
    Scanner sc = new Scanner(System.in);

    public void viewProject(){
        System.out.println("*** Viewing Project(s) ***");
        if(listProject.size()==0){
            System.out.println("Project empty ");
        }else{
            listProject.stream().forEach(t->System.out.println(t.getName_project()));
        }
    }

    public void addProject(){

        System.out.print("*** Adding a Project *** \nEnter the Project Name : ");
        String input=sc.nextLine();

        //add project if doesnt exist
        if(listProject.contains(input)){
            System.out.println("This Project already exist");
        } else {
            listProject.add(new ProjectModel(input));
        }
    }

    public void updateProject(){
        //will be true if the project exist
        boolean exist=false;

        System.out.print("*** Updating Project *** \nEnter the Project Name : ");
        String input=sc.nextLine();

        //looping through the list to update the project if exist
        for(int i=0;i<listProject.size();i++) {
            if (input.equalsIgnoreCase(listProject.get(i).getName_project())) {
                exist=true;
                System.out.print("Enter a new Project Name : ");
                String newInput=sc.nextLine();
                listProject.get(i).setName_project(newInput);
            }
        }

        if(!exist){ System.out.println("This project doesn't exist... "); }
    }

    public void removeProject(){

        //will be true if the project exist
        boolean exist=false;

        System.out.print("*** Removing a Project *** \nEnter the Project Name : ");
        String input=sc.nextLine();

        //looping through the list to update the project if exist
        for(int i=0;i<listProject.size();i++) {
            if (input.equalsIgnoreCase(listProject.get(i).getName_project())) {
                exist=true;
                listProject.remove(i);
            }
        }
        if(!exist){ System.out.println("This project doesn't exist... "); }

        }

}
