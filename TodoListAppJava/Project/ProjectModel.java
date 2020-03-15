package com.todoApp.Project;

import com.todoApp.Task.TaskModel;
import java.util.ArrayList;

public class ProjectModel {

    private String name_project;
    private  ArrayList<TaskModel> taskList=new ArrayList<>();

    public ProjectModel(String name_project){ this.name_project=name_project; }

    public ProjectModel(){ }

    public String getName_project(){
        return this.name_project;
    }
    public void setName_project(String name_project){
        this.name_project=name_project;
    }
    public ArrayList<TaskModel> getTaskList(){
        return taskList;
    }
    public void setTaskList(ArrayList<TaskModel> taskList){
        this.taskList=taskList;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name_project='" + name_project + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
