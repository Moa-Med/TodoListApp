package com.todoApp.Project;

import com.todoApp.Task.CrudTask;

import java.util.Scanner;

public class ProjectMenu {

    public void displaySubMenuProject() {
        System.out.print(" \n>>  Project \n" +
                ">> (1) Add new Project \n" +
                ">> (2) View Project  \n" +
                ">> (3) Update Project \n" +
                ">> (4) Remove Project \n" +
                ">> (5) Back \n" +
                ">> Pick an option: ");
    }

    public void subMenuProjectChoices() {
        String input;
        Scanner sc = new Scanner(System.in);

        //new instance of  class to call the crud methods
        CrudProject crudProject = new CrudProject();

        displaySubMenuProject();

        //iterating through the choices till we exit
        do {
            //initializing the input to get the new input from user
            input = "";
            input = sc.next();

            switch (input) {
                case "1":
                    crudProject.addProject();
                    displaySubMenuProject();
                    break;
                case "2":
                    crudProject.viewProject();
                    displaySubMenuProject();
                    break;
                case "3":
                    crudProject.updateProject();
                    displaySubMenuProject();
                    break;
                case "4":
                    crudProject.removeProject();
                    displaySubMenuProject();
                    break;
                case "5":
                    break;
                default:
                    System.out.print("Please select a valid number : ");
                    break;
            }
            //condition should be satisfied to keep the loop iterating
        } while (input == "1" | input == "2" | input == "3" | input == "4" | (!input.equals("5")));
    }

    // method to display the edit menu
    public void displaySubMenuEditTask() {
        System.out.print(" \n>>  Edit task \n" +
                ">> (1) Update task \n" +
                ">> (2) Mark as done  \n" +
                ">> (3) Remove task \n" +
                ">> (4) Back \n" +
                ">> Pick an option: ");
    }

    // the sub menu edit methods been called
    public void subMenuEdit() {
        String input;
        Scanner sc = new Scanner(System.in);

        //new instance of  class to call the crud task methods
        CrudTask crudTask = new CrudTask();

        displaySubMenuEditTask();
        //iterating through the choices till we exit
        do {
            //initializing the input to get the new input from user
            input = "";
            input = sc.next();

            switch (input) {
                case "1": crudTask.updateTask(); displaySubMenuEditTask();
                    break;
                case "2": crudTask.markAsDone();displaySubMenuEditTask();
                    break;
                case "3": crudTask.removeTask(); displaySubMenuEditTask();
                    break;
                case "4":
                    break;
                default:
                    System.out.print("Please select a valid number : ");
                    break;
            }
            //condition should be satisfied to keep the loop iterating
        } while (input == "1" | input == "2" | input == "3" | (!input.equals("4")));

    }

    // method to display the edit menu
    public void displaySubMenuShowTask() {
        System.out.print(" \n>>  Show Task List \n" +
                ">> (1) Show task by date \n" +
                ">> (2) Show task by project  \n" +
                ">> (3) Back \n" +
                ">> Pick an option: ");
    }

    // the sub menu edit methods been called
    public void subMenuShowTask() {
        String input;
        Scanner sc = new Scanner(System.in);

        //new instance of  class to call the crud task methods
        CrudTask crudTask = new CrudTask();

       displaySubMenuShowTask();
        //iterating through the choices till we exit
        do {
            //initializing the input to get the new input from user
            input = "";
            input = sc.next();

            switch (input) {
                case "1": crudTask.viewTaskByDate(); displaySubMenuShowTask();
                    break;
                case "2": crudTask.viewTaskByProject();displaySubMenuShowTask();
                    break;
                case "3":
                    break;
                default:
                    System.out.print("Please select a valid number : ");
                    break;
            }
            //condition should be satisfied to keep the loop iterating
        } while (input == "1" | input == "2" | (!input.equals("3")));

    }
}