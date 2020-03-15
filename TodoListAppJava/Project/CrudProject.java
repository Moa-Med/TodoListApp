package com.todoApp.Project;

import java.util.ArrayList;
import java.util.Scanner;

public class CrudProject {

    public static ArrayList<ProjectModel> listProject = new ArrayList<>();

    //getting input from user
    Scanner sc = new Scanner(System.in);

    public void viewProject(){

        System.out.println("*** View Project(s) ***");

        if(listProject.size()==0){
            System.out.println("Project empty ");
        }else{
            listProject.stream().forEach(t->System.out.println(t.getName_project()));
        }
    }

    public void addProject(){

        System.out.print("\n*** Add a Project *** \nEnter the Project Name : ");
        String projectName = sc.nextLine();

        boolean verifyProject = false;
        //checking if the project exist by going through the list of projects
        for(int i = 0; i<listProject.size(); i++) {
            if (listProject.get(i).getName_project().equalsIgnoreCase(projectName)) {
                verifyProject = true;
            }
        }

        //add project if doesnt exist or not empty field
        if(verifyProject && projectName == ""){
            System.out.println("This Project already exist or field empty ");
        } else {
            listProject.add(new ProjectModel(projectName));
            System.out.println("Project created ");
        }
    }


    public void updateProject(){

        boolean verifyProject=false;

        System.out.print("\n*** Update Project *** \nEnter the Project Name : ");

        String input=sc.nextLine();

        //looping through the project list to update the project if exist
        for(int i=0;i<listProject.size();i++) {
            if (input.equalsIgnoreCase(listProject.get(i).getName_project())) {
                verifyProject=true;
                System.out.print("Enter a new Project Name : ");
                String newInput=sc.nextLine();
                //verifying if the new input is not empty
                if(newInput==""){
                    System.out.print(" Project name is empty");
                }else {
                    listProject.get(i).setName_project(newInput);
                }
            }
        }

        if(!verifyProject){ System.out.println("This project doesn't exist... "); }
    }


    public void removeProject(){


        boolean verifyProject=false;

        System.out.print("\n*** Removing a Project *** \nEnter the Project Name : ");
        String input=sc.nextLine();

        //looping through the list to remove the project if exist
        for(int i=0;i<listProject.size();i++) {
            if (input.equalsIgnoreCase(listProject.get(i).getName_project())) {
                verifyProject=true;
                listProject.remove(i);
            }
        }
        if(!verifyProject){ System.out.println("This project doesn't exist... "); }{
            System.out.print("Project deleted ");
        }

    }
}
