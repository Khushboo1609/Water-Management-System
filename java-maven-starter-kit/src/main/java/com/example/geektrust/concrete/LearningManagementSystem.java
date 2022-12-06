package com.example.geektrust.concrete;

import com.example.geektrust.exception.CourseFullException;
import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import com.example.geektrust.service.CommandExecutor;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LearningManagementSystem {

    private final String organisationName;
    private final TreeMap<String , Course> courses;
    private final Map<String,Course> registrationIdCourseMap;

    public LearningManagementSystem(String name) {
        this.organisationName = name;
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }

    public void fulfillCommand(Command inputCommand) throws InvalidInputException {
        CommandExecutor commandExecutor = CommandExecutionFactory.getExecutor(inputCommand);
        try{
            commandExecutor.executeCommand(courses,registrationIdCourseMap, inputCommand);
        }catch(CourseFullException e ){
            System.out.println(e.getMessage());
        }
    }
}
