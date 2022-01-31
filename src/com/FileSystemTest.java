package com;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileSystemTest {
    private FileSystem fileSystem;
    private String[] input;

    @Before
    public void setUp() {
        fileSystem = new FileSystem();
        input = new String[] {"root", "folder1", "file.txt"};
    }

    @After
    public void tearDown() {
        fileSystem = null;
        input = null;
    }

    @Test
    public void getStorage() {
    }

    @Test
    public void elementAdd() {
    }

    @Test
    public void pathCreation() {
        //fileSystem.pathCreation(input);
    }
}