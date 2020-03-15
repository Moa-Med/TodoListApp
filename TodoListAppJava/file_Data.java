package com.todoApp;

import com.todoApp.Project.ProjectModel;
import com.todoApp.Task.TaskModel;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

import static com.todoApp.Project.CrudProject.listProject;

class file_Data {

    File f = new File("TaskDB.txt");

    public void WriteInFile() {

        ArrayList<TaskModel> tasktList = new ArrayList<>();

        //fill the new task array with list of task existing
         for(int i = 0; i<listProject.size(); i++) {
               for (int j = 0; j < listProject.get(i).getTaskList().size(); j++) {
                   tasktList.add(listProject.get(i).getTaskList().get(j));
                }
             }

        try {
            //writing the array in the file
            FileOutputStream fosFile = new FileOutputStream(f);
            ObjectOutputStream oosFile= new ObjectOutputStream(fosFile);
            oosFile.writeObject(tasktList);
            oosFile.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void ReadFromFile() {

        //if file exist and not empty read from it
        if(f.exists() && f.length()!=0) {
            try {
                // read the array object back from the ssame file
                FileInputStream fisTask = new FileInputStream("TaskDB.txt");
                ObjectInputStream oisTask = new ObjectInputStream(fisTask);

                ArrayList<TaskModel> readTask = (ArrayList<TaskModel>) oisTask.readObject();
                addFileData(readTask);
                oisTask.close();

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    //inserting the data task in todoApp arraylist
    public void addFileData(ArrayList<TaskModel> readTask) {

        HashSet<String> hashData = new HashSet();
        int counterProject = -1 ;

        //getting all projects in the tasks
        for (int i = 0; i < readTask.size(); i++) {
            hashData.add(readTask.get(i).getProject());
        }

        for (String prjName : hashData) {
            counterProject++;
            listProject.add(new ProjectModel(prjName));
            //adding the tasks in the array of corresponding project
            for (int i = 0; i < readTask.size()  ; i++) {
                if (prjName.equalsIgnoreCase(readTask.get(i).getProject())) {
                    listProject.get(counterProject).getTaskList().add(readTask.get(i));
                  }
                }
              }
          }
          
 }