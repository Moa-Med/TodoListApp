package com.todoApp;

import com.todoApp.Project.ProjectMenu;
import com.todoApp.Task.CrudTask;


import java.util.ArrayList;
import java.util.Scanner;

import static com.todoApp.Project.CrudProject.listProject;

public class MainClass {



    public static void displayMenu(){

        int  taskDone=0,taskOngoing=0;

        //calculate the number of task done or not by lopping through the project list and task list
        for (int i = 0; i < listProject.size(); i++) {
            for (int j = 0; j < listProject.get(i).getTaskList().size(); j++) {
                if(listProject.get(i).getTaskList().get(j).getStatus().equalsIgnoreCase("Done")){
                    taskDone++;
                }else{taskOngoing++;}
            }
        }

        System.out.print(" \n>> Welcome to ToDoLy\n"+
                ">> You have "+taskOngoing+" task(s) todo and "+taskDone+" task(s) done!\n"+
                ">> (1) Show Task List (by date or project)\n" +
                ">> (2) Project ( Add , update , remove )\n" +
                ">> (3) Add New Task\n" +
                ">> (4) Edit (update, mark as done, remove)\n" +
                ">> (5) Save and Quit \n\n"+
                ">> Pick an option: " );
         }

    public static void main(String args[]) {

        //takes user input with the help of scanner
        String input;
        Scanner sc = new Scanner(System.in);

        //the task operations class
        CrudTask crudTask = new CrudTask();

        //an instance of the save Data
        file_Data fileSave =new file_Data();

        // the project Menu class
        ProjectMenu projectMenu = new ProjectMenu();

        fileSave.ReadFromFile();

        displayMenu();

        //iterating through the choices till we exit
        do {
            //initializing the input to get the new input from user
            input = "";
            input = sc.next();

            switch (input) {
                case "1": projectMenu.subMenuShowTask();displayMenu();
                    break;
                case "2": projectMenu.subMenuProjectChoices(); displayMenu();
                    break;
                case "3": crudTask.addTask();displayMenu();
                    break;
                case "4": projectMenu.subMenuEdit();displayMenu();
                    break;
                case "5": fileSave.WriteInFile(); System.out.println("Good bye and see you soon :) ");
                    break;
                default:
                    System.out.print("Please select a valid number : ");
                    break;
            }
            //condition should be satisfied to keep the loop iterating
        } while (input == "1" | input == "2" | input == "3" | input == "4" | (!input.equals("5")));
    }


    // providing the number tasks by status (done/not-done)
    public ArrayList<Integer> file_verification(){

        return new ArrayList<Integer>();
    }
}