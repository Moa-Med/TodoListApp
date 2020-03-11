package com.todoApp.Task;

import com.todoApp.Project.CrudProject;
import java.util.Scanner;
import static com.todoApp.Project.CrudProject.listProject;

public class CrudTask {

        private String nameTask;

        //getting input from user
        Scanner sc = new Scanner(System.in);

        //a new instance of the class CrudProject
        CrudProject crudProject = new CrudProject();

        public void viewTaskByProject() {

            boolean verifyTask = true;
            System.out.println("*** Viewing Task(s) by Project ***");
            //verify if there is task existing
            for (int i = 0; i < listProject.size(); i++) {
                // going through tasks and print them out
                if (listProject.get(i).getTaskList().size() != 0) {
                    verifyTask = false;
                }
            }

            if (!verifyTask) {
                //going through all the project and print them out
                for (int i = 0; i < listProject.size(); i++) {

                    System.out.println("PROJECT NAME : " + listProject.get(i).getName_project());

                    // going through tasks and print them out
                    for (int j = 0; j < listProject.get(i).getTaskList().size(); j++) {
                        System.out.println("Task title: " + listProject.get(i).getTaskList().get(j).getTitle()+
                                "  Due date: "+ listProject.get(i).getTaskList().get(j).getDue_date()+
                                "  Status: "+listProject.get(i).getTaskList().get(j).getStatus()+
                                "  Project: "+listProject.get(i).getTaskList().get(j).getProject());
                    }
                    System.out.print("\n");
                }
            } else {  System.out.println("There is no tasks created yet");}
        }

    public void viewTaskByDate() {

        boolean verifyTask = true;
        System.out.println("*** Viewing Task(s) by date ***");
        //verify if there is task existing
        for (int i = 0; i < listProject.size(); i++) {
            // checking task list if its empty
            if (listProject.get(i).getTaskList().size() != 0) {
                verifyTask = false;
            }
        }

        if (!verifyTask) {
            //going through all the project and print them out
            for (int i = 0; i < listProject.size(); i++) {
                // going through tasks and print them out
                for (int j = 0; j < listProject.get(i).getTaskList().size(); j++) {
                    System.out.println("Task title: " + listProject.get(i).getTaskList().get(j).getTitle()+
                            "  Due date: "+ listProject.get(i).getTaskList().get(j).getDue_date()+
                            "  Status: "+listProject.get(i).getTaskList().get(j).getStatus()+
                            "  Project: "+listProject.get(i).getTaskList().get(j).getProject());
                }
                System.out.print("\n");
            }
        } else {  System.out.println("There is no tasks created yet");}
    }


        public void addTask(){

            boolean verifyProject = false ,verifyTask = false;

            if(listProject.size() == 0){System.out.println(" Create a project , there is no project !");
              crudProject.addProject();
            }
                System.out.print("*** Adding a Task *** \nEnter the Title : ");
                String title = sc.nextLine();
                System.out.print("Enter the Task due date : ");
                String due_date = sc.nextLine();
                String status = "Ongoing";
                System.out.println(" Project(s) available: ");
                listProject.stream().forEach(t->System.out.println("- "+t.getName_project()));
                System.out.print(" enter project name : ");
                String projectName = sc.nextLine();

                //verifying if the project name is correct
            for(int i = 0; i<listProject.size(); i++){
                if(listProject.get(i).getName_project().equalsIgnoreCase(projectName)){
                    verifyProject = true;
                }
                    // checking if the task already exist
                    for(int j = 0; j<listProject.get(i).getTaskList().size(); j++){
                        if(listProject.get(i).getTaskList().get(j).getTitle().equalsIgnoreCase(title)){
                            verifyTask = true;
                        }
                    }
            }
                //add project if doesnt exist
                if (verifyProject) {
                    if (!verifyTask) {
                        for (int i = 0; i < listProject.size(); i++) {
                            if (listProject.get(i).getName_project().equalsIgnoreCase(projectName)) {

                                listProject.get(i).getTaskList().add(new TaskModel(title, due_date, status, projectName));
                            }
                        }
                        System.out.println("Task added !");
                    } else {
                        System.out.println("Task already exist");
                    }
                } else {
                    System.out.println("This project doesn't exist");
                }
            }

