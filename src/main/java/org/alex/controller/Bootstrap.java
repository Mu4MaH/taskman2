package org.alex.controller;

import org.alex.repository.ProjectRepository;
import org.alex.repository.TaskRepository;

import java.util.Scanner;

public class Bootstrap {

    private final ProjectRepository projects = new ProjectRepository();

    private final TaskRepository tasks = new TaskRepository();

    private final Scanner sc = new Scanner(System.in);

    public void execute() {
        System.out.println("-= Task manager v.2.0.0 greets you =-");
        System.out.print("Enter your command > ");

    }



}
