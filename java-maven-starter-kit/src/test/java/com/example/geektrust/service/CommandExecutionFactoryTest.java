package com.example.geektrust.service;

import com.example.geektrust.concrete.CommandExecutionFactory;
import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.model.Command;
import com.example.geektrust.service.Impl.AddCourseCommandExecutorImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class CommandExecutionFactoryTest {

    Command command1;
    Command command2;

    @BeforeEach
    public void setUp() throws InvalidInputException {
        command1 = CommandService.getInstance().getCommandFromString("ADD-COURSE-OFFERING JAVA JAMES 15062022 1 2");
        command2 = CommandService.getInstance().getCommandFromString("REGISTER ANDY@GMAIL.COM OFFERING-JAVA-JAMES");
    }

    @Test
    public void getExecutorTest() {
        Assertions.assertTrue(CommandExecutionFactory.getExecutor(command1) instanceof AddCourseCommandExecutorImpl);
        Assertions.assertFalse(CommandExecutionFactory.getExecutor(command2) instanceof AddCourseCommandExecutorImpl);
    }
}


