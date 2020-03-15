package com.todoApp;

/**
 * Implementation of a todoLIst Application
 * Java
 * @author Mohamed Traore
 * @date
 * @version 1.0
 */

import com.todoApp.Task.CrudTask;


import java.util.Scanner;

import static com.todoApp.Project.CrudProject.listProject;

public class MainClass {

    public static void displayMenu(){
        // Number of task done and Ongoing
        int  taskDone=0,taskOngoing=0;

        //calculate the number of task done or not by lopping through the project list and task list
        for (int i = 0; i < listProject.size(); i++) {
            for (int j = 0; j < listProject.get(i).getTaskList().size(); j++) {
                if(listProject.get(i).getTaskList().get(j).getStatus().equalsIgnoreCase("Done")){
                    taskDone++;
                }else{taskOngoing++;}
            }
        }
        //Menu print Out
        System.out.print(" \n>> Welcome to ToDoLy\n"+
                ">> You have "+taskOngoing+" task(s) todo and "+taskDone+" task(s) done!\n"+
                ">> (1) Show Task List (by date or project)\n" +
                ">> (2) Project ( Add , update , remove )\n" +
                ">> (3) Add New Task\n" +
                ">> (4) Edit (update, mark as done, remove)\n" +
                ">> (5) Save and Quit \n"+
                ">> Pick an option: " );
         }


    public static void main(String args[]) {

        //take user input with the help of scanner
        String input;
        Scanner sc = new Scanner(System.in);

        //New object of the task operations class
        CrudTask crudTask = new CrudTask();

        // New object of the todoMenu class
        TodoMenu todoMenu = new TodoMenu();

        //New object of the save Data class
        file_Data fileSave =new file_Data();

        fileSave.ReadFromFile();

        displayMenu();

        do {
            //initializing the input to get the new input from user
            input = "";
            input = sc.next();

            switch (input) {
                case "1": todoMenu.subMenuShowTask();displayMenu();
                    break;
                case "2": todoMenu.subMenuProjectCrud(); displayMenu();
                    break;
                case "3": crudTask.addTask();displayMenu();
                    break;
                case "4": todoMenu.subMenuEditTask();displayMenu();
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

}