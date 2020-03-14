package com.todoApp;

import com.todoApp.Project.ProjectModel;
import com.todoApp.Task.TaskModel;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

import static com.todoApp.Project.CrudProject.listProject;

class file_Data {

    TaskModel task = new TaskModel();

    //writing in the file
    public void WriteInFile() {

        ArrayList<TaskModel> tasktList = new ArrayList<>();

        //fill the file with list of task
         for(int i = 0; i<listProject.size(); i++) {
               for (int j = 0; j < listProject.get(i).getTaskList().size(); j++) {
                   tasktList.add(listProject.get(i).getTaskList().get(j));
                }
             }

        //create file and write these objects in a file
        File f = new File("TaskDB.txt");

        try {
            //write in the file
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

        //create file and write these object to a file
        File f = new File("TaskDB.txt");
        if(f.exists() && f.length()!=0) {
            try {
                // read object from file
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

    public void addFileData(ArrayList<TaskModel> readTask) {

        HashSet<String> hashData = new HashSet();
        int counterProject = -1 ;

        //Adding project in the project list
        for (int i = 0; i < readTask.size(); i++) {
            hashData.add(readTask.get(i).getProject());
        }

        for (String prjName : hashData) {

            counterProject++;
            listProject.add(new ProjectModel(prjName));

            for (int i = 0; i < readTask.size()  ; i++) {

                if (prjName.equalsIgnoreCase(readTask.get(i).getProject())) {

                    listProject.get(counterProject).getTaskList().add(readTask.get(i));
                  }
                }
              }
          }
          
 }