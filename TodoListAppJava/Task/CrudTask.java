package com.todoApp.Task;

import com.todoApp.Project.CrudProject;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.*;

import static com.todoApp.Project.CrudProject.listProject;

public class CrudTask {

        //Get input from user
        Scanner sc = new Scanner(System.in);

        //New instance of the class CrudProject
        CrudProject crudProject = new CrudProject();

        public void viewTaskByProject() {

            boolean verifyTask = true;

            System.out.println("*** View Task(s) by Project ***");

            //verify if there is task existing
            for (int i = 0; i < listProject.size(); i++) {
                if (listProject.get(i).getTaskList().size() != 0) {
                    verifyTask = false;
                }
            }

            if (!verifyTask) {
                //going through all the project and print them out with the tasks
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

        ArrayList<TaskModel> dateList = new ArrayList<>();
        System.out.println("*** View Task(s) sorted by date ***");

        //verify if there is task existing
        for (int i = 0; i < listProject.size(); i++) {
            if (listProject.get(i).getTaskList().size() != 0) {
                verifyTask = false;
            }
        }

        if (!verifyTask) {
            // going through tasks and add them to the array
            for (int i = 0; i < listProject.size(); i++) {
                for (int j = 0; j < listProject.get(i).getTaskList().size(); j++) {
                    dateList.add(listProject.get(i).getTaskList().get(j));
                  }
               }

            //displaying all the tasks sorted with the help of the method sort task by date
            sortTaskByDate(dateList).stream().forEach(t->System.out.println(" Date : "+t.getDue_date()+
                    "     Title : "+t.getTitle()+"     Status : "+t.getStatus()+"     Project : "+t.getProject()));

        } else {  System.out.println("There is no tasks created yet");}
    }

    // Comparing the date method
    public ArrayList<TaskModel> sortTaskByDate(ArrayList<TaskModel> dateList) {

        Comparator<TaskModel> compareTask = new Comparator<>() {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            int compareReturn = 1 ;
            @Override
            public int compare(TaskModel task1, TaskModel task2) {
                try {
                    compareReturn = dateFormat.parse(task1.getDue_date()).compareTo(dateFormat.parse(task2.getDue_date()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return compareReturn;
            }
        };

        Collections.sort(dateList , compareTask);
        return  dateList;
    }


        public void addTask(){

            boolean verifyProject = false ,verifyTask = false , verifyDate = false ;

            if(listProject.size() == 0){System.out.println("\n****Create a project , there is no project !");
              crudProject.addProject();
            }
                System.out.print("\n*** Adding a Task *** \nEnter the Title : ");
                String title = sc.nextLine();
                System.out.print("Due date (yyyy-mm-dd) : ");
                String due_date = sc.nextLine();
                String status = "Ongoing";
                System.out.println(" Project(s) available: ");
                listProject.stream().forEach(t->System.out.println("- "+t.getName_project()));
                System.out.print(" enter project name : ");
                String projectName = sc.nextLine();

                //verify if the project name is correct
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

                //checking the date format if correct
            DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("uuuu-MM-dd");
            try{
                LocalDate date = LocalDate.parse(due_date, DATE_FORMAT.withResolverStyle(ResolverStyle.STRICT));
               }
             catch (Exception e){
                verifyDate=true;
             }


                //add project if doesnt exist
                if (verifyProject) {
                    if (!verifyTask && title!="") {
                        if(!verifyDate) {
                            for (int i = 0; i < listProject.size(); i++) {
                                if (listProject.get(i).getName_project().equalsIgnoreCase(projectName)) {

                                    listProject.get(i).getTaskList().add(new TaskModel(title, due_date, status, projectName));
                                }
                            }
                            System.out.println("Task added !");
                        }else {
                            System.out.println("Date or format invalid !");
                        }
                    } else {
                        System.out.println("Task already exist or task title empty");
                    }
                } else {
                    System.out.println("This project doesn't exist");
                }
            }


        public void updateTask() {
            //will be true if the project exist
            boolean exist = false;

            System.out.print("\n*** Updating Task *** \nEnter the Task title : ");
            String taskTitle = sc.nextLine();

            //going through all the projects
            for (int i = 0; i < listProject.size(); i++) {
                // going through tasks and print them out
                for (int j = 0; j < listProject.get(i).getTaskList().size(); j++) {
                    if (listProject.get(i).getTaskList().get(j).getTitle().equalsIgnoreCase(taskTitle)) {
                        exist = true;
                        listProject.get(i).getTaskList().remove(j);
                        System.out.print("******* New adding ******** ");
                        addTask();
                    }
                }
            }
            if(!exist){ System.out.println("This task doesn't exist... ");}
        }

        public void removeTask(){

            boolean verifyTask= false;

            System.out.print("\n*** Removing Task *** \nEnter the Task title : ");
            String title = sc.nextLine();
            // going through the task and deleting the task
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

            boolean verifyTask= false;

            System.out.print("\n*** Status Task *** \nEnter the Task title : ");
            String title = sc.nextLine();
            // going through the task and marking as done
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
