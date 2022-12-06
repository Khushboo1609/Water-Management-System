package com.example.geektrust.service;


import com.example.geektrust.concrete.CommandExecutionFactory;
import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AllotCourseCommandExecutorImplTest {


    Command command1;
    CommandExecutor executor;
    private TreeMap<String , Course> courses;
    private Map<String,Course> registrationIdCourseMap;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() throws InvalidInputException {
        System.setOut(new PrintStream(outContent));
        command1 = CommandService.getInstance().getCommandFromString("ALLOT OFFERING-JAVA-JAMES");
        executor = CommandExecutionFactory.getExecutor(command1);
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
    }


    @Test
    public void testExecute() {
        assertThrows(InvalidInputException.class , ()->executor.executeCommand(courses , registrationIdCourseMap , command1));
    }

}