            //add task updated
            public void newUpdateTask(String firstTitle){

               boolean verifyProject=false , verifyTask= false;

               int projectIndex=0;

                System.out.print("\nEnter the new Title : ");
                String title = sc.nextLine();
                System.out.print("Enter a new due date : ");
                String due_date = sc.nextLine();
                String status = "Ongoing";
                System.out.println(" Project(s) available: ");
                listProject.stream().forEach(t->System.out.println("- "+t.getName_project()));
                System.out.print(" enter project name : ");
                String projectName = sc.nextLine();

                for(int i = 0; i<listProject.size(); i++){
                    if(listProject.get(i).getName_project().equalsIgnoreCase(projectName)){
                        verifyProject = true;
                        // project index saved and use it if the old project name is different from the new one
                        projectIndex=i;
                       // checking if the task already exist
                        for(int j = 0; j<listProject.get(i).getTaskList().size(); j++){
                            if(listProject.get(i).getTaskList().get(j).getTitle().equalsIgnoreCase(title)){
                                verifyTask=true;
                            }
                        }
                    }
                }
                //add task if doesnt exist
                if (verifyProject) {
                    if (!verifyTask) {
                        for (int i = 0; i < listProject.size(); i++) {
                            for(int j = 0 ; j < listProject.get(i).getTaskList().size(); j++) {
                                if (listProject.get(i).getTaskList().get(j).getTitle().equalsIgnoreCase(firstTitle)) {
                                    //add change to another project if the project name has been update
                                    if(projectName==listProject.get(i).getName_project()){
                                        listProject.get(i).getTaskList().set(j,new TaskModel(title, due_date, status, projectName));
                                    }else{
                                        // project index saved and use it if the old project name is different from the new one
                                        listProject.get(projectIndex).getTaskList().add(new TaskModel(title, due_date, status, projectName));
                                        // we need to delete the previews one
                                        listProject.get(i).getTaskList().remove(j);
                                    }
                                }
                            }
                        }
                        System.out.println("Task Updated !");
                    }else{
                        System.out.println("This Task title already exist");
                    }
                } else {
                    System.out.println("This project doesn't exist");
                }
              }

        public void updateTask() {
            //will be true if the project exist
            boolean exist = false;

            System.out.print("*** Updating Task *** \nEnter the Task title : ");
            String taskTitle = sc.nextLine();

            //going through all the projects
            for (int i = 0; i < listProject.size(); i++) {
                // going through tasks and print them out
                for (int j = 0; j < listProject.get(i).getTaskList().size(); j++) {
                    if (listProject.get(i).getTaskList().get(j).getTitle().equalsIgnoreCase(taskTitle)) {
                        exist = true;
                        newUpdateTask(taskTitle);
                    }
                }
            }
            if(!exist){ System.out.println("This task doesn't exist... ");}
        }

        public void removeTask(){

            // checking if task exist
            boolean verifyTask= false;

            System.out.print("*** Removing Task *** \nEnter the Task title : ");
            String title = sc.nextLine();

            for(int i = 0; i<listProject.size(); i++) {
                for (int j = 0; j < listProject.get(i).getTaskList().size(); j++) {
                    if (listProject.get(i).getTaskList().get(j).getTitle().equalsIgnoreCase(title)) {
                        verifyTask = true;
                        listProject.get(i).getTaskList().remove(j);
                    }
                }
            }
            if(verifyTask){
            System.out.println("Task Deleted !");
            } else {
                System.out.println("This task doesn't exist");
                   }
        }

        public void markAsDone(){

            // checking if task exist
            boolean verifyTask= false;

            System.out.print("*** Status Task *** \nEnter the Task title : ");
            String title = sc.nextLine();

            for(int i = 0; i<listProject.size(); i++) {
                for (int j = 0; j < listProject.get(i).getTaskList().size(); j++) {
                    if (listProject.get(i).getTaskList().get(j).getTitle().equalsIgnoreCase(title)) {
                        verifyTask = true;
                        listProject.get(i).getTaskList().get(j).setStatus("Done");
                    }
                }
            }
            if(verifyTask){
                System.out.println("Task Marked as done !");
            } else {
                System.out.println("This task doesn't exist");
            }
        }


}
