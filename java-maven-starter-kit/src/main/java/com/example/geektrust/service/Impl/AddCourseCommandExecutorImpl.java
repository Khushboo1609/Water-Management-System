package com.example.geektrust.service.Impl;

import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import com.example.geektrust.service.CommandExecutor;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AddCourseCommandExecutorImpl implements CommandExecutor {

    @Override
    public void executeCommand(TreeMap<String, Course> courses, Map<String, Course> registrationIdCourseMap, Command command) throws InvalidInputException {
        List<String> params = command.getCommandParams();
        Course course = constructCourseObject(params);
        offerCourse(courses , course);
    }

    private Course constructCourseObject(List<String> params) throws InvalidInputException {
        Course course = null;
        try{
            String courseName = params.get(0);
            String courseInstructor = params.get(1);
            SimpleDateFormat inputFormat = new SimpleDateFormat("ddMMyyyy");
            Date d = inputFormat.parse(params.get(2));
            int minCount = Integer.parseInt(params.get(3));
            int maxCount = Integer.parseInt(params.get(4));
            course = new Course("OFFERING-"+courseName+"-"+courseInstructor,courseName , courseInstructor , d ,minCount , maxCount , false, false);
        }catch (Exception e){
            throw new InvalidInputException("INPUT_ERROR");
        }
        return course;
    }

    private void offerCourse(TreeMap<String, Course> courses, Course course){
        courses.put(course.getCourseID(),course);
        System.out.println(course.getCourseID());
    }

}
