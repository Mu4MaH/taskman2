package org.alex.controller;

import org.alex.command.AbstractCommand;
import org.alex.entity.Task;
import org.alex.repository.ProjectRepository;
import org.alex.repository.TaskRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bootstrap {

    private final Scanner sc = new Scanner(System.in);

    Map<String, AbstractCommand> commandMap = new HashMap<>();

    public void execute() {
        System.out.println("-= Task manager v.2.0.0 greets you =-");
        System.out.print("Enter your command > ");
        if (!commandMap.containsKey(sc.nextLine())) return;
        else {
            commandMap.get(sc.nextLine())
        }
    }

    public void register(String name, AbstractCommand command) {

    }

}
