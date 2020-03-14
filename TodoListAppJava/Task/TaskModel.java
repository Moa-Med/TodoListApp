package com.todoApp.Task;

import java.io.Serializable;

public class TaskModel implements Serializable {

       private String title;
       private String due_date;
       private String status;
       private String project;

       public TaskModel(String title, String due_date, String status, String project) {
              this.title = title;
              this.due_date = due_date;
              this.status = status;
              this.project = project;
       }
       public TaskModel() {

       }

       public String getTitle() {
              return title;
       }

       public void setTitle(String title) {
              this.title = title;
       }

       public String getDue_date() {
              return due_date;
       }

       public void setDue_date(String due_date) {
              this.due_date = due_date;
       }

       public String getStatus() {
              return status;
       }

       public void setStatus(String status) {
              this.status = status;
       }

       public String getProject() {
              return project;
       }

       public void setProject(String project) {
              this.project = project;
       }

       @Override
       public String toString() {
              return "Task{" +
                      "title='" + title + '\'' +
                      ", due_date='" + due_date + '\'' +
                      ", status='" + status + '\'' +
                      ", project='" + project + '\'' +
                      '}';
       }
}



