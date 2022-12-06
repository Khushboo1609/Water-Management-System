package com.example.geektrust;

import com.example.geektrust.concrete.LearningManagementSystem;
import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.FileProcesserService;


import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 1) {
                throw new FileNotFoundException("Input file is not supplied");
            } else {
                LearningManagementSystem lms = new LearningManagementSystem("Intuit");
                FileProcesserService fileProcesserService = new FileProcesserService(args[0]);
                try {
                    try {
                        Command command = fileProcesserService.processLine();
                        while (command != null) {
                            lms.fulfillCommand(command);
                            command = fileProcesserService.processLine();
                        }
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
