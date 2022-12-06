package com.example.geektrust.service;

import com.example.geektrust.exception.InvalidInputException;
import com.example.geektrust.model.Command;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileProcessorServiceTest {

    FileProcesserService service;

    @BeforeEach
    public void setUp() throws FileNotFoundException {
        service = new FileProcesserService("sample_input/input1.txt");
    }

    @Test
    public void FileProcesserServiceTest() {
        assertThrows(FileNotFoundException.class, () -> new FileProcesserService("abcd"));
    }

    @Test
    public void processLineTest() throws InvalidInputException, IOException {
        Command c = service.processLine();
        Assertions.assertNull(c);
    }

}